package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare input and output UI elements
    EditText num1, num2;
    TextView result;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnMod, btnPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Load UI from XML layout

        // Connect UI elements to variables
        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        result = findViewById(R.id.textViewResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnMod = findViewById(R.id.btnMod);
        btnPower = findViewById(R.id.btnPower);

        // Define a shared click listener for all buttons
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from both fields
                String input1 = num1.getText().toString().trim();
                String input2 = num2.getText().toString().trim();

                // Validation: check if inputs are empty
                if (input1.isEmpty() || input2.isEmpty()) {
                    result.setText("Please enter a value.");
                    return;
                }

                // Convert inputs to numbers
                double n1 = Double.parseDouble(input1);
                double n2 = Double.parseDouble(input2);
                double res;

                // Perform calculation based on clicked button
                int id = v.getId();

                if (id == R.id.btnAdd) {
                    res = n1 + n2;
                } else if (id == R.id.btnSubtract) {
                    res = n1 - n2;
                } else if (id == R.id.btnMultiply) {
                    res = n1 * n2;
                } else if (id == R.id.btnDivide) {
                    if (n2 == 0) {
                        result.setText("Cannot divide by zero.");
                        return;
                    }
                    res = n1 / n2;
                } else if (id == R.id.btnMod) {
                    res = n1 % n2;
                } else if (id == R.id.btnPower) {
                    res = Math.pow(n1, n2);
                } else {
                    result.setText("Unknown operation.");
                    return;
                }

                // Show the result
                result.setText("Result: " + res);
            }
        };

        // Attach the listener to each operation button
        btnAdd.setOnClickListener(listener);
        btnSubtract.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
        btnMod.setOnClickListener(listener);
        btnPower.setOnClickListener(listener);
    }
}
