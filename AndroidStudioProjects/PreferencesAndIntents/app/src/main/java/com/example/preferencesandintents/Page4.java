package com.example.preferencesandintents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Page4 extends AppCompatActivity {
    TextView basicInfo1, basicInfo2, basicInfo3, educBac1, educBac2, educBac3, skillEnd1, skillEnd2, skillEnd3, skillEnd4, skillEnd5;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        getSupportActionBar().setTitle("Summary");
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEditor = sp.edit();
        basicInfo1 = findViewById(R.id.basicInfo1);
        basicInfo2 = findViewById(R.id.basicInfo2);
        basicInfo3 = findViewById(R.id.basicInfo3);
        educBac1 = findViewById(R.id.educBac1);
        educBac2 = findViewById(R.id.educBac2);
        educBac3 = findViewById(R.id.educBac3);
        skillEnd1 = findViewById(R.id.skillEnd1);
        skillEnd2 = findViewById(R.id.skillEnd2);
        skillEnd3 = findViewById(R.id.skillEnd3);
        skillEnd4 = findViewById(R.id.skillEnd4);
        skillEnd5 = findViewById(R.id.skillEnd5);
        displayData();
    }
    public void displayData(){
        basicInfo1.setText(sp.getString("fn","") + " " + sp.getString("mn","") + " " + sp.getString("ln",""));
        basicInfo2.setText(sp.getString("bd",""));
        basicInfo3.setText(sp.getString("g",""));
        educBac1.setText(sp.getString("el","") + ", " + sp.getString("elYear",""));
        educBac2.setText(sp.getString("high","") + ", " + sp.getString("highYear",""));
        educBac3.setText(sp.getString("coll","") + ", Present");
        skillEnd1.setText(sp.getString("s1",""));
        skillEnd2.setText(sp.getString("s2",""));
        skillEnd3.setText(sp.getString("s3",""));
        skillEnd4.setText(sp.getString("s4",""));
        skillEnd5.setText(sp.getString("s5",""));
    }
}
