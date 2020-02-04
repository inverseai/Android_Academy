package com.androidacademy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static final int DEFAULT_AGE = 19, DEFAULT_WEIGHT = 50, MALE_GENDER = 1, FEMALE_GENDER = 2, NOT_SELECTED_GENDER = -1;
    private TextView heightTextView, weightTextView, ageTextView, weightPlusButton, weightMinusButton, agePlusButton, ageMinusButton,
            calculateBMIButton;
    private CardView maleButton, femaleButton;
    private SeekBar heightSeekBar;
    private int weight = DEFAULT_WEIGHT, age = DEFAULT_AGE, gender = NOT_SELECTED_GENDER;

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
        maleButton = findViewById(R.id.male_button);
        femaleButton = findViewById(R.id.female_button);
        heightTextView = findViewById(R.id.height_text_view);
        weightTextView = findViewById(R.id.weight_text_view);
        ageTextView = findViewById(R.id.age_text_view);
        heightSeekBar = findViewById(R.id.height_seek_bar);
        weightPlusButton = findViewById(R.id.weight_plus_button);
        weightMinusButton = findViewById(R.id.weight_minus_button);
        agePlusButton = findViewById(R.id.age_plus_button);
        ageMinusButton = findViewById(R.id.age_minus_button);
        calculateBMIButton = findViewById(R.id.calculate_bmi_button);
    }

    private void initUserInteractions()
    {
        weightPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementWeight();
            }
        });

        weightMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementWeight();
            }
        });

        agePlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementAge();
            }
        });

        ageMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementAge();
            }
        });

        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                updateWeightSeekBar(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMaleGender();
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFemaleGender();
            }
        });

        calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToResultScreen();
            }
        });
    }

    private void incrementAge()
    {
        age++;
        ageTextView.setText(age+"");

    }

    private void decrementAge()
    {
        age--;
        if(age<1)
        {
            age = 1;
            Toast.makeText(this, "Age Must be greater then 1", Toast.LENGTH_SHORT).show();
        }
        ageTextView.setText(age+"");
    }

    private void incrementWeight()
    {
        weight++;
        weightTextView.setText(weight+" KG");

    }

    private void decrementWeight()
    {
        weight--;
        if(weight<10)
        {
            weight = 10;
            Toast.makeText(this, "Weight Must be greater then 10", Toast.LENGTH_SHORT).show();
        }
        weightTextView.setText(weight+" KG");
    }

    private void updateWeightSeekBar(int progress)
    {
        heightSeekBar.setProgress(progress);
        heightTextView.setText(progress+"");
    }

    private void setMaleGender()
    {
        gender = MALE_GENDER;
        maleButton.setCardBackgroundColor(getResources().getColor(R.color.plusMinusButtonBG));
        femaleButton.setCardBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

    }

    private void setFemaleGender()
    {
        gender = FEMALE_GENDER;
        femaleButton.setCardBackgroundColor(getResources().getColor(R.color.plusMinusButtonBG));
        maleButton.setCardBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

    }

    private void moveToResultScreen()
    {
        Intent intent = new Intent(this,ResultActivity.class);
        startActivity(intent);
    }


}
