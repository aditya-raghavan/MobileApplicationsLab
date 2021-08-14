package com.example.lab4intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviesListActivity extends AppCompatActivity {
    TextView welcome;
    String user;
    ImageView hollywood;
    ImageView interstellar;
    ImageView wild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        welcome = (TextView)findViewById(R.id.welcomeTextView);
        user = getIntent().getStringExtra("username");
        welcome.setText("Welcome " + user);
        hollywood = (ImageView)findViewById(R.id.hollywoodImageView);
        interstellar = (ImageView)findViewById(R.id.interstellarImageView);
        wild = (ImageView)findViewById(R.id.wildImageView);
    }


    public void SeeMoreButtonClicked(View view) {
        Uri uri = Uri.parse("https://www.imdb.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void HollywoodClicked(View view) {
        Intent intent = new Intent(this,MovieActivity.class);
        startActivity(intent);
    }

    public void InterstellarClicked(View view) {
    }

    public void WildClicked(View view){

    }
}