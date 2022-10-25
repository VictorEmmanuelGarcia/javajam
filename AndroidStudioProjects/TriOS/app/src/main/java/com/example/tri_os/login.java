package com.example.tri_os;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private ProgressBar progressBar;
    private TextView registerbtn,forgotPassword;
    private Button loginbtn;
    private TextInputEditText emailLogin, password;
    private String em,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        loginbtn = findViewById(R.id.loginbtn);
        emailLogin = findViewById(R.id.emailLogin);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        registerbtn = findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, register.class));
            }
        });
        forgotPassword = findViewById(R.id.forgotpassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, resetPassword.class));
            }
        });
    }
    public void userLogin(){
        em = emailLogin.getText().toString();
        pw = password.getText().toString();
        if(em.isEmpty()){
            emailLogin.setError("Email Address is required.");
            emailLogin.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            emailLogin.setError("Please provide a valid email.");
            emailLogin.requestFocus();
            return;
        }
        if(pw.isEmpty()){
            password.setError("Password is required.");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(em, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    mUser = mAuth.getCurrentUser();
                    if(mUser.isEmailVerified()){
                        startActivity(new Intent(login.this, driverMenu.class));
                    }else{
                        mUser.sendEmailVerification();
                        Toast.makeText(login.this, "Check your email to verify your account.", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(login.this, "Failed to login! Please check your credentials.", Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}