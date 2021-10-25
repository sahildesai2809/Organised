package com.example.organised;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private TextView lgin_text;
    private TextView signup_btn;
    private EditText username, password, confirmpassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        lgin_text = findViewById(R.id.lgin_text);
        signup_btn = findViewById(R.id.signup_btn);
        DB= new DBHelper(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
//        confirmpassword = findViewById(R.id.confirmpass);






        lgin_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotologin();

            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
//                String repass = confirmpassword.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(true){
                        Boolean checkuser = DB.checkusername(user);
                        if(!checkuser){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert){
                                Toast.makeText(signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signup.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(signup.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
    public  void gotologin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }
//    public  void gotohome(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
}