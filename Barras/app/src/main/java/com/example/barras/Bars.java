package com.example.barras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class Bars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bars);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    TextView textViewFacilities=findViewById(R.id.textViewFacilities);
    TextView textViewCanteen=findViewById(R.id.textViewCanteen);
    TextView textViewCleaning=findViewById(R.id.textViewCleaning);
    SeekBar seekBarFacilities=findViewById(R.id.seekBarFacilities);
    RatingBar ratingBarCleaning=findViewById(R.id.ratingBarCleaning);
    RatingBar ratingBarCanteen=findViewById(R.id.ratingBarCanteen);
    Button buttonEnd=findViewById(R.id.buttonEnd);
    View contextView=findViewById(R.id.main);
    buttonEnd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            float facilities=seekBarFacilities.getProgress();
            float cleaning=ratingBarCleaning.getRating();
            float canteen=ratingBarCanteen.getRating();
            float average=(facilities+cleaning+canteen)/3;
            Snackbar.make(contextView,"Media: "+average,Snackbar.LENGTH_LONG).setAction("Esta es la media", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            }).show();
        }
    });
    }
}