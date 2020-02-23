package com.androidacademy.coffeelist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androidacademy.coffeelist.R;
import com.androidacademy.coffeelist.adapter.CoffeeListAdapter;
import com.androidacademy.coffeelist.dataSource.DummyData;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView coffeeListView;
    private CoffeeListAdapter coffeeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateUIElements();
        initCoffeeList();
    }

    private void inflateUIElements()
    {
        coffeeListView = findViewById(R.id.coffee_list);

    }

    private void initCoffeeList()
    {
        coffeeListAdapter = new CoffeeListAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        coffeeListView.setLayoutManager(layoutManager);
        coffeeListView.setAdapter(coffeeListAdapter);
        coffeeListAdapter.bindCoffeeItemList(DummyData.dummyCoffeeItemList());


    }
}
