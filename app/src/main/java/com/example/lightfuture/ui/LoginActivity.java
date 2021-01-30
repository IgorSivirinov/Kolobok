package com.example.lightfuture.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lightfuture.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;


public class LoginActivity extends AppCompatActivity {
    private TextInputLayout email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.til_email_activity_login);
        password = findViewById(R.id.til_password_activity_login);

        clearErrorEditText();
            findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkEmptyString()) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }


    private void clearErrorEditText(){
        email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                email.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                password.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private boolean checkEmptyString(){
        if (email.getEditText().getText().toString().trim().isEmpty()) email.setError("Пустое поле");
            else email.setError(null);
        if(password.getEditText().getText().toString().trim().isEmpty()) password.setError("Пустое поле");
            else password.setError(null);
        return !email.getEditText().getText().toString().trim().isEmpty() && !password.getEditText().getText().toString().trim().isEmpty();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
