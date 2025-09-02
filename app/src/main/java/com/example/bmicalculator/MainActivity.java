package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //class variable || fields
    private TextView resutText;
    private Button calculateButton;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextAge;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupbuttonClickListener();
    }

    private void findViews() {
        resutText = findViewById(R.id.text_view_result);

        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        editTextweight = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupbuttonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmi = calculateBmi();

                String ageText = editTextAge.getText().toString();

                if (IsNotInterger(ageText)) {
                    Toast.makeText(v.getContext(), "Please enter valid numbers in all fields.", Toast.LENGTH_LONG).show();
                    return;
                }

                int age = Integer.parseInt(ageText);

                if(age >= 18){
                    displayResult(bmi);
                } else {
                    displayGuidance(bmi);
                }
            }
        });
    }

    private double calculateBmi() {
        String feetText = editTextFeet.getText().toString();
        String inchesText = editTextInches.getText().toString();
        String weightText = editTextweight.getText().toString();

        if (IsNotInterger(feetText) || IsNotInterger(inchesText) || IsNotInterger(weightText)) {
            Toast.makeText(this, "Please enter valid numbers in all fields.", Toast.LENGTH_LONG).show();
            return 0;
        }

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;
        double heightInMeters = totalInches * 0.0254;

        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiText = myDecimalFormatter.format(bmi);

        String fullResultString;

        if (bmi < 18.5) {
            // too thin
            fullResultString = bmiText + " - You are too thin";
        } else if (bmi > 25) {
            // too fat
            fullResultString = bmiText + " - You are too fat";
        } else {
            fullResultString = bmiText + " - You are normal";
        }

        resutText.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiText = myDecimalFormatter.format(bmi);

        String fullResultString;

        if (radioButtonMale.isChecked()){
            fullResultString = bmiText + " - As you are under18, eat more boy";
        } else if(radioButtonFemale.isChecked()) {
            fullResultString = bmiText + " - As you are under18, eat more girl";
        } else {
            fullResultString = bmiText + " - As you are under18, eat more";
        }

        resutText.setText(fullResultString);
    }

    private boolean IsNotInterger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}