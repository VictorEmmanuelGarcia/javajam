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
import com.google.firebase.auth.FirebaseAuth;

public class resetPassword extends AppCompatActivity {
    private TextInputEditText existingEmail;
    private Button resetPasswordbtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private String em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        mAuth = FirebaseAuth.getInstance();

        existingEmail = findViewById(R.id.existingEmail);
        resetPasswordbtn = findViewById(R.id.resetPasswordbtn);
        progressBar = findViewById(R.id.progressBar);

        resetPasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordReset();
            }
        });
    }
    public void passwordReset(){
        em = existingEmail.getText().toString();
        if(em.isEmpty()){
            existingEmail.setError("Email Address is required.");
            existingEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            existingEmail.setError("Please provide a valid email.");
            existingEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(resetPassword.this, "Check your email to reset your password!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(resetPassword.this, login.class));
                }
                else{
                    Toast.makeText(resetPassword.this, "Something went wrong! Please try again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}