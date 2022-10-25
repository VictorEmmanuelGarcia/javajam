package com.example.preferencesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Contacts;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextInputEditText firstName, middleName, lastName, birthday, gender;
    Button next;
    Intent intent;
    String fn, mn, ln, bd, g;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEditor = sp.edit();
        getSupportActionBar().setTitle("Basic Info");

        if(!sp.getAll().isEmpty()){
            spEditor.clear().commit();
        }

        firstName = findViewById(R.id.firstName);
        middleName = findViewById(R.id.middleName);
        lastName = findViewById(R.id.lastName);
        birthday = findViewById(R.id.birthday);
        gender = findViewById(R.id.gender);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(collectData()){
                    intent = new Intent(MainActivity.this, Page2.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean collectData(){
        String isEmptyFields = "Input must not be empty";
        boolean checker = true;
        fn = firstName.getText().toString();
        if(fn.isEmpty()){
            firstName.setHint(isEmptyFields);
            checker = false;
        }
        else{
            firstName.setHint("");
        }
        mn = middleName.getText().toString();

        if(mn.isEmpty()){
            middleName.setHint(isEmptyFields);
            checker = false;
        }
        else{
            middleName.setHint("");
        }
        ln = lastName.getText().toString();
        if(ln.isEmpty()){
            lastName.setHint(isEmptyFields);
            checker = false;
        }
        else{
            lastName.setHint("");
        }
        bd = birthday.getText().toString();
        if(bd.isEmpty()){
            birthday.setHint(isEmptyFields);
            checker = false;
        }
        else{
            birthday.setHint("");
        }
        g = gender.getText().toString();
        if(g.isEmpty()){
            gender.setHint(isEmptyFields);
            checker = false;
        }
        else{
            gender.setHint("");
        }
        if(isValidDate(bd)){
            String[]dateParts = bd.split("/");
            bd = dateParts[2] + "-" + dateParts[0] + "-" + dateParts[1];
            bd.replaceAll("/","-");
            LocalDate date = LocalDate.parse(bd);
            Month month = date.getMonth();
            int day = date.getDayOfMonth();
            int year = date.getYear();
            bd = ""+month+" "+day+", "+year+"";
        }

        spEditor.putString("fn",fn);
        spEditor.commit();
        spEditor.putString("mn",mn);
        spEditor.commit();
        spEditor.putString("ln",ln);
        spEditor.commit();
        spEditor.putString("bd",bd);
        spEditor.commit();
        spEditor.putString("g",g);
        spEditor.commit();
        return checker;
    }
    public boolean isValidDate(String birthday){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthday);
        }catch(ParseException pe){
            return false;
        }catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}