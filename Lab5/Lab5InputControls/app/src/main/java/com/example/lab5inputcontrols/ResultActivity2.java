package com.example.lab5inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity2 extends AppCompatActivity {
    ProgressBar scoreBar;
    TextView scoreText;
    Spinner region;
    int score;
    List<String> regions = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        PopulateRegions();
        score = getIntent().getIntExtra("score",0);
        scoreBar = (ProgressBar)findViewById(R.id.scoreProgressBar);
        scoreText = (TextView)findViewById(R.id.scoreTextView);
        region = (Spinner)findViewById(R.id.regionSpinner);
        scoreBar.setProgress((score/5)*100);
        scoreText.setText(score + "/ 5");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, regions);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        region.setAdapter(arrayAdapter);
    }
    public void PopulateRegions(){
        regions.add("India");
        regions.add("China");
        regions.add("USA");
        regions.add("Africa");
    }

    public void gfgClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/"));
        startActivity(intent);
    }

    public void restartClicked(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}