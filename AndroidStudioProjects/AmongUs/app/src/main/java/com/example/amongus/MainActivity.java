package com.example.amongus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.HashSet;


public class MainActivity extends AppCompatActivity {
    CrewGenerator newCrew;
    int crewCounter = -1;
    HashMap<Integer, Character> clickCheck;
    HashSet<Integer> countCheck;
    HashSet<Integer> checkClick;

    char[] reverseAlphabet = new char[]{'Z','Y', 'X', 'W', 'V', 'U','T','S','R'};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickCheck = new HashMap<>();
        countCheck = new HashSet<>();
        newCrew = new CrewGenerator();
        Button BTNRESET = findViewById(R.id.BTNRESET);
        BTNRESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    public void isCrew(Button b){
        if(!clickCheck.containsKey(b.getId())){
            crewCounter++;
            clickCheck.put(b.getId(),reverseAlphabet[crewCounter]);
            b.setText(reverseAlphabet[crewCounter]+"");
            b.setEnabled(false);

        }
        else{
            b.setText(clickCheck.get(b.getId())+"");
            b.setEnabled(false);

        }
        if(!countCheck.contains(b.getId())){
            countCheck.add(b.getId());
        }
    }

    public void isImpostor(Button b){
        Button BTN1 = findViewById(R.id.BTN1);
        Button BTN2 = findViewById(R.id.BTN2);
        Button BTN3 = findViewById(R.id.BTN3);
        Button BTN4 = findViewById(R.id.BTN4);
        Button BTN5 = findViewById(R.id.BTN5);
        Button BTN6 = findViewById(R.id.BTN6);
        Button BTN7 = findViewById(R.id.BTN7);
        Button BTN8 = findViewById(R.id.BTN8);
        Button BTN9 = findViewById(R.id.BTN9);
        if(countCheck.size() == 8){
            b.setText(Character.toString(reverseAlphabet[crewCounter+1]));
            BTN1.setEnabled(false);
            BTN2.setEnabled(false);
            BTN3.setEnabled(false);
            BTN4.setEnabled(false);
            BTN5.setEnabled(false);
            BTN6.setEnabled(false);
            BTN7.setEnabled(false);
            BTN8.setEnabled(false);
            BTN9.setEnabled(false);
        }
        else{
            BTN1.setText("");
            BTN2.setText("");
            BTN3.setText("");
            BTN4.setText("");
            BTN5.setText("");
            BTN6.setText("");
            BTN7.setText("");
            BTN8.setText("");
            BTN9.setText("");
            BTN1.setEnabled(true);
            BTN2.setEnabled(true);
            BTN3.setEnabled(true);
            BTN4.setEnabled(true);
            BTN5.setEnabled(true);
            BTN6.setEnabled(true);
            BTN7.setEnabled(true);
            BTN8.setEnabled(true);
            BTN9.setEnabled(true);
            countCheck.clear();
        }
    }
    public void clicked(View view){
        Button b = (Button) view;
        switch(b.getId()){
            case R.id.BTN1: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN2: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN3: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN4: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN5: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN6: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN7: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN8: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
            case R.id.BTN9: if(newCrew.yesNo(b.getId())){ isCrew(b); }else{ isImpostor(b); } break;
        }
    }

}