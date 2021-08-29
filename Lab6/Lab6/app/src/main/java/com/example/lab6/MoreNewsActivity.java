package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MoreNewsActivity extends AppCompatActivity {
    Boolean playing = false;
    MediaPlayer mp;
    ToggleButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_news);
        mp = MediaPlayer.create(getBaseContext(),R.raw.time);
        playButton = (ToggleButton)findViewById(R.id.playButton);
    }

    public void jimmySaxClicked(View view) {
        if(!playing){
            mp.start();
            playButton.toggle();
            playing = true;
            ProgressDialog pds = new ProgressDialog(MoreNewsActivity.this);
            pds.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pds.setMessage("Playing Jimmy Sax - Time");
            pds.setIndeterminate(true);
            pds.setCancelable(true);
            pds.show();
        }
    }

    public void PlayButtonClicked(View view) {
        if(playButton.getText().toString()=="Play" && !playing){
            mp.start();
            playing = true;
            ProgressDialog pds = new ProgressDialog(MoreNewsActivity.this);
            pds.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pds.setMessage("Playing Jimmy Sax - Time");
            pds.setIndeterminate(true);
            pds.setCancelable(true);
            pds.show();

        }
        else{
            mp.stop();
            playing = false;
        }
    }

    public void WebsiteClicked(View view) {
        Intent intent = new Intent(this, WebsiteActivity.class);
        startActivity(intent);

    }
}