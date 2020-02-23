package com.androidacademy.coffeelist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidacademy.coffeelist.R;
import com.androidacademy.coffeelist.adapter.CoffeeListAdapter;
import com.androidacademy.coffeelist.dataSource.DummyData;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView coffeeListView;
    private CoffeeListAdapter coffeeListAdapter;
    private Toolbar appToolbar;
    private boolean isList = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateUIElements();
        initToolbar();
        initCoffeeList();
    }

    private void inflateUIElements()
    {
        coffeeListView = findViewById(R.id.coffee_list);
        appToolbar = findViewById(R.id.app_toolbar);
    }

    private void initToolbar()
    {
        setSupportActionBar(appToolbar);

    }

    private void initCoffeeList()
    {
        coffeeListAdapter = new CoffeeListAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        coffeeListView.setLayoutManager(layoutManager);
        coffeeListView.setAdapter(coffeeListAdapter);
        coffeeListAdapter.bindCoffeeItemList(DummyData.dummyCoffeeItemList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.coffee_list_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.view_type_menu:
                toggleViewType(item);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleViewType(@NonNull MenuItem item)
    {
        Toast.makeText(this, "TappedOnMenu", Toast.LENGTH_SHORT).show();
        isList = !isList;
        item.setIcon(isList ? R.drawable.grid_white : R.drawable.list_white);
    }
}
