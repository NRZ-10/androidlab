package com.example.registration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmail, loginPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        login = findViewById(R.id.login);

        SharedPreferences sp =
                getSharedPreferences("UserData", MODE_PRIVATE);

        String savedEmail =
                sp.getString("email", "");

        String savedPassword =
                sp.getString("password", "");

        login.setOnClickListener(v -> {

            String email =
                    loginEmail.getText().toString();

            String password =
                    loginPassword.getText().toString();

            if (email.equals(savedEmail) &&
                    password.equals(savedPassword)) {

                Toast.makeText(this,
                        "Login Successful",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this,
                        "Invalid Email or Password",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
