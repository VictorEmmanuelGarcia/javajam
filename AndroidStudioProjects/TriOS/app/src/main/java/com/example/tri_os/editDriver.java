package com.example.tri_os;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class editDriver extends AppCompatActivity {
    private FirebaseDatabase mDb;
    private DatabaseReference databaseReference;
    private TextInputEditText newFullName, newAddress, newContactNum, newLicenseNum, newExpirationDate;
    private Button updateDriver;
    private ProgressBar progressBar;
    private AutoCompleteTextView selectedDriver;
    private ArrayList<String> driverList;
    private ArrayAdapter<String> drivers;
    private String fn, ha, cn, ln, ed;
    private String driverSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_driver);
        mDb = FirebaseDatabase.getInstance();
        databaseReference = mDb.getReference("Drivers");
        newFullName = findViewById(R.id.newFullName);
        newAddress = findViewById(R.id.newAddress);
        newContactNum = findViewById(R.id.newContact);
        newLicenseNum = findViewById(R.id.newLicense);
        newExpirationDate = findViewById(R.id.newLicenseExpiryDate);
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
                databaseReference.child(selected).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        newFullName.setText(snapshot.child("fullName").getValue().toString());
                        newAddress.setText(snapshot.child("address").getValue().toString());
                        newContactNum.setText(snapshot.child("contactNum").getValue().toString());
                        newLicenseNum.setText(snapshot.child("licenseNum").getValue().toString());
                        newExpirationDate.setText(snapshot.child("expirationDate").getValue().toString());
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        System.out.println(error.getMessage());
                    }
                });
            }
        });
        updateDriver = findViewById(R.id.updateDriver);
        updateDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDriver();
            }
        });
    }
    public void updateDriver(){
        fn = newFullName.getText().toString();
        ha = newAddress.getText().toString();
        cn = newContactNum.getText().toString();
        ln = newLicenseNum.getText().toString();
        ed = newExpirationDate.getText().toString();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("fullName", fn);
        hashMap.put("address", ha);
        hashMap.put("contactNum",cn);
        hashMap.put("licenseNum",ln);
        hashMap.put("expirationDate",ed);
        databaseReference.child(driverSelected).updateChildren(hashMap).addOnSuccessListener(suc ->
        {
            Toast.makeText(this,"Driver "+driverSelected+" has been updated.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(editDriver.this, driverMenu.class));
            progressBar.setVisibility(View.GONE);
        }).addOnFailureListener(er ->
        {
            Toast.makeText(this,er.getMessage(), Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        });
    }
}