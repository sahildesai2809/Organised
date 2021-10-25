package com.example.organised;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signup extends AppCompatActivity {

    private TextView lgin_text;
    private TextView signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        lgin_text = findViewById(R.id.lgin_text);
        signup_btn = findViewById(R.id.signup_btn);

        lgin_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotologin();

            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotohome();

            }
        });

    }
    public  void gotologin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }
    public  void gotohome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}