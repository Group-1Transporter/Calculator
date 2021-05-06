package com.example.calculatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.calculatar.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    protected Double inputNumber1 = Double.NaN;
    protected Double inputNumber2;
    private char operation;
    private final char Addition = '+';
    private final char Subtraction = '-';
    private final char Multiplication = '*';
    private final char Division = '/';
    private final char Equ = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.btn0.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "0"));
        binding.btn1.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "1"));
        binding.btn2.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "2"));
        binding.btn3.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "3"));
        binding.btn4.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "4"));
        binding.btn5.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "5"));
        binding.btn6.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "6"));
        binding.btn7.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "7"));
        binding.btn8.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "8"));
        binding.btn9.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "9"));
        binding.btnDot.setOnClickListener(view -> binding.numDetails.setText(binding.numDetails.getText().toString() + "."));


        binding.btnAddition.setOnClickListener(view -> {

            if (!Double.isNaN(inputNumber1) || !TextUtils.isEmpty(binding.numDetails.getText().toString())) {
                compute();
                operation = Addition;
                binding.result.setText(String.valueOf(inputNumber1) + "+");
                binding.numDetails.setText(null);
            }


        });

        binding.btnSubtraction.setOnClickListener(view -> {
            if (!Double.isNaN(inputNumber1) || operation == Subtraction || !TextUtils.isEmpty(binding.numDetails.getText().toString())) {

                compute();
                operation = Subtraction;
                binding.result.setText(String.valueOf(inputNumber1) + "-");
                binding.numDetails.setText(null);
            } else {

                operation = Subtraction;


            }
        });
        binding.btnMultiply.setOnClickListener(view -> {
            if (!Double.isNaN(inputNumber1) || !TextUtils.isEmpty(binding.numDetails.getText().toString())) {
                compute();
                operation = Multiplication;
                binding.result.setText(String.valueOf(inputNumber1) + "*");
                binding.numDetails.setText(null);
            }
        });
        binding.btnDivide.setOnClickListener(view -> {
            if (!Double.isNaN(inputNumber1) || !TextUtils.isEmpty(binding.numDetails.getText().toString())) {
                compute();
                operation = Division;
                binding.result.setText(String.valueOf(inputNumber1) + "/");
                binding.numDetails.setText(null);
            }
        });

        binding.btnEqual.setOnClickListener(view -> {
            if (operation == '\0') {

            } else {
                compute();
                operation = Equ;
                binding.result.setText(binding.result.getText().toString() + String.valueOf(inputNumber2));
                binding.resultFinal.setText(String.valueOf(inputNumber1));

            /*result  5+
                inputNumber2 5=
                inputNumber1 10
            */

            }
            inputNumber1 = Double.NaN;
            inputNumber2 = Double.NaN;
            operation = '\0';
            binding.numDetails.setText(null);
        });

        binding.btnClear.setOnClickListener(view -> {

            inputNumber1 = Double.NaN;
            inputNumber2 = Double.NaN;
            binding.numDetails.setText(null);
            binding.result.setText(null);
            binding.resultFinal.setText(null);


        });
        binding.btnBack.setOnClickListener(view -> {
            if (binding.numDetails.getText().length() > 0) {
                CharSequence name = binding.numDetails.getText().toString();
                binding.numDetails.setText(name.subSequence(0, name.length() - 1));
            } else {
                inputNumber1 = Double.NaN;
                inputNumber2 = Double.NaN;
                binding.numDetails.setText(null);
                binding.result.setText(null);
                binding.resultFinal.setText(null);
            }
        });


    }

    private void compute() {
        if (!Double.isNaN(inputNumber1)) {
            inputNumber2 = Double.parseDouble(binding.numDetails.getText().toString());
            switch (operation) {
                case Addition:
                    inputNumber1 = inputNumber1 + inputNumber2;
                    break;
                case Subtraction:
                    inputNumber1 = inputNumber1 - inputNumber2;
                    break;
                case Multiplication:
                    inputNumber1 = inputNumber1 * inputNumber2;
                    break;
                case Division:
                    inputNumber1 = inputNumber1 / inputNumber2;
                    break;
                case Equ:
                    break;
            }
        } else {

            if (operation == Subtraction) {
                inputNumber1 = 0 - Double.parseDouble(binding.numDetails.getText().toString());
            } else {
                inputNumber1 = Double.parseDouble(binding.numDetails.getText().toString());
            }
        }
    }

}