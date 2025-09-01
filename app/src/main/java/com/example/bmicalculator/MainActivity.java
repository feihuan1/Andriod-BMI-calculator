package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resutText = findViewById(R.id.text_view_result);

        RadioButton radioButtonMale = findViewById(R.id.radio_button_male);
        RadioButton radioButtonFemale = findViewById(R.id.radio_button_female);

        EditText editTextAge = findViewById(R.id.edit_text_age);
        EditText editTextFeet = findViewById(R.id.edit_text_feet);
        EditText editTextInches = findViewById(R.id.edit_text_inches);
        EditText editTextweight = findViewById(R.id.edit_text_weight);

        Button calculateButton = findViewById(R.id.button_calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked",Toast.LENGTH_LONG).show();
            }
        });

//        resutText.setText("Woohoo, Updated");
//        String alertText = "OMG, I can code in Java";
//        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();
    }
}