package com.example.malab3_activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText height;
    EditText mass;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity_Life_Cycle","onCreate() invoked");
        Toast.makeText(getApplicationContext(), "onCreate() invoked", Toast.LENGTH_SHORT).show();
        height = (EditText) findViewById(R.id.heightEditText);
        mass = (EditText) findViewById(R.id.massEditText);
        result = (TextView) findViewById(R.id.resultTextView);

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Activity_Life_Cycle","onStart() invoked");
        Toast.makeText(getApplicationContext(), "onStart() invoked", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Activity_Life_Cycle","onResume() invoked");
        Toast.makeText(getApplicationContext(), "onStart() invoked", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Activity_Life_Cycle","onPause() invoked");
        Toast.makeText(getApplicationContext(), "onPause() invoked", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("Activity_Life_Cycle","onStop() invoked");
        Toast.makeText(getApplicationContext(), "onStop() invoked", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Activity_Life_Cycle","onRestart() invoked");
        Toast.makeText(getApplicationContext(), "onRestart() invoked", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Activity_Life_Cycle","onDestroy() invoked");
        Toast.makeText(getApplicationContext(), "onDestroy() invoked", Toast.LENGTH_SHORT).show();

    }

    private boolean validate(){
        boolean result = true;
        String h = height.getText().toString();
        String w = mass.getText().toString();
        if(h.length() == 0 || h.equals("0")){
            result = false;
        }
        if(w.length() == 0 || w.equals("0")){
            result = false;
        }
        return result;
    }

    public void submitButtonClicked(View view) {
        if(validate()){
            double h = (Double.parseDouble(height.getText().toString()))/100;
            double w = Double.parseDouble(mass.getText().toString());

            double bmi = w/(h*h);
            Log.d("BMI",String.valueOf(bmi));
            bmi = Math.round(bmi * 100.0) / 100.0;

            result.setVisibility(View.VISIBLE);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please enter valid values", Toast.LENGTH_SHORT).show();
        }
    }
}