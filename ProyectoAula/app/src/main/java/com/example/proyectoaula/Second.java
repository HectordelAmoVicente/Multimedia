//Author:Héctor del Amo Vicente
package com.example.proyectoaula;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView boughtApples=findViewById(R.id.textViewAppleBought);
        TextView boughtKiwis=findViewById(R.id.textViewKiwiBought);
        TextView boughtBananas=findViewById(R.id.textViewBananaBought);
        TextView boughtPears=findViewById(R.id.textViewPearBought);
        RatingBar ratingBar=findViewById(R.id.ratingBar);
        TextView rating=findViewById(R.id.textViewRating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rating.setText("Valoración: "+ratingBar.getRating()+" \n\t\t\t\t\t estrellas");
            }
        });
        Intent data=getIntent();
        int apples=data.getIntExtra("apples",0);
        boughtApples.setText(apples+" manzanas");
        int kiwis=data.getIntExtra("kiwis",0);
        boughtKiwis.setText(kiwis+" kiwis");
        int bananas=data.getIntExtra("bananas",0);
        boughtBananas.setText(bananas+" plátanos");
        int pears=data.getIntExtra("pears",0);
        boughtPears.setText(pears+" peras");
    }
}