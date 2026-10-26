package com.example.formulario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private String course="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AutoCompleteTextView autoCompleteTextViewNickname=findViewById(R.id.autoCompleteTextViewNickname);
        TextView textViewTitle=findViewById(R.id.title);
        TextView textViewCourse=findViewById(R.id.textViewCourse);
        TextView textViewExtraServices=findViewById(R.id.textViewExtraServices);
        TextView textViewTerms=findViewById(R.id.textViewTerms);
        EditText editTextName=findViewById(R.id.editTextName);
        EditText editTextLocality=findViewById(R.id.editTextLocality);
        EditText editTextAddress=findViewById(R.id.editTextAddress);
        RadioGroup radioGroupCourses=findViewById(R.id.radioGroupCourses);
        RadioButton radioButtonFirst=findViewById(R.id.radioButtonFirst);
        RadioButton radioButtonSecond=findViewById(R.id.radioButtonSecond);
        CheckBox checkBoxDining=findViewById(R.id.checkBoxDining);
        CheckBox checkBoxParking=findViewById(R.id.checkBoxParking);
        CheckBox checkBoxLocker=findViewById(R.id.checkBoxLocker);
        Switch switchTerms=findViewById(R.id.switchTerms);
        Button buttonFillOut=findViewById(R.id.buttonFillOut);
        ToggleButton toggleButtonTextSize=findViewById(R.id.toggleButtonTextSize);
        ImageButton imageButtonClear=findViewById(R.id.imageButtonClear);
        ArrayList<String> extraServices=new ArrayList<String>();
        String[] nicknames={"Hector","Hank","Hulk","Harry","Henry","Hugh","Hubert","Humphrey","Humpty Dumpty"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nicknames);
        autoCompleteTextViewNickname.setAdapter(adapter);
        radioGroupCourses.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(R.id.radioButtonFirst==checkedId){
                    course="Primero";
                }else if(R.id.radioButtonSecond==checkedId){
                    course="Segundo";
                }else{
                    course="";
                }
            }
        });
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Continuar a la siguiente pantalla").setTitle("Confirmar datos").setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Main.this,SecondWindow.class);
                Bundle bundle=new Bundle();
                bundle.putString("nickname",autoCompleteTextViewNickname.getText().toString());
                bundle.putString("name",editTextName.getText().toString());
                bundle.putString("locality",editTextLocality.getText().toString());
                bundle.putString("address",editTextAddress.getText().toString());
                bundle.putString("course",course);
                bundle.putStringArrayList("extraServices",extraServices);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog confirmationDialog=builder.create();
        buttonFillOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {confirmationDialog.show();}
        });

        checkBoxLocker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    extraServices.add(checkBoxLocker.getText().toString());
                }else{
                    extraServices.remove(checkBoxLocker.getText().toString());
                }
            }
        });
        checkBoxDining.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    extraServices.add(checkBoxDining.getText().toString());
                }else{
                    extraServices.remove(checkBoxDining.getText().toString());
                }
            }
        });
        checkBoxParking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    extraServices.add(checkBoxParking.getText().toString());
                }else{
                    extraServices.remove(checkBoxParking.getText().toString());
                }
            }
        });
        switchTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {

            }
        });
        float textViewTitleSize=35;
        float textViewCourseSize=20;
        float textViewExtraServicesSize=20;
        float textViewTermsSize=20;
        float editTextNameSize=20;
        float editTextLocalitySize=20;
        float editTextAddressSize=20;
        float radioButtonFirstSize=12;
        float radioButtonSecondSize=12;
        float checkBoxDiningSize=14;
        float checkBoxLockerSize=14;
        float checkBoxParkingSize=14;
        float buttonFillOutSize=14;
        float toggleButtonTextSizeSize=14;

        float density=getResources().getDisplayMetrics().density;
        float switchTermsWidth=60;
        float switchTermsHeight=20;
        float imageButtonClearWidth=80;
        float imageButtonClearHeight=40;
        toggleButtonTextSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {


                if(isChecked){
                    textViewTitle.setTextSize(textViewTitleSize*1.5f);
                    textViewCourse.setTextSize(textViewCourseSize*1.5f);
                    textViewTerms.setTextSize(textViewTermsSize*1.5f);
                    textViewExtraServices.setTextSize(textViewExtraServicesSize*1.5f);
                    editTextName.setTextSize(editTextNameSize*1.5f);
                    editTextLocality.setTextSize(editTextLocalitySize*1.5f);
                    editTextAddress.setTextSize(editTextAddressSize*1.5f);
                    radioButtonFirst.setTextSize(radioButtonFirstSize*1.5f);
                    radioButtonSecond.setTextSize(radioButtonSecondSize*1.5f);
                    checkBoxDining.setTextSize(checkBoxDiningSize*1.5f);
                    checkBoxLocker.setTextSize(checkBoxLockerSize*1.5f);
                    checkBoxParking.setTextSize(checkBoxParkingSize*1.5f);
                    buttonFillOut.setTextSize(buttonFillOutSize*1.5f);
                    toggleButtonTextSize.setTextSize(toggleButtonTextSizeSize*1.5f);

                    ViewGroup.LayoutParams paramsSwitchTerms=switchTerms.getLayoutParams();
                    paramsSwitchTerms.width=(int)(switchTermsWidth*1.5f*density);
                    paramsSwitchTerms.height=(int)(switchTermsHeight*1.5f*density);
                    switchTerms.setLayoutParams(paramsSwitchTerms);

                    ViewGroup.LayoutParams paramsImageButton=imageButtonClear.getLayoutParams();
                    paramsImageButton.width=(int)(imageButtonClearWidth*1.5f*density);
                    paramsImageButton.height=(int)(imageButtonClearHeight*1.5f*density);
                    imageButtonClear.setLayoutParams(paramsImageButton);
                }else{
                    textViewTitle.setTextSize(textViewTitleSize);
                    textViewCourse.setTextSize(textViewCourseSize);
                    textViewExtraServices.setTextSize(textViewExtraServicesSize);
                    textViewTerms.setTextSize(textViewTermsSize);
                    editTextName.setTextSize(editTextNameSize);
                    editTextLocality.setTextSize(editTextLocalitySize);
                    editTextAddress.setTextSize(editTextAddressSize);
                    radioButtonFirst.setTextSize(radioButtonFirstSize);
                    radioButtonSecond.setTextSize(radioButtonSecondSize);
                    checkBoxDining.setTextSize(checkBoxDiningSize);
                    checkBoxLocker.setTextSize(checkBoxLockerSize);
                    checkBoxParking.setTextSize(checkBoxParkingSize);
                    buttonFillOut.setTextSize(buttonFillOutSize);
                    toggleButtonTextSize.setTextSize(toggleButtonTextSizeSize);

                    ViewGroup.LayoutParams paramsSwitchTerms=switchTerms.getLayoutParams();
                    paramsSwitchTerms.width=(int)(switchTermsWidth*density);
                    paramsSwitchTerms.height=(int)(switchTermsHeight*density);
                    switchTerms.setLayoutParams(paramsSwitchTerms);

                    ViewGroup.LayoutParams params=imageButtonClear.getLayoutParams();
                    params.width=(int)(imageButtonClearWidth*density);
                    params.height=(int)(imageButtonClearHeight*density);
                    imageButtonClear.setLayoutParams(params);
                }
            }
        });
        imageButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setText("");
                editTextLocality.setText("");
                editTextAddress.setText("");
                radioGroupCourses.clearCheck();
                checkBoxDining.setChecked(false);
                checkBoxLocker.setChecked(false);
                checkBoxParking.setChecked(false);
                extraServices.clear();
            }
        });
    }
}