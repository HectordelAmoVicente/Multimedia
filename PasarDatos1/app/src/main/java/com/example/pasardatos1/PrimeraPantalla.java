package com.example.pasardatos1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrimeraPantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primera_pantalla);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText nombreCampo=findViewById(R.id.nombreCampo);
        EditText apellidoCampo=findViewById(R.id.apellidoCampo);
        EditText edadCampo=findViewById(R.id.edadCampo);
        Button boton=findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent segundaPantalla=new Intent(PrimeraPantalla.this, SegundaPantalla.class);
                String nombre=nombreCampo.getText().toString();
                segundaPantalla.putExtra("nombre",nombre);
                String apellido=apellidoCampo.getText().toString();
                segundaPantalla.putExtra("apellido",apellido);
                int edad=Integer.parseInt(edadCampo.getText().toString());
                segundaPantalla.putExtra("edad",edad);
                startActivity(segundaPantalla);
            }
        });
    }

}