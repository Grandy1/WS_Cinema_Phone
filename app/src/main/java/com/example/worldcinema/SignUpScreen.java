package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class SignUpScreen extends AppCompatActivity {

    String user_name;
    String user_last_name;
    String user_e_mail;
    String user_pass;
    String user_pass_ag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);



        EditText auth_name = findViewById(R.id.auth_name);
        EditText auth_last_name = findViewById(R.id.auth_last_name);
        EditText auth_e_mail = findViewById(R.id.auth_e_mail);
        EditText auth_pass = findViewById(R.id.auth_pass);
        EditText auth_pass_again = findViewById(R.id.auth_pass_again);

        Button sign_up = findViewById(R.id.sign_up_button);
        Button sign_in = findViewById(R.id.sign_in_button);

        sign_in.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInScreen.class);
            startActivity(intent);
        });

        sign_up.setOnClickListener(v -> {
            user_name = auth_name.getText().toString();
            user_last_name = auth_last_name.getText().toString();
            user_e_mail = auth_e_mail.getText().toString();
            user_pass = auth_pass.getText().toString();
            user_pass_ag = auth_pass_again.getText().toString();

            if (!user_name.isEmpty() & !user_last_name.isEmpty() & !user_e_mail.isEmpty() & !user_pass.isEmpty() & !user_pass_ag.isEmpty() & CorrectMail(user_e_mail) &
                user_pass == user_pass_ag) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    boolean CorrectMail(String e_mail) {
        String[] elems = e_mail.split("@,");
        String name = elems[0];
        name = name.toLowerCase(Locale.ROOT);
        String l2d = elems[1];
        l2d = l2d.toLowerCase(Locale.ROOT);
        if (elems[0] == name & elems[1] == l2d & elems[2].length() <= 3) {
            return true;
        }
        return false;
    }
}