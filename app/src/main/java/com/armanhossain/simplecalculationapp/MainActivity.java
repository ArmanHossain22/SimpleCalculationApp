package com.armanhossain.simplecalculationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText etInch;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findView();
        setCalculateButtonOnClickListener();
    }

    private void findView() {
        etInch = findViewById(R.id.et_inch);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
    }

    private void setCalculateButtonOnClickListener() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchText = etInch.getText().toString();
                if (inchText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter inch", Toast.LENGTH_SHORT).show();
                } else {
                    double meter = convertInchToMeter(inchText);
                    displayResult(meter);
                }
            }
        });
    }

    private double convertInchToMeter(String inchText) {
        double inch = Double.parseDouble(inchText);
        return inch * 0.0254;
    }

    private void displayResult(double meter) {
        DecimalFormat decimalFormatter = new DecimalFormat("#.##");
        String meterText = decimalFormatter.format(meter);
        String resultText = meterText + " (m)";
        tvResult.setText(resultText);
    }
}