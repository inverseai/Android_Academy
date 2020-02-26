package com.androidacademy.logmein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button loginButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateUIElements();
        initUserInteractions();
    }

    private void inflateUIElements()
    {
        loginButton = findViewById(R.id.login_button);
        signUpButton = findViewById(R.id.sign_up_button);
    }


    private void initUserInteractions()
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                moveToLoginScreen();

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                moveToSignUpScreen();
            }
        });
    }

    private void moveToLoginScreen()
    {

        //TODO implement the functionality of moving to login screen


    }

    private void moveToSignUpScreen()
    {
        //TODO implement the functionality of moving to signup screen
    }
}
