package com.example.tri_os;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class displayDriverDetails extends AppCompatActivity {
    private FirebaseDatabase mDb;
    private DatabaseReference driverReference;
    private TextView driverNickName, driverFullName, driverAddress, driverContactNum, driverLicenseNum, driverLicenseExpiryDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_driver_details);
        mDb = FirebaseDatabase.getInstance();
        driverReference = FirebaseDatabase.getInstance().getReference("Drivers");
        driverNickName = findViewById(R.id.driverNickname);
        driverFullName = findViewById(R.id.driverFullName);
        driverAddress = findViewById(R.id.driverAddress);
        driverContactNum = findViewById(R.id.driverContact);
        driverLicenseNum = findViewById(R.id.driverLicense);
        driverLicenseExpiryDate = findViewById(R.id.driverLicenseExpiryDate);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedDriver = extras.getString("selectedDriver");
            driverReference.child(selectedDriver).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    driverNickName.setText(snapshot.child("nickname").getValue().toString());
                    driverFullName.setText(snapshot.child("fullName").getValue().toString());
                    driverAddress.setText(snapshot.child("address").getValue().toString());
                    driverContactNum.setText(snapshot.child("contactNum").getValue().toString());
                    driverLicenseNum.setText(snapshot.child("licenseNum").getValue().toString());
                    driverLicenseExpiryDate.setText(snapshot.child("expirationDate").getValue().toString());
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    System.out.println(error.getMessage());
                }
            });
        }

    }
}