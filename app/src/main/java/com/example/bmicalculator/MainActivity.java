package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String alertText = "OMG, I can code in Java";

        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();

    }
}