package com.example.lab5inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.nameEditText);
    }

    public void letsgoButtonClicked(View view) {
        if(name.getText().length() != 0){
            Intent intent = new Intent(MainActivity.this,QuizActivity.class);
            intent.putExtra("name",name.getText().toString());
            startActivity(intent);
            this.finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Please provide your name",Toast.LENGTH_SHORT).show();
        }
    }
}