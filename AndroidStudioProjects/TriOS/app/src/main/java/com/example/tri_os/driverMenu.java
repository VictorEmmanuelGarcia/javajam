package com.example.tri_os;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class driverMenu extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference reference, driverReference;
    private String userID;
    private TextView welcome, logout;
    private ProgressBar progressBar;
    private Animation rotateOpen, rotateClose, fromBottom, toBottom;
    private FloatingActionButton driverMenu,editDriver, addDriver, deleteDriver;
    private Boolean clicked = false;
    private String driverSelected;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        driverReference = FirebaseDatabase.getInstance().getReference("Drivers");
        userID = mUser.getUid();
        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);
        driverMenu = findViewById(R.id.driverMenu);
        editDriver = findViewById(R.id.editDriver);
        addDriver = findViewById(R.id.addDriver);
        deleteDriver = findViewById(R.id.deleteDriver);
        welcome = findViewById(R.id.welcome);
        logout = findViewById(R.id.logoutbtn);
        progressBar = findViewById(R.id.progressBar);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        loadDriverList();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(com.example.tri_os.driverMenu.this, login.class));
            }
        });
        driverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!clicked){
                    editDriver.setVisibility(View.VISIBLE);
                    addDriver.setVisibility(View.VISIBLE);
                    editDriver.startAnimation(fromBottom);
                    addDriver.startAnimation(fromBottom);
                    deleteDriver.startAnimation(fromBottom);
                    driverMenu.startAnimation(rotateOpen);
                    clicked = true;
                }else {
                    editDriver.setVisibility(View.INVISIBLE);
                    addDriver.setVisibility(View.INVISIBLE);
                    editDriver.startAnimation(toBottom);
                    addDriver.startAnimation(toBottom);
                    deleteDriver.startAnimation(toBottom);
                    driverMenu.startAnimation(rotateClose);
                    clicked = false;
                }
            }
        });
        addDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.tri_os.driverMenu.this, com.example.tri_os.addDriver.class));
            }
        });
        editDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.tri_os.driverMenu.this,editDriver.class));
            }
        });
        deleteDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.tri_os.driverMenu.this,deleteDriver.class));
            }
        });

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User admin = snapshot.getValue(User.class);
                if(admin != null){
                    Name fullName = admin.name;
                    welcome.setText("Welcome, Operator "+fullName.firstname+" "+fullName.lastname);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(com.example.tri_os.driverMenu.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void loadDriverList(){
        driverReference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Driver> drvList = new ArrayList<>();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Driver drv = dataSnapshot.getValue(Driver.class);
                    drvList.add(drv);
                }
                recyclerViewAdapter.setItems(drvList);
                recyclerViewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}