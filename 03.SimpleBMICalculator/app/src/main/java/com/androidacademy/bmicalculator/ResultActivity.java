package com.androidacademy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity
{

    private Toolbar toolbar;
    private TextView recalculateBMIButton,bmiTypeText, bmiValueText, bmiResultMessage;
    private int weight, height;
    private double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        inflateUIElements();
        initUserInteractions();
        grabValueFromIntent();
        calculateBMI();
    }

    private void inflateUIElements()
    {
        toolbar = findViewById(R.id.app_toolbar);
        toolbar.setNavigationIcon(R.drawable.back_nav_white);
        recalculateBMIButton = findViewById(R.id.re_calculate_bmi_button);
        bmiTypeText = findViewById(R.id.bmi_type_text);
        bmiValueText = findViewById(R.id.bmi_value_text);
        bmiResultMessage = findViewById(R.id.bmi_result_message);
        setSupportActionBar(toolbar);
    }

    private void initUserInteractions()
    {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recalculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void grabValueFromIntent()
    {
        Intent intent = getIntent();
        if(intent!=null)
        {
            weight = intent.getIntExtra("weight",-1);
            height = intent.getIntExtra("height",-1);
        }
    }

    private void calculateBMI()
    {
        bmi = weight / Math.pow(height/100, 2);
        bmiValueText.setText(String.format("%.2f",bmi));

    }
}
