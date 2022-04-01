package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class LaunchScreen extends AppCompatActivity {

    SharedPreferences prefs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);

        prefs = getSharedPreferences("com.example.worldcinema", MODE_PRIVATE);
        Intent intent;

        if (prefs.getBoolean("firstrun", true)) {
            intent = new Intent(this, SignUpScreen.class);
            prefs.edit().putBoolean("firstrun", false).commit();
        } else {
            intent = new Intent(this, SignInScreen.class);
        }

        startActivity(intent);
    }
}