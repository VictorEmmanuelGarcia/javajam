package com.example.tri_os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addDriver extends AppCompatActivity {
    private FirebaseDatabase mDb;
    private DatabaseReference databaseReference;
    private TextInputEditText nickName, fullName, address, contactNum, licenseNum, expirationDate;
    private Button registerDriver;
    private ProgressBar progressBar;
    private String nn, fn, ha, cn, ln, ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        mDb = FirebaseDatabase.getInstance();
        nickName = findViewById(R.id.nickname);
        fullName = findViewById(R.id.fullname);
        address = findViewById(R.id.address);
        contactNum = findViewById(R.id.contact);
        licenseNum = findViewById(R.id.licenseNumber);
        expirationDate = findViewById(R.id.licenseExpiryDate);
        progressBar = findViewById(R.id.progressBar);
        registerDriver = findViewById(R.id.registerDriver);
        registerDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupDriver();
            }
        });
    }
    public void signupDriver(){
        nn = nickName.getText().toString();
        fn = fullName.getText().toString();
        ha = address.getText().toString();
        cn = contactNum.getText().toString();
        ln = licenseNum.getText().toString();
        ed = expirationDate.getText().toString();
        if(nn.isEmpty()){
            nickName.setError("Nickname is required.");
            nickName.requestFocus();
            return;
        }
        if(fn.isEmpty()){
            fullName.setError("Full Name is required.");
            fullName.requestFocus();
            return;
        }
        if(ha.isEmpty()){
            address.setError("Home Address is required.");
            address.requestFocus();
            return;
        }
        if(cn.isEmpty()){
            contactNum.setError("Contact Number is required.");
            contactNum.requestFocus();
            return;
        }
        if(ln.isEmpty()){
            licenseNum.setError("License Number is required.");
            licenseNum.requestFocus();
            return;
        }
        if(ed.isEmpty()){
            expirationDate.setError("Expiration Date is required.");
            expirationDate.requestFocus();
            return;
        }
        Driver newDriver = new Driver(nn,fn,ha,cn,ln,ed);
        progressBar.setVisibility(View.VISIBLE);
        databaseReference = mDb.getReference("Drivers");
        databaseReference.child(nn).setValue(newDriver).addOnSuccessListener(suc ->
        {
            Toast.makeText(this,"A new driver has been registered.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(addDriver.this, driverMenu.class));
            progressBar.setVisibility(View.GONE);
        }).addOnFailureListener(er ->
        {
            Toast.makeText(this,er.getMessage(), Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        });
    }
}