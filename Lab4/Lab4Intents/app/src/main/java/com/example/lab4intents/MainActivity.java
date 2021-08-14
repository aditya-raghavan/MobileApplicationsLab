package com.example.lab4intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String user;
    String userPassword;
    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText)findViewById(R.id.userNameEditText);
        password = (EditText)findViewById((R.id.passwordEditText));
        user = "2047204";
        userPassword = "Hello123";
    }

    public Boolean Validation(){
        if(userName.getText().toString().equals(user) && password.getText().toString().equals(userPassword)){
            return true;
        }
        else{
            return false;
        }
    }

    public void loginButtonClicked(View view) {
        if(Validation()){
            Intent intent = new Intent(this,MoviesListActivity.class);
            intent.putExtra("username",userName.getText().toString());
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Account not found",Toast.LENGTH_SHORT).show();
        }
    }
}