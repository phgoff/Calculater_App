package com.phirathat.com.calculater_app;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.phirathat.com.calculater_app.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char value;
    private double input1 = Double.NaN;
    private double input2;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.#####");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + ".");
            }
        });

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                value = ADDITION;
                binding.tvans.setText(decimalFormat.format(input1) + "+");
                binding.editText.setText(null);
            }
        });

        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                value = SUBTRACTION;
                binding.tvans.setText(decimalFormat.format(input1) + "-");
                binding.editText.setText(null);
            }
        });

        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                value = MULTIPLICATION;
                binding.tvans.setText(decimalFormat.format(input1) + "*");
                binding.editText.setText(null);
            }
        });

        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                value = DIVISION;
                binding.tvans.setText(decimalFormat.format(input1) + "/");
                binding.editText.setText(null);
            }
        });

        binding.btnans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                binding.tvans.setText(binding.tvans.getText().toString() +
                        decimalFormat.format(input2) + " = " + decimalFormat.format(input1));
                input1 = Double.NaN;
                value = '0';
            }
        });

        binding.btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText("");
                binding.tvans.setText("");
            }
        });
    }

    private void calculate() {
        if(!Double.isNaN(input1)) {
            input2 = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);
            if(value == ADDITION)
                input1 = this.input1 + input2;
            else if(value == SUBTRACTION)
                input1 = this.input1 - input2;
            else if(value == MULTIPLICATION)
                input1 = this.input1 * input2;
            else if(value == DIVISION)
                input1 = this.input1 / input2;
        }
        else {
            try {
                input1 = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}

