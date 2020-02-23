package com.androidacademy.coffeelist.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidacademy.coffeelist.R;
import com.androidacademy.coffeelist.model.CoffeeItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class CoffeeListAdapter extends RecyclerView.Adapter<CoffeeListAdapter.CoffeeListViewHolder>
{

    private List<CoffeeItem> coffeeItemList;
    private Activity activity;

    public CoffeeListAdapter(Activity activity) {
        this.activity = activity;
    }

    class CoffeeListViewHolder extends RecyclerView.ViewHolder
    {

        ImageView coffeeIcon;
        TextView coffeeTitle,coffeePrice,coffeeTotalReview;
        RatingBar coffeeRatings;

        public CoffeeListViewHolder(@NonNull View itemView)
        {
            super(itemView);
            coffeeIcon = itemView.findViewById(R.id.coffee_icon);
            coffeeTitle = itemView.findViewById(R.id.coffee_title);
            coffeePrice = itemView.findViewById(R.id.coffee_price);
            coffeeTotalReview = itemView.findViewById(R.id.coffee_rating_count);
            coffeeRatings = itemView.findViewById(R.id.coffee_rating_bar);
        }
    }

    @NonNull
    @Override
    public CoffeeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = activity.getLayoutInflater().inflate(R.layout.coffee_list_item_single_row,parent,false);
        return new CoffeeListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeListViewHolder holder, int position)
    {
        CoffeeItem coffeeItem = coffeeItemList.get(position);
        holder.coffeeIcon.setImageResource(R.drawable.malai_hot);
        holder.coffeePrice.setText(activity.getResources().getString(R.string.coffee_price,(float)coffeeItem.getCoffeePrice()));
        holder.coffeeTitle.setText(coffeeItem.getCoffeeTitle());
        holder.coffeeTotalReview.setText(activity.getResources().getString(R.string.rating_count,coffeeItem.getTotalRatingCount()));
        holder.coffeeRatings.setRating((float) coffeeItem.getCoffeeRating());
        Glide.with(activity)
                .load(getImage(coffeeItem.getCoffeeIcon()))
                .into(holder.coffeeIcon);
    }

    public int getImage(String imageName) {

        return activity.getResources().getIdentifier(imageName,"drawable",activity.getPackageName());
    }

    @Override
    public int getItemCount()
    {
        if(coffeeItemList==null)
            return 0;
        else  return coffeeItemList.size();
    }

    public void bindCoffeeItemList(List<CoffeeItem> coffeeItemList)
    {
        this.coffeeItemList = coffeeItemList;
        notifyDataSetChanged();
    }
}
