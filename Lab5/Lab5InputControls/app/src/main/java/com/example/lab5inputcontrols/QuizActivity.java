package com.example.lab5inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class QuizActivity extends AppCompatActivity {
    RadioGroup r1RadioGroup;
    RadioGroup r2RadioGroup;
    RadioGroup r3RadioGroup;
    RadioGroup r5RadioGroup;
    RadioButton r1a;
    RadioButton r1b;
    RadioButton r1c;
    RadioButton r2a;
    RadioButton r2b;
    RadioButton r2c;
    RadioButton r3a;
    RadioButton r3b;
    RadioButton r3c;
    RadioButton r5a;
    RadioButton r5b;
    RadioButton r5c;
    CheckBox c4a;
    CheckBox c4b;
    CheckBox c4c;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        name = (TextView)findViewById(R.id.allTheBestTextView);
        name.setText("All the best, " + getIntent().getStringExtra("name"));
        r1RadioGroup = (RadioGroup)findViewById(R.id.r1RadioGroup);
        r2RadioGroup = (RadioGroup)findViewById(R.id.r2RadioGroup);
        r3RadioGroup = (RadioGroup)findViewById(R.id.r3RadioGroup);
        r5RadioGroup = (RadioGroup)findViewById(R.id.r5RadioGroup);
        c4a = (CheckBox)findViewById(R.id.c4aCheckBox);
        c4b = (CheckBox)findViewById(R.id.c4bCheckBox);
        c4c = (CheckBox)findViewById(R.id.c4cCheckBox);
    }

    public boolean Validation(){
        boolean result = true;
        if(r1RadioGroup.getCheckedRadioButtonId() == -1){
            result = false;
        }
        if(r2RadioGroup.getCheckedRadioButtonId() == -1){
            result = false;
        }
        if(r3RadioGroup.getCheckedRadioButtonId() == -1){
            result = false;
        }
        if(r5RadioGroup.getCheckedRadioButtonId() == -1){
            result = false;
        }
        if(c4a.isChecked() == false && c4b.isChecked() == false && c4c.isChecked() == false){
            result = false;
        }
        return result;
    }

    public int CalculateScore(){
        int score = 0;
        if(r1c.isChecked()){
            score = score + 1;
        }
        if(r2a.isChecked()){
            score = score + 1;
        }
        if(r3a.isChecked()){
            score = score + 1;
        }
        if(r5c.isChecked()){
            score = score + 1;
        }
        if(c4c.isChecked() && c4b.isChecked() && c4a.isChecked() == false){
            score = score + 1;
        }
        return score;
    }

    public void submitButtonClicked(View view) {
        if(Validation()){
            //int score = CalculateScore();
            Intent i = new Intent(QuizActivity.this,ResultActivity.class);
            //i.putExtra("score",score);
            startActivity(i);
        }
        else{
            Snackbar.make((LinearLayout)findViewById(R.id.root),"Please answer all the questions.",Snackbar.LENGTH_SHORT).show();
        }
    }
}