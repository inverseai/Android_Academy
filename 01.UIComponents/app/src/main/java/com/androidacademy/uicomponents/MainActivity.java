package com.androidacademy.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText customerNameEditText,customerAddressEditText,customerPhoneNoEditText,numberOfCoffeeEditText;
    private RadioGroup coffeeTypeRadioGroup;
    private CheckBox addExtraSugarCheckbox;
    private Button placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateUIElements();


    }

    private void inflateUIElements()
    {
        customerNameEditText = findViewById(R.id.customer_name_edit_text);
        customerAddressEditText = findViewById(R.id.customer_address_edit_text);
        customerPhoneNoEditText = findViewById(R.id.customer_phone_no_edit_text);
        numberOfCoffeeEditText = findViewById(R.id.num_of_coffee_edit_text);
        coffeeTypeRadioGroup = findViewById(R.id.coffee_type_radio_group);
        addExtraSugarCheckbox = findViewById(R.id.extra_sugar_checkbox);
        placeOrderButton = findViewById(R.id.place_order_button);

    }
}
