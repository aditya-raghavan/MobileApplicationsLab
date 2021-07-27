package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    int index = 0;
    LinearLayout mainView;
    String[] colors = {"#000000","#ffff00","#333333","#0000ff","#9900cc","#ff6600","#663300"};
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = (LinearLayout)findViewById(R.id.mainLayout);
    }

    public void countButtonClicked(View view) {
        count++;
        index++;

        mainView.setBackgroundColor(Color.parseColor(colors[index]));
        if(index == 6){
            index = -1;
        }
        textView = (TextView)findViewById(R.id.countTextView);
        if(textView!= null){
            textView.setText(Integer.toString(count));
        }
    }

    public void ToastButtonClicked(View view) {
        Toast toast = Toast.makeText(this, "Current Count : " + Integer.toString(count), Toast.LENGTH_SHORT);
        toast.getView().setBackgroundColor(Color.parseColor("#ff0066"));
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }
}