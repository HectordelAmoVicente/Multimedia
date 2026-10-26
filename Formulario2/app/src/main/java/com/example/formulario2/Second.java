package com.example.formulario2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_window);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textViewName2=findViewById(R.id.textViewName2);
        TextView textViewLocality2=findViewById(R.id.textViewLocality2);
        TextView textViewAddress2=findViewById(R.id.textViewAddress2);
        TextView textViewCourse2=findViewById(R.id.textViewCourse2);
        TextView textViewExtraServices2=findViewById(R.id.textViewExtraServices2);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        textViewName2.setText(textViewName2.getText()+" "+bundle.getString("name"));
        textViewLocality2.setText(textViewLocality2.getText()+" "+bundle.getString("locality"));
        textViewAddress2.setText(textViewAddress2.getText()+" "+bundle.getString("address"));
        textViewCourse2.setText(textViewCourse2.getText()+" "+bundle.getString("course"));
        textViewExtraServices2.setText(textViewExtraServices2.getText()+" "+bundle.getStringArrayList("extraServices"));


    }
}