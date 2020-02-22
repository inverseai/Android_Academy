package com.androidacademy.mycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    private CardView phoneNoCard, emailIdCard, githubIdCard;

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
        phoneNoCard = findViewById(R.id.phone_no_card);
        emailIdCard = findViewById(R.id.email_id_card);
        githubIdCard = findViewById(R.id.github_id_card);
    }

    private void initUserInteractions()
    {
        phoneNoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        emailIdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        githubIdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
