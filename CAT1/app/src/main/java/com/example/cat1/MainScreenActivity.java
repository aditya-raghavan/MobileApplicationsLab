package com.example.cat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainScreenActivity extends AppCompatActivity {
    String name;
    TextView user;
    TextView noOfVehicles;
    TextView totalFee;
    int twoWheelerFee = 100;
    int fourWheelerFee = 200;
    int busFee = 400;
    int vipFee = 0;
    int rfidFee = 50;
    int vehicleCount = 0;
    int fee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        name = getIntent().getExtras().getString("userID");
        user = (TextView) findViewById(R.id.welcomeTextView);
        user.setText("Welcome " + name);
        noOfVehicles = (TextView)findViewById(R.id.noVechiclesTextView);
        noOfVehicles.setText(String.valueOf(vehicleCount));
        totalFee = (TextView)findViewById(R.id.totalFeeTextView);
        totalFee.setText(String.valueOf(fee));
    }
    public void UpdateFee(){
        noOfVehicles.setText(String.valueOf(vehicleCount));
        totalFee.setText(String.valueOf(fee) + ".00 Rs");
    }

    public void twoWheelerLayoutClicked(View view) {
        vehicleCount = vehicleCount + 1;
        fee = fee + 100;
        UpdateFee();
        Snackbar.make((LinearLayout)findViewById(R.id.rootLayout),"Two Wheeler Fee Collected",Snackbar.LENGTH_SHORT).show();
    }

    public void fourWheelerLayoutClicked(View view) {
        vehicleCount = vehicleCount + 1;
        fee = fee + 200;
        UpdateFee();
        Snackbar.make((LinearLayout)findViewById(R.id.rootLayout),"Four Wheeler Fee Collected",Snackbar.LENGTH_SHORT).show();
    }

    public void BusLayoutClicked(View view) {
        vehicleCount = vehicleCount + 1;
        fee = fee + 400;
        UpdateFee();
        Snackbar.make((LinearLayout)findViewById(R.id.rootLayout),"Bus/Truck Fee Collected",Snackbar.LENGTH_SHORT).show();
    }

    public void VipLayoutClicked(View view) {
        vehicleCount = vehicleCount + 1;
        fee = fee + 0;
        UpdateFee();
        Snackbar.make((LinearLayout)findViewById(R.id.rootLayout),"Vip/Pass Fee Collected",Snackbar.LENGTH_SHORT).show();
    }

    public void rfidLayoutClicked(View view) {
        vehicleCount = vehicleCount + 1;
        fee = fee + 50;
        UpdateFee();
        Snackbar.make((LinearLayout)findViewById(R.id.rootLayout),"RFID Fee Collected",Snackbar.LENGTH_SHORT).show();
    }
}