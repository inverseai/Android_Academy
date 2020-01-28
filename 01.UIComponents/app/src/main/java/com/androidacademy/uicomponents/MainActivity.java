package com.androidacademy.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText customerNameEditText,customerAddressEditText,customerPhoneNoEditText,numberOfCoffeeEditText;
    private RadioGroup coffeeTypeRadioGroup;
    private CheckBox addExtraSugarCheckbox;
    private Button placeOrderButton;
    private String customerName,customerAddress,customerPhoneNo,numberOfCoffee;

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
        customerNameEditText = findViewById(R.id.customer_name_edit_text);
        customerAddressEditText = findViewById(R.id.customer_address_edit_text);
        customerPhoneNoEditText = findViewById(R.id.customer_phone_no_edit_text);
        numberOfCoffeeEditText = findViewById(R.id.num_of_coffee_edit_text);
        coffeeTypeRadioGroup = findViewById(R.id.coffee_type_radio_group);
        addExtraSugarCheckbox = findViewById(R.id.extra_sugar_checkbox);
        placeOrderButton = findViewById(R.id.place_order_button);
    }

    private void initUserInteractions()
    {
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                grabValuesFromEditTexts();
                showToast(getOrderMessage());

            }
        });
    }

    private void showToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void grabValuesFromEditTexts()
    {
        customerName = customerNameEditText.getText().toString();
        customerAddress = customerAddressEditText.getText().toString();
        customerPhoneNo = customerPhoneNoEditText.getText().toString();
        numberOfCoffee = numberOfCoffeeEditText.getText().toString();
    }

    private String getOrderMessage()
    {
        return "Name : "+customerName+"\nAddress : "+customerAddress+"\nPhone No : "+customerPhoneNo+"\nNumber of Coffee : "+numberOfCoffee;
    }
}
