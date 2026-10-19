package com.example.pasardatos1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaPantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_pantalla);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView nombre=findViewById(R.id.nombreEtiqueta);
        TextView apellido=findViewById(R.id.apellidoEtiqueta);
        TextView edad=findViewById(R.id.edadEtiqueta);
        Intent intent=getIntent();
        String nombreIntent=intent.getStringExtra("nombre");
        String apellidoIntent=intent.getStringExtra("apellido");
        int edadIntent=Integer.parseInt(intent.getStringExtra("edad"));
        nombre.setText(nombre.getText()+" "+nombreIntent);
        apellido.setText(apellido.getText()+" "+apellidoIntent);
        edad.setText(edad.getText()+" "+edadIntent);

    }
}