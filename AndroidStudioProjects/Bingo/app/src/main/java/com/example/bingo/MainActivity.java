package com.example.bingo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextInputEditText gameCode;
    Button BTN1, BTN2, BTN3, BTN4, BTN5, BTN6, BTN7, BTN8, BTN9, BTN10, BTN11, BTN12, BTN13, BTN14, BTN15, BTN16, BTN17, BTN18, BTN19, BTN20, BTN21, BTN22, BTN23, BTN24, BTN25, BTN_enterGame, BTN_bingo;
    String playerToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        gameCode = findViewById(R.id.gameCode);
        BTN1 = findViewById(R.id.BTN1);
        BTN2 = findViewById(R.id.BTN2);
        BTN3 = findViewById(R.id.BTN3);
        BTN4 = findViewById(R.id.BTN4);
        BTN5 = findViewById(R.id.BTN5);
        BTN6 = findViewById(R.id.BTN6);
        BTN7 = findViewById(R.id.BTN7);
        BTN8 = findViewById(R.id.BTN8);
        BTN9 = findViewById(R.id.BTN9);
        BTN10 = findViewById(R.id.BTN10);
        BTN11 = findViewById(R.id.BTN11);
        BTN12 = findViewById(R.id.BTN12);
        BTN13 = findViewById(R.id.BTN13);
        BTN14 = findViewById(R.id.BTN14);
        BTN15 = findViewById(R.id.BTN15);
        BTN16 = findViewById(R.id.BTN16);
        BTN17 = findViewById(R.id.BTN17);
        BTN18 = findViewById(R.id.BTN18);
        BTN19 = findViewById(R.id.BTN19);
        BTN20 = findViewById(R.id.BTN20);
        BTN21 = findViewById(R.id.BTN21);
        BTN22 = findViewById(R.id.BTN22);
        BTN23 = findViewById(R.id.BTN23);
        BTN24 = findViewById(R.id.BTN24);
        BTN25 = findViewById(R.id.BTN25);
        BTN_enterGame = findViewById(R.id.BTN_enterGame);
        BTN_bingo = findViewById(R.id.BTN_bingo);
        gameCode = findViewById(R.id.gameCode);

        BTN_enterGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectGame();
                BTN1.setEnabled(true);
                BTN2.setEnabled(true);
                BTN3.setEnabled(true);
                BTN4.setEnabled(true);
                BTN5.setEnabled(true);
                BTN6.setEnabled(true);
                BTN7.setEnabled(true);
                BTN8.setEnabled(true);
                BTN9.setEnabled(true);
                BTN10.setEnabled(true);
                BTN11.setEnabled(true);
                BTN12.setEnabled(true);
                BTN13.setEnabled(true);
                BTN14.setEnabled(true);
                BTN15.setEnabled(true);
                BTN16.setEnabled(true);
                BTN17.setEnabled(true);
                BTN18.setEnabled(true);
                BTN19.setEnabled(true);
                BTN20.setEnabled(true);
                BTN20.setEnabled(true);
                BTN21.setEnabled(true);
                BTN22.setEnabled(true);
                BTN23.setEnabled(true);
                BTN24.setEnabled(true);
                BTN25.setEnabled(true);
            }
        });

        BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN1.setEnabled(false);
            }
        });
        BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN2.setEnabled(false);
            }
        });
        BTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN3.setEnabled(false);
            }
        });
        BTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN4.setEnabled(false);
            }
        });
        BTN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN5.setEnabled(false);
            }
        });
        BTN6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN6.setEnabled(false);
            }
        });
        BTN7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN7.setEnabled(false);
            }
        });
        BTN8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN8.setEnabled(false);
            }
        });
        BTN9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN9.setEnabled(false);
            }
        });
        BTN10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN10.setEnabled(false);
            }
        });
        BTN11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN11.setEnabled(false);
            }
        });
        BTN12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN12.setEnabled(false);
            }
        });
        BTN13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN13.setEnabled(false);
            }
        });
        BTN14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN14.setEnabled(false);
            }
        });
        BTN15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN15.setEnabled(false);
            }
        });
        BTN16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN16.setEnabled(false);
            }
        });
        BTN17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN17.setEnabled(false);
            }
        });
        BTN18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN18.setEnabled(false);
            }
        });
        BTN19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN19.setEnabled(false);
            }
        });
        BTN20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN20.setEnabled(false);
            }
        });
        BTN21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN21.setEnabled(false);
            }
        });
        BTN22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN22.setEnabled(false);
            }
        });
        BTN23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN23.setEnabled(false);
            }
        });
        BTN23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN23.setEnabled(false);
            }
        });
        BTN24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN24.setEnabled(false);
            }
        });
        BTN25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTN25.setEnabled(false);
            }
        });
        BTN_bingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishBingo();
            }
        });
    }

    public void connectGame(){
        String codeInput = gameCode.getText().toString();
        try{
            if(codeInput.isEmpty()){
                throw new Exception("Game Code should not be empty.");
            }
            if(codeInput.contains(" ")){
                throw new Exception("Game Code should not have spaces.");
            }
            if(codeInput.length() < 8){
                throw new Exception("Game Code should contain 8 characters.");
            }
        }catch (Exception e){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("ALERT");
            alertDialog.setMessage(e.getMessage());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        try {
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            String url = "http://www.hyeumine.com/getcard.php?bcode=" + codeInput;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                parseString(response);
                            } catch (JSONException e) {
                                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                                alertDialog.setTitle("ALERT");
                                alertDialog.setMessage("Game not found");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    gameCode.setText(error.toString());
                }
            });
            queue.add(stringRequest);
        } catch (Exception ex) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("ALERT");
            alertDialog.setMessage("Game not found");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
    public void parseString(String stringjson) throws JSONException {
        JSONObject json = new JSONObject(stringjson);
        playerToken = json.getString("playcard_token");
        JSONObject json2 = json.getJSONObject("card");
        storeB_cards(json2.getJSONArray("B"));
        storeI_cards(json2.getJSONArray("I"));
        storeN_cards(json2.getJSONArray("N"));
        storeG_cards(json2.getJSONArray("G"));
        storeO_cards(json2.getJSONArray("O"));
    }

    public void storeB_cards(JSONArray jsonArray) throws JSONException {
        BTN1.setText(jsonArray.getInt(0) + "");
        BTN6.setText(jsonArray.getInt(1) + "");
        BTN11.setText(jsonArray.getInt(2) + "");
        BTN16.setText(jsonArray.getInt(3) + "");
        BTN21.setText(jsonArray.getInt(4) + "");
    }
    public void storeI_cards(JSONArray jsonArray) throws JSONException {
        BTN2.setText(jsonArray.getInt(0) + "");
        BTN7.setText(jsonArray.getInt(1) + "");
        BTN12.setText(jsonArray.getInt(2) + "");
        BTN17.setText(jsonArray.getInt(3) + "");
        BTN22.setText(jsonArray.getInt(4) + "");
    }
    public void storeN_cards(JSONArray jsonArray) throws JSONException {
        BTN3.setText(jsonArray.getInt(0) + "");
        BTN8.setText(jsonArray.getInt(1) + "");
        BTN13.setText(jsonArray.getInt(2) + "");
        BTN18.setText(jsonArray.getInt(3) + "");
        BTN23.setText(jsonArray.getInt(4) + "");
    }
    public void storeG_cards(JSONArray jsonArray) throws JSONException {
        BTN4.setText(jsonArray.getInt(0) + "");
        BTN9.setText(jsonArray.getInt(1) + "");
        BTN14.setText(jsonArray.getInt(2) + "");
        BTN19.setText(jsonArray.getInt(3) + "");
        BTN24.setText(jsonArray.getInt(4) + "");
    }
    public void storeO_cards(JSONArray jsonArray) throws JSONException {
        BTN5.setText(jsonArray.getInt(0) + "");
        BTN10.setText(jsonArray.getInt(1) + "");
        BTN15.setText(jsonArray.getInt(2) + "");
        BTN20.setText(jsonArray.getInt(3) + "");
        BTN25.setText(jsonArray.getInt(4) + "");
    }

    public void finishBingo(){
        try {
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            String url = "http://www.hyeumine.com/checkwin.php?playcard_token=" + playerToken;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            displayResult(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    gameCode.setText(error.toString());
                }
            });
            queue.add(stringRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void displayResult(String response){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("RESULTS");
        if(Integer.parseInt(response) == 1){
            alertDialog.setMessage("Bingo! You have won the game!");
        }
        else{
            alertDialog.setMessage("Better luck next time!");
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}