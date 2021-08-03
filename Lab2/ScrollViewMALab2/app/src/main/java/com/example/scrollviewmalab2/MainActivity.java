package com.example.scrollviewmalab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText reason;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.nameEditText);
        email = (EditText)findViewById(R.id.emailEditText);
        reason = (EditText)findViewById(R.id.reasonEditText);
    }

    public void SubmitButtonClicked(View view) {
        if(name.getText().length()!=0 && email.getText().length() != 0 && reason.getText().length() != 0){
            Toast.makeText(MainActivity.this,"Submitted Successfully",Toast.LENGTH_SHORT).show();
            name.setText("");
            email.setText("");
            reason.setText("");
        }
        else{
            Toast.makeText(MainActivity.this,"Please Enter all the details.",Toast.LENGTH_SHORT).show();
        }
    }
}