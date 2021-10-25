package com.example.organised;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private TextView signup_text,login_text, signupp_text,signup_txt;
    private EditText username,password;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup_text = findViewById(R.id.signup_text);
        DB = new DBHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        login_text = findViewById(R.id.login_text);
//        signup_text = findViewById(R.id.signupp_text);
        signup_txt = findViewById(R.id.signup_txt);




        login_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                };


            }
        });


//        signup_text.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                gotosignup();
//
//            }
//        });
        signup_txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotosignup();

            }
        });
    }

    public  void gotosignup(){
//        Intent intent = new Intent(this, signup.class);
//        startActivity(intent);
        Intent intent = new Intent(this,signup.class);
        startActivity(intent);
    }
}