package com.example.alertdialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.MnOp1){
            Snackbar snackbar= Snackbar.make(findViewById(android.R.id.content),"First Option",Snackbar.LENGTH_SHORT);
            snackbar.show();
            return true;
        }else if(item.getItemId()==R.id.MnOp2){
            Snackbar snackbar= Snackbar.make(findViewById(android.R.id.content),"Second Option",Snackbar.LENGTH_SHORT);
            snackbar.show();
            return true;
        }else if(item.getItemId()==R.id.MnOp3){
            Snackbar snackbar= Snackbar.make(findViewById(android.R.id.content),"Third Option",Snackbar.LENGTH_SHORT);
            snackbar.show();
            return true;
        }
        return true;
    }

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
        Button alertDialogButton=findViewById(R.id.alertDialogButton);
        Button datePickerButton=findViewById(R.id.datePickerButton);
        Button timePickerButton=findViewById(R.id.timePickerButton);
        TextView alertDialogTextView=findViewById(R.id.alertDialogTextView);
        TextView datePickerTextView=findViewById(R.id.datePickerTextView);
        TextView timePickerTextView=findViewById(R.id.timePickerTextView);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("This is a message").setTitle("This is a title").setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogTextView.setText("Positive Selected");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogTextView.setText("Neutral Selected");
            }
        });
        builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogTextView.setText("Negative Selected");
            }
        });
        AlertDialog dialog=builder.create();
        alertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        final Calendar calenDate= Calendar.getInstance();
        int year=calenDate.get(Calendar.YEAR);
        int month=calenDate.get(Calendar.MONTH);
        int day=calenDate.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog date=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calenDate.set(year,month,dayOfMonth);
                datePickerTextView.setText(month+"/"+dayOfMonth+"/"+year);
            }
        },year,month,day+1);

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.show();
            }
        });

        final Calendar calenTime= Calendar.getInstance();
        int hour=calenDate.get(Calendar.HOUR_OF_DAY);
        int minute=calenDate.get(Calendar.MINUTE);
        TimePickerDialog time=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                timePickerTextView.setText(hour+":"+minute);
            }
        },hour,minute,false);
        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.show();
            }
        });

    }
}