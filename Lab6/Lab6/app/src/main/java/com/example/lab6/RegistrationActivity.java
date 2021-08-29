package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {
    Spinner day;
    List<String> days = new ArrayList<String>();
    final Calendar myCalendar = Calendar.getInstance();
    AlertDialog.Builder builder;

    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        day = (Spinner) findViewById(R.id.daySpinner);
        PopulateDays();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, days);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(arrayAdapter);
        edittext = (EditText) findViewById(R.id.dateEditText);
        builder = new AlertDialog.Builder(this);

    }

    private Boolean Validate(){
        Boolean result = true;
        if(((EditText)findViewById(R.id.nameEditText)).getText().toString().length() == 0){
            result = false;
        }
        if(((EditText)findViewById(R.id.emailEditText)).getText().toString().length() == 0){
            result = false;
        }
        if(((EditText)findViewById(R.id.dateEditText)).getText().toString().length() == 0){
            result = false;
        }
        return result;
    }

    public void PopulateDays(){
        days.add("Day 1");
        days.add("Day 2");
        days.add("Day 3");
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


    public void dateClicked(View view) {
        new DatePickerDialog(RegistrationActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void submitButtonClicked(View view) {

        if(!Validate()){
            Toast.makeText(getApplicationContext(),"Please fill all the details",Toast.LENGTH_SHORT).show();
            return;
        }

        builder.setMessage("Do you want to Submit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        GotoNext();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();

                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Confirmation");
        alert.show();





    }

    public void GotoNext(){
        Intent i = new Intent(this, MoreNewsActivity.class);
        startActivity(i);
    }
}