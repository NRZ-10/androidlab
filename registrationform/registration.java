package com.example.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, email, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        register.setOnClickListener(v -> {

            String n = name.getText().toString();
            String e = email.getText().toString();
            String p = password.getText().toString();

            SharedPreferences sp =
                    getSharedPreferences("UserData", MODE_PRIVATE);

            SharedPreferences.Editor editor = sp.edit();

            editor.putString("name", n);
            editor.putString("email", e);
            editor.putString("password", p);

            editor.apply();

            Toast.makeText(this,
                    "Registration Successful",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(
                    RegistrationActivity.this,
                    LoginActivity.class);

            startActivity(intent);
        });
    }
}
