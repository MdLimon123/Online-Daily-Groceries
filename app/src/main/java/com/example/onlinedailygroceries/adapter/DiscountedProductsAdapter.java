package com.example.onlinedailygroceries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinedailygroceries.R;
import com.example.onlinedailygroceries.model.DiscountedProducts;

import java.util.List;

public class DiscountedProductsAdapter extends RecyclerView.Adapter<DiscountedProductsAdapter.DiscountedProductsViewHolder> {


    Context context;
    List<DiscountedProducts>  discountedProductsList;

    public DiscountedProductsAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items,parent,false);
        return new DiscountedProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductsViewHolder holder, int position) {
        holder.discountedImageView.setImageResource(discountedProductsList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {

        return discountedProductsList.size();

    }

    public static class DiscountedProductsViewHolder extends RecyclerView.ViewHolder{


        ImageView discountedImageView;
        public DiscountedProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            discountedImageView = itemView.findViewById(R.id.discountedImage);
        }
    }
}
