package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class SecondWindow extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }
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
        ListView listView=findViewById(R.id.listView);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
        ArrayList<String> extraServicesArrayList=bundle.getStringArrayList("extraServices");
        dataMap.put("Apodo",bundle.getString("nickname"));
        dataMap.put("Nombre",bundle.getString("name"));
        dataMap.put("Localidad",bundle.getString("locality"));
        dataMap.put("Dirección",bundle.getString("address"));
        dataMap.put("Curso",bundle.getString("course"));
        for(int i=0;i<extraServicesArrayList.size();i++){
            String service=extraServicesArrayList.get(i);
            if(service.equals("Comedor")){
                dataMap.put("Servicio extra "+(i+1),service);
            }else if(service.equals("Taquilla")){
                dataMap.put("Servicio extra "+(i+1),service);
            }else if(service.equals("Parking")){
                dataMap.put("Servicio extra "+(i+1),service);
            }
        }
        ArrayList<String> data=new ArrayList<String>();
        for(String key:dataMap.keySet()){
            data.add(key);
            data.add(dataMap.get(key));
        }
        DataAdapter<Data> adapter=new DataAdapter<Data>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
}