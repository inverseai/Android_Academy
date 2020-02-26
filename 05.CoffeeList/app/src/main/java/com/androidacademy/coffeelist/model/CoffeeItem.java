package com.androidacademy.coffeelist.model;

public class CoffeeItem
{

    private String coffeeTitle,coffeeIcon;
    private double coffeePrice, coffeeRating;
    private int totalRatingCount;

    public CoffeeItem()
    {
        //empty no-args constructor
    }

    public CoffeeItem(String coffeeTitle, String coffeeIcon, double coffeePrice, double coffeeRating, int totalRatingCount)
    {
        this.coffeeTitle = coffeeTitle;
        this.coffeeIcon = coffeeIcon;
        this.coffeePrice = coffeePrice;
        this.coffeeRating = coffeeRating;
        this.totalRatingCount = totalRatingCount;
    }

    public String getCoffeeTitle()
    {
        return coffeeTitle;
    }

    public void setCoffeeTitle(String coffeeTitle)
    {
        this.coffeeTitle = coffeeTitle;
    }

    public double getCoffeePrice()
    {
        return coffeePrice;
    }

    public void setCoffeePrice(double coffeePrice)
    {
        this.coffeePrice = coffeePrice;
    }

    public double getCoffeeRating()
    {
        return coffeeRating;
    }

    public void setCoffeeRating(double coffeeRating)
    {
        this.coffeeRating = coffeeRating;
    }

    public int getTotalRatingCount()
    {
        return totalRatingCount;
    }

    public void setTotalRatingCount(int totalRatingCount)
    {
        this.totalRatingCount = totalRatingCount;
    }

    public String getCoffeeIcon() {
        return coffeeIcon;
    }

    public void setCoffeeIcon(String coffeeIcon) {
        this.coffeeIcon = coffeeIcon;
    }
}
