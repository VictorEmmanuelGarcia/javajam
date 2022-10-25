package com.example.preferencesandintents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Page3 extends AppCompatActivity {
    private TextInputEditText skill1, skill2, skill3, skill4, skill5;
    private Button next,back;
    private Intent intent;
    String s1, s2, s3, s4, s5;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEditor = sp.edit();
        getSupportActionBar().setTitle("Skills");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        skill1 = findViewById(R.id.skill1);
        skill2 = findViewById(R.id.skill2);
        skill3 = findViewById(R.id.skill3);
        skill4 = findViewById(R.id.skill4);
        skill5 = findViewById(R.id.skill5);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        restoreInputs();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Page3.this, Page4.class);
                collectData();

                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collectData();
                onBackPressed();
            }
        });
    }
    public void collectData(){
        s1 = skill1.getText().toString();
        s2 = skill2.getText().toString();
        s3 = skill3.getText().toString();
        s4 = skill4.getText().toString();
        s5 = skill5.getText().toString();

        spEditor.putString("s1",s1);
        spEditor.commit();
        spEditor.putString("s2",s2);
        spEditor.commit();
        spEditor.putString("s3",s3);
        spEditor.commit();
        spEditor.putString("s4",s4);
        spEditor.commit();
        spEditor.putString("s5",s5);
        spEditor.commit();
    }
    public void restoreInputs(){
        if(skill1.getText().toString() != null){
            skill1.setText(sp.getString("s1",""));
        }
        if(skill2.getText().toString() != null){
            skill2.setText(sp.getString("s2",""));
        }
        if(skill3.getText().toString() != null){
            skill3.setText(sp.getString("s3",""));
        }
        if(skill4.getText().toString() != null){
            skill4.setText(sp.getString("s4",""));
        }
        if(skill5.getText().toString() != null){
            skill5.setText(sp.getString("s5",""));
        }
    }
}
