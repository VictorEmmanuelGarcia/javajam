package com.example.jeepcode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button getRoute;
    private TextInputEditText jcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRoute = findViewById(R.id.getRoute);
        jcode = findViewById(R.id.jcode);
        getRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locateRoute();
            }
        });
    }
    public void locateRoute(){
        String finalCode = "";
        HashMap<String, Integer> checker = new HashMap<>();
        try{
            String code = jcode.getText().toString();
            if(code.isEmpty()){
                throw new Exception("Code should not be empty!");
            }
            if(!Character.isDigit(code.charAt(0)) || Character.isDigit(code.charAt(code.length()-1))){
                throw new Exception("Invalid input!");
            }

            String[] splitCode = code.split(","); // splitted into a string array by removing ","
            for(int i = 0; i < splitCode.length; i++){
                splitCode[i] = splitCode[i].trim(); // remove whitespaces
                finalCode += splitCode[i] + ","; //placeholder to send in php file or url
            }
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            String url = "http://192.168.1.3/Platdev/displayJeepRoute.php";//changeable ipv4 address
            String finalCode1 = finalCode;
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Routes Discovered");
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                for(int i = 0; i < splitCode.length; i++){
                                    JSONArray jsonArray = jsonObject.getJSONArray(splitCode[i]);
                                    splitCode[i] += " => ";

                                    for(int j = 0; j < jsonArray.length(); j++){
                                        String index = jsonArray.getString(j);//get current string
                                        if(checker.containsKey(index)){
                                            checker.put(index, checker.get(index) + 1);//update the current's string key as found duplicate + 1
                                        }else{
                                            checker.put(index, 1);//store current string
                                        }

                                        if(j != jsonArray.length()-1){
                                            splitCode[i] += jsonArray.get(j) + " &lt;=&gt; ";
                                        } else{
                                            splitCode[i] += jsonArray.get(j) + ",<br/><br/>";
                                        }
                                    }
                                }
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                            StringBuffer sb = new StringBuffer();
                            for(int i = 0; i < splitCode.length; i++){
                                sb.append(splitCode[i]);
                            }
                            String holder = "";//apply color holder
                            String receiver = sb.toString();
                            for(String key: checker.keySet()) {
                                if (checker.get(key) > 1) {
                                    holder = "<font color ='" +colorGenerator()+ "'>" + key + "</font>";
                                    receiver = receiver.replaceAll(key,holder);
                                }
                            }
                            alertDialog.setMessage(Html.fromHtml(receiver));
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }){
                @Override
                protected Map<String,String> getParams(){ // this is to send a data
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("jcode", finalCode1); // name of key, and ang specific data to send
                    return params;
                }
            };
            queue.add(stringRequest);
        }catch(Exception ex){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("ALERT");
            alertDialog.setMessage(ex.getMessage());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
    public String colorGenerator(){
        Random random = new Random();
        int nextInt = random.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", nextInt);
        return colorCode;
    }
}