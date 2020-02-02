package com.androidacademy.uicomponents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int HOT_COFFEE = 1;
    private static final int COLD_COFFEE = 2;
    private EditText customerNameEditText,customerAddressEditText,customerPhoneNoEditText,numberOfCoffeeEditText;
    private RadioGroup coffeeTypeRadioGroup;
    private CheckBox addExtraSugarCheckbox;
    private Button placeOrderButton;
    private String customerName,customerAddress,customerPhoneNo,numberOfCoffee;
    private boolean addExtraSugar = false;
    private int coffeeType = HOT_COFFEE, numOfCoffeeCup = 1, numOfExtraSugarSpoon = 0;
    private double perCupCoffeePrice = 1.50,totalCoffeePrice = 1.50;
    private Toolbar appToolbar;
    private TextView coffeePriceTextView, coffeePlusButton, coffeeMinusButton, coffeeAmountTextView;
    private Spinner numOfExtraSugerSpoonSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateUIElements();
        initUserInteractions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_screen_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.exit_menu:
                finish();
                break;
            case R.id.cart_menu:
                showToast("CartMenuPressed",Toast.LENGTH_SHORT);
                break;
        }
        return true;
    }

    private void inflateUIElements()
    {
        customerNameEditText = findViewById(R.id.customer_first_name_edit_text);
        customerAddressEditText = findViewById(R.id.customer_address_edit_text);
        customerPhoneNoEditText = findViewById(R.id.customer_phone_no_edit_text);
        numberOfCoffeeEditText = findViewById(R.id.num_of_coffee_edit_text);
        coffeeTypeRadioGroup = findViewById(R.id.coffee_type_radio_group);
        addExtraSugarCheckbox = findViewById(R.id.extra_sugar_checkbox);
        placeOrderButton = findViewById(R.id.place_order_button);
        appToolbar = findViewById(R.id.app_toolbar);

        coffeePriceTextView = findViewById(R.id.coffee_price_text);
        coffeePlusButton = findViewById(R.id.coffee_plus_button);
        coffeeMinusButton = findViewById(R.id.coffee_minus_button);
        coffeeAmountTextView = findViewById(R.id.coffee_num_of_cup_text);
        numOfExtraSugerSpoonSpinner = findViewById(R.id.num_of_extra_sugar_spoon);

        setSupportActionBar(appToolbar);
        if(getSupportActionBar() != null )
            getSupportActionBar().setTitle(getResources().getString(R.string.order_coffee));
    }

    private void initUserInteractions()
    {
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                grabValuesFromEditTexts();
                showToast(getOrderMessage(),Toast.LENGTH_LONG);

            }
        });

        addExtraSugarCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                addExtraSugar = b;
                updateNumOfExtraSugarSpinnerVisibility(addExtraSugar);
            }
        });

        coffeeTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()==R.id.hot_coffee_radio_button)
                    coffeeType = HOT_COFFEE;
                else if(radioGroup.getCheckedRadioButtonId()==R.id.cold_coffee_radio_button)
                    coffeeType = COLD_COFFEE;
            }
        });

        coffeePlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementNumOfCoffeeCup();
            }
        });

        coffeeMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementNumOfCoffeeCup();
            }
        });

        numOfExtraSugerSpoonSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                numOfExtraSugarSpoon = (i+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void showToast(String message, int toastLength)
    {
        Toast.makeText(this,message,toastLength).show();
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
        return "Name : "+customerName+"\nAddress : "+customerAddress+"\nPhone No : "+customerPhoneNo+"\nNumber of Coffee : "
                +numOfCoffeeCup+"\nCoffee Type : "+getCoffeeTypeString() + "\nAdd Extra Sugar : "+getExtraSugarText()
                +"\nTotal Number of Extra Sugar "+numOfExtraSugarSpoon+" Spoons(s)\nTotal Price : $ "+totalCoffeePrice;
    }

    private String getCoffeeTypeString()
    {
        switch (coffeeType)
        {
            case HOT_COFFEE:
                return "Hot Coffee";
            case COLD_COFFEE :
                return "Cold Coffee";
            default:
                return "";
        }
    }

    private void incrementNumOfCoffeeCup()
    {
        numOfCoffeeCup++;
        totalCoffeePrice = numOfCoffeeCup * perCupCoffeePrice;
        coffeeAmountTextView.setText(numOfCoffeeCup+"");
        coffeePriceTextView.setText("$ "+totalCoffeePrice+"0");

    }

    private void decrementNumOfCoffeeCup()
    {
        numOfCoffeeCup--;
        if(numOfCoffeeCup<1)
        {
            Toast.makeText(this, "Order at least one coffee!", Toast.LENGTH_SHORT).show();
            numOfCoffeeCup=1;
        }
        totalCoffeePrice = numOfCoffeeCup * perCupCoffeePrice;
        coffeeAmountTextView.setText(numOfCoffeeCup+"");
        coffeePriceTextView.setText("$ "+totalCoffeePrice+"0");
    }

    private void updateNumOfExtraSugarSpinnerVisibility(boolean isVisible)
    {
        numOfExtraSugerSpoonSpinner.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    private String getExtraSugarText()
    {
        return addExtraSugar ? "Yes" : "No";
    }
}
