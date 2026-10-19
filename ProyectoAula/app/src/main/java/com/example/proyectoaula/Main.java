//Author:Héctor del Amo Vicente
package com.example.proyectoaula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView appleCounter=findViewById(R.id.textViewAppleCounter);
        TextView kiwiCounter=findViewById(R.id.textViewKiwiCounter);
        TextView bananaCounter=findViewById(R.id.textViewBananaCounter);
        TextView pearCounter=findViewById(R.id.textViewPearCounter);
        TextView generalCounter=findViewById(R.id.textViewGeneralCounter);
        final int[] generalCounterNumber = {0};
        Button sumApple=findViewById(R.id.buttonSumApple);
        Button susApple=findViewById(R.id.buttonSusApple);
        Button sumKiwi=findViewById(R.id.buttonSumKiwi);
        Button susKiwi=findViewById(R.id.buttonSusKiwi);
        Button sumBanana=findViewById(R.id.buttonSumBanana);
        Button susBanana=findViewById(R.id.buttonSusBanana);
        Button sumPear=findViewById(R.id.buttonSumPear);
        Button susPear=findViewById(R.id.buttonSusPear);
        Button confirm=findViewById(R.id.buttonConfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main.this,Second.class);
                intent.putExtra("apples",Integer.parseInt(appleCounter.getText().toString()));
                intent.putExtra("kiwis",Integer.parseInt(kiwiCounter.getText().toString()));
                intent.putExtra("bananas",Integer.parseInt(bananaCounter.getText().toString()));
                intent.putExtra("pears",Integer.parseInt(pearCounter.getText().toString()));
                startActivity(intent);
            }
        });
        sumApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(appleCounter.getText().toString());
                currentNumber++;
                appleCounter.setText(currentNumber+"");
                generalCounterNumber[0]++;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");
            }
        });
        susApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(appleCounter.getText().toString());
                if(currentNumber>0){
                currentNumber=currentNumber-1;
                appleCounter.setText(currentNumber+"");
                generalCounterNumber[0]=generalCounterNumber[0]-1;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");}
            }
        });
        sumKiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(kiwiCounter.getText().toString());
                currentNumber++;
                kiwiCounter.setText(currentNumber+"");
                generalCounterNumber[0]++;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");
            }
        });
        susKiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(kiwiCounter.getText().toString());
                if(currentNumber>0){
                currentNumber=currentNumber-1;
                kiwiCounter.setText(currentNumber+"");
                generalCounterNumber[0]=generalCounterNumber[0]-1;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");}
            }
        });
        sumBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(bananaCounter.getText().toString());
                currentNumber++;
                bananaCounter.setText(currentNumber+"");
                generalCounterNumber[0]++;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");
            }
        });
        susBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(bananaCounter.getText().toString());
                if(currentNumber>0){
                    currentNumber=currentNumber-1;
                    bananaCounter.setText(currentNumber+"");
                    generalCounterNumber[0]=generalCounterNumber[0]-1;
                    generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");}
            }
        });
        sumPear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(pearCounter.getText().toString());
                currentNumber++;
                pearCounter.setText(currentNumber+"");
                generalCounterNumber[0]++;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");
            }
        });
        susPear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNumber=Integer.parseInt(pearCounter.getText().toString());
                if(currentNumber>0){
                currentNumber=currentNumber-1;
                pearCounter.setText(currentNumber+"");
                generalCounterNumber[0]=generalCounterNumber[0]-1;
                generalCounter.setText("Has seleccionado "+generalCounterNumber[0]+" artículos");}
            }
        });
    }
}