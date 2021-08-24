package com.example.cat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.nameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
    }

    public void loginButtonClicked(View view) {
        if(userName.getText().toString().equals("User123") && password.getText().toString().equals("Password123")){
            Intent i = new Intent(this, MainScreenActivity.class);
            i.putExtra("userID",userName.getText().toString());
            startActivity(i);
        }
        else{
            Toast.makeText(getApplicationContext(),"Invalid User ID or Password", Toast.LENGTH_SHORT).show();
        }
    }
}