package com.androidacademy.coffeelist.dataSource;

import com.androidacademy.coffeelist.model.CoffeeItem;

import java.util.ArrayList;
import java.util.List;

public class DummyData
{
    public static List<CoffeeItem> dummyCoffeeItemList()
    {
        List<CoffeeItem> coffeeItems = new ArrayList<>();
        coffeeItems.add(new CoffeeItem("Malai Hot","malai_hot",75,4.5,32));
        coffeeItems.add(new CoffeeItem("Mango Hot Coffee","mango_hot_coffee",95,4.2,70));
        coffeeItems.add(new CoffeeItem("Sweet Nut Hot Coffee","sweet_nut_hot_coffee",125,4.6,66));

        coffeeItems.add(new CoffeeItem("Malai Hot 2","malai_hot",65,4.1,42));
        coffeeItems.add(new CoffeeItem("Mango Hot Coffee 2","mango_hot_coffee",35,4.3,45));
        coffeeItems.add(new CoffeeItem("Sweet Nut Hot Coffee 2","sweet_nut_hot_coffee",115,3.9,15));

        coffeeItems.add(new CoffeeItem("Malai Hot 3","malai_hot",95,4.2,62));
        coffeeItems.add(new CoffeeItem("Mango Hot Coffee 3","mango_hot_coffee",90,4.9,5));
        coffeeItems.add(new CoffeeItem("Sweet Nut Hot Coffee 3","sweet_nut_hot_coffee",195,5.0,1));

        return coffeeItems;
    }
}
