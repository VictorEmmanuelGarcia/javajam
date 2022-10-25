package com.example.tri_os;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextInputEditText emailRegister, firstname, middlename, lastname, password;
    private Button confirmRegister;
    private ProgressBar progressBar;
    private String em,fn,mn,ln,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        emailRegister = findViewById(R.id.emailRegister);
        firstname = findViewById(R.id.firstname);
        middlename = findViewById(R.id.middlename);
        lastname = findViewById(R.id.lastname);
        password = findViewById(R.id.password);
        confirmRegister = findViewById(R.id.confirmRegister);
        progressBar = findViewById(R.id.progressBar);

        confirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collectData();
            }
        });
    }
    public void collectData(){
        em = emailRegister.getText().toString().trim();
        fn = firstname.getText().toString();
        mn = middlename.getText().toString();
        ln = lastname.getText().toString();
        pw = password.getText().toString().trim();
        if(em.isEmpty()){
            emailRegister.setError("Email Address is required.");
            emailRegister.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            emailRegister.setError("Please provide a valid email.");
            emailRegister.requestFocus();
            return;
        }
        if(fn.isEmpty()){
            firstname.setError("First name is required.");
            firstname.requestFocus();
            return;
        }
        if(mn.isEmpty()){
            middlename.setError("Middle name is required.");
            middlename.requestFocus();
            return;
        }
        if(ln.isEmpty()){
            lastname.setError("Last name is required.");
            lastname.requestFocus();
            return;
        }
        if(pw.isEmpty()){
            password.setError("Password is required.");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(em, pw)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Name name = new Name(fn,mn,ln);
                            User user = new User(em, name);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(register.this, login.class));
                                        Toast.makeText(register.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(register.this, "Failed to register user! Try again.", Toast.LENGTH_LONG).show();
                                    }
                                    progressBar.setVisibility(View.GONE);
                                }
                            });
                        }
                        else{
                            Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}