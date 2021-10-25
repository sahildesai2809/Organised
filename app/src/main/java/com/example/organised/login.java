package com.example.organised;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login extends AppCompatActivity {
    private TextView signup_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup_text = findViewById(R.id.signup_text);

        signup_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotosignup();

            }
        });
    }

    public  void gotosignup(){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}