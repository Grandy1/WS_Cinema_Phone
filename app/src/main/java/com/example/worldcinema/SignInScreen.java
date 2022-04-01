package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SignInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        Button sign_up_button = findViewById(R.id.sign_up);

        sign_up_button.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpScreen.class);
            startActivity(intent);
        });
    }
}