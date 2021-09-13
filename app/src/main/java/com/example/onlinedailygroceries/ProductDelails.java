package com.example.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDelails extends AppCompatActivity {

    ImageView img,back;
    TextView proName, proPrice, proDesc;
    String name,price,desc;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_delails);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        image = i.getIntExtra("image",R.drawable.b1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");

        proName = findViewById(R.id.product_name);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);

      // proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDelails.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });





    }
}