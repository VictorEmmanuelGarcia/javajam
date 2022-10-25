package com.example.preferencesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDate;
import java.time.Month;

public class Page2 extends AppCompatActivity {
    TextInputEditText elementary, elementaryYear, highschool, highschoolYear, college;
    Button next,back;
    Intent intent;
    String el, elYear, high, highYear, coll;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEditor = sp.edit();
        getSupportActionBar().setTitle("Education Background");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        elementary = findViewById(R.id.elementary);
        elementaryYear = findViewById(R.id.elementaryYear);
        highschool = findViewById(R.id.highschool);
        highschoolYear = findViewById(R.id.highschoolYear);
        college = findViewById(R.id.college);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        restoreInputs();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(collectData()){
                    intent = new Intent(Page2.this, Page3.class);
                    startActivity(intent);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(collectData()){
                    onBackPressed();
                }
            }
        });
    }

    public boolean collectData(){
        String isEmptyFields = "Input must not be empty";
        boolean checker = true;
        el = elementary.getText().toString();
        if(el.isEmpty()){
            elementary.setHint(isEmptyFields);
            checker = false;
        }
        else{
            elementary.setHint("");
        }
        elYear = elementaryYear.getText().toString();
        if(elYear.isEmpty()){
            elementaryYear.setHint(isEmptyFields);
            checker = false;
        }
        else{
            elementaryYear.setHint("");
        }
        high = highschool.getText().toString();
        if(high.isEmpty()){
            highschool.setHint(isEmptyFields);
            checker = false;
        }
        else{
            highschool.setHint("");
        }
        highYear = highschoolYear.getText().toString();
        if(highYear.isEmpty()){
            highschoolYear.setHint(isEmptyFields);
            checker = false;
        }
        else{
            highschoolYear.setHint("");
        }
        coll = college.getText().toString();
        if(coll.isEmpty()){
            college.setHint(isEmptyFields);
            checker = false;
        }
        else{
            college.setHint("");
        }

        spEditor.putString("el",el);
        spEditor.commit();
        spEditor.putString("elYear",elYear);
        spEditor.commit();
        spEditor.putString("high",high);
        spEditor.commit();
        spEditor.putString("highYear",highYear);
        spEditor.commit();
        spEditor.putString("coll",coll);
        spEditor.commit();
        return checker;
    }

    public void restoreInputs(){
        if(elementary.getText().toString() != null){
            elementary.setText(sp.getString("el",""));
        }
        if(elementaryYear.getText().toString() != null){
            elementaryYear.setText(sp.getString("elYear",""));
        }
        if(highschool.getText().toString() != null){
            highschool.setText(sp.getString("high",""));
        }
        if(highschoolYear.getText().toString() != null){
            highschoolYear.setText(sp.getString("highYear",""));
        }
        if(college.getText().toString() != null){
            college.setText(sp.getString("coll",""));
        }
    }
}