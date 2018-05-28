package com.example.incubator3.travniknightrace.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.incubator3.travniknightrace.R;
import com.example.incubator3.travniknightrace.activities.LoginActivity;
import com.example.incubator3.travniknightrace.controllers.UserController;

public class RegisterActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_email;
    EditText et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);


    }

    public void returnToLogin(View view) {

        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);

    }

    public void registerUser(View view) {
        UserController userController = new UserController();

        String username= et_username.getText().toString();
        String email= et_email.getText().toString();
        String password= et_password.getText().toString();

//        UserRegister userRegister = new UserRegister();
//        userRegister.setUsername(username);
//        userRegister.setEmail(email);
//        userRegister.setPassword(password);

        userController.registerUser(username,password,email);

        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);


    }
}
