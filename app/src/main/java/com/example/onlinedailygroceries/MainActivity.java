package com.example.onlinedailygroceries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.example.onlinedailygroceries.adapter.CategoryAdapter;
import com.example.onlinedailygroceries.adapter.DiscountedProductsAdapter;
import com.example.onlinedailygroceries.adapter.RecentlyViewedAdapter;
import com.example.onlinedailygroceries.model.Category;
import com.example.onlinedailygroceries.model.DiscountedProducts;
import com.example.onlinedailygroceries.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductsAdapter discountedProductsAdapter;
    List<DiscountedProducts> discountedProductsList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recent_items);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,AllCategory.class);
                startActivity(i);
            }
        });


        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountmeat));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_home_fruits));
        categoryList.add(new Category(2,R.drawable.ic_home_fish));
        categoryList.add(new Category(3,R.drawable.ic_home_meats));
        categoryList.add(new Category(4,R.drawable.ic_home_veggies));
        categoryList.add(new Category(5,R.drawable.ic_home_fruits));
        categoryList.add(new Category(6,R.drawable.ic_home_fish));
        categoryList.add(new Category(7,R.drawable.ic_home_meats));
        categoryList.add(new Category(8,R.drawable.ic_home_veggies));

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon","Watermelon has high water content and also provides some fiber.","??? 80","1","KG",R.drawable.card4,R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya","Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.","??? 85","1","KG",R.drawable.card3,R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry","The strawberry is a highly nutritious fruit, loaded with vitamin C.","??? 38","1","KG",R.drawable.card2,R.drawable.b2));
        recentlyViewedList.add(new RecentlyViewed("Kiwi","Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.","??? 0","1","PC",R.drawable.card1,R.drawable.b1));



        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductsAdapter = new DiscountedProductsAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductsAdapter);

    }


    private void setCategoryRecycler(List<Category> categoryDataList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);

    }


}