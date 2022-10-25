package com.example.tri_os;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class deleteDriver extends AppCompatActivity {
    private FirebaseDatabase mDb;
    private DatabaseReference databaseReference;
    private Button deleteDriver;
    private ProgressBar progressBar;
    private AutoCompleteTextView selectedDriver;
    private ArrayList<String> driverList;
    private ArrayAdapter<String> drivers;
    private String driverSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_driver);
        mDb = FirebaseDatabase.getInstance();
        databaseReference = mDb.getReference("Drivers");
        progressBar = findViewById(R.id.progressBar);
        selectedDriver = findViewById(R.id.selectedDriver);
        driverList = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String driverNickNames = dataSnapshot.getKey();
                    driverList.add(driverNickNames);//to store in arraylist
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        drivers = new ArrayAdapter<String>(this, R.layout.driver_list, driverList);
        selectedDriver.setAdapter(drivers);
        selectedDriver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                driverSelected = selected;
            }
        });
        deleteDriver = findViewById(R.id.deleteDriver);
        deleteDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeDriver(driverSelected);
            }
        });
    }
    public void removeDriver(String driverSelected){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to remove Driver "+driverSelected+"?");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        databaseReference.child(driverSelected).removeValue().addOnSuccessListener(suc ->
                        {
                            Toast.makeText(deleteDriver.this,"Driver "+driverSelected+" has been removed.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(deleteDriver.this, driverMenu.class));
                            progressBar.setVisibility(View.GONE);
                        }).addOnFailureListener(er ->
                        {
                            Toast.makeText(deleteDriver.this,er.getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        });
                    }
                });
        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}