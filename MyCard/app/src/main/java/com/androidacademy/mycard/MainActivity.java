package com.androidacademy.mycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
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
                openPhoneNoIntent();
            }
        });

        emailIdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmailIdIntent();
            }
        });

        githubIdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGithubIdIntent();
            }
        });
    }


    private void openPhoneNoIntent()
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(getResources().getString(R.string.my_phone_no_data)));
        startActivity(intent);


    }

    private void openEmailIdIntent()
    {

    }

    private void openGithubIdIntent()
    {

    }
}
