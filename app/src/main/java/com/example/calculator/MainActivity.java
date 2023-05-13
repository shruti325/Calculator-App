//package com.example.calculator;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.text.Editable;
//import android.widget.EditText;
//
//import com.google.android.material.button.MaterialButton;
//
//public class MainActivity extends AppCompatActivity {
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        EditText editText = findViewById(R.id.edit_text);
//
//        editText.setShowSoftInputOnFocus(false);
//
//        MaterialButton keypad1 = findViewById(R.id.keypad1);
//        MaterialButton keypad2 = findViewById(R.id.keypad2);
//        MaterialButton keypad3 = findViewById(R.id.keypad3);
//        MaterialButton keypad4 = findViewById(R.id.keypad4);
//        MaterialButton keypad5 = findViewById(R.id.keypad5);
//        MaterialButton keypad6 = findViewById(R.id.keypad6);
//        MaterialButton keypad7 = findViewById(R.id.keypad7);
//        MaterialButton keypad8 = findViewById(R.id.keypad8);
//        MaterialButton keypad9 = findViewById(R.id.keypad9);
//        MaterialButton keypad0 = findViewById(R.id.keypad0);
//        MaterialButton keypaddivide = findViewById(R.id.keypadDivide);
//        MaterialButton keypadmultiply = findViewById(R.id.keypadMultiply);
//        MaterialButton keypadadd = findViewById(R.id.keypadAdd);
//        MaterialButton keypadsubstract = findViewById(R.id.keypadSubstract);
//        MaterialButton keypadequal = findViewById(R.id.keypadEqual);
//        MaterialButton keypadac = findViewById(R.id.keypadAc);
//        MaterialButton keypaddot = findViewById(R.id.keypadDot);
//        MaterialButton keypadc = findViewById(R.id.keypadC);
//        MaterialButton keypadmodulus = findViewById(R.id.keypadModulus);
//
//        keypad1.setOnClickListener(v -> {
//            editText.append("1");
//        });
//        keypad2.setOnClickListener(v -> {
//            editText.append("2");
//        });
//        keypad3.setOnClickListener(v -> {
//            editText.append("3");
//        });
//        keypad4.setOnClickListener(v -> {
//            editText.append("4");
//        });
//        keypad5.setOnClickListener(v -> {
//            editText.append("5");
//        });
//        keypad6.setOnClickListener(v -> {
//            editText.append("6");
//        });
//        keypad7.setOnClickListener(v -> {
//            editText.append("7");
//        });
//        keypad8.setOnClickListener(v -> {
//            editText.append("8");
//        });
//        keypad9.setOnClickListener(v -> {
//            editText.append("9");
//        });
//        keypad0.setOnClickListener(v -> {
//            editText.append("0");
//        });
//
//        keypaddot.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty() && !text.contains(".")){
//                editText.append(".");
//            }
//        });
//
//        keypadadd.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty()){
//                editText.append("+");
//            }
//        });
//
//        keypadsubstract.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty()){
//                editText.append("-");
//            }
//        });
//
//        keypadmultiply.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty() ){
//                editText.append("*");
//            }
//        });
//
//        keypaddivide.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty()){
//                editText.append("/");
//            }
//        });
//
//        keypadmodulus.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty() ){
//                editText.append("%");
//            }
//        });
//
//        keypadc.setOnClickListener(v -> {
//            final Editable editable = editText.getText();
//            if (!editable.toString().isEmpty()){
//                editable.delete(editable.toString().length() - 1,editable.length());
//            }
//        });
//
//        keypadac.setOnClickListener(v -> {
//            final Editable editable = editText.getText();
//            if (!editable.toString().isEmpty()){
//                editable.clear();
//            }
//        });
//
//    }
//}

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Stack<Double> operandStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit_text);
        editText.setShowSoftInputOnFocus(false);
        operandStack = new Stack<>();

        MaterialButton keypad1 = findViewById(R.id.keypad1);
        MaterialButton keypad2 = findViewById(R.id.keypad2);
        MaterialButton keypad3 = findViewById(R.id.keypad3);
        MaterialButton keypad4 = findViewById(R.id.keypad4);
        MaterialButton keypad5 = findViewById(R.id.keypad5);
        MaterialButton keypad6 = findViewById(R.id.keypad6);
        MaterialButton keypad7 = findViewById(R.id.keypad7);
        MaterialButton keypad8 = findViewById(R.id.keypad8);
        MaterialButton keypad9 = findViewById(R.id.keypad9);
        MaterialButton keypad0 = findViewById(R.id.keypad0);
        MaterialButton keypaddivide = findViewById(R.id.keypadDivide);
        MaterialButton keypadmultiply = findViewById(R.id.keypadMultiply);
        MaterialButton keypadadd = findViewById(R.id.keypadAdd);
        MaterialButton keypadsubtract = findViewById(R.id.keypadSubstract);
        MaterialButton keypadequal = findViewById(R.id.keypadEqual);
        MaterialButton keypadac = findViewById(R.id.keypadAc);
        MaterialButton keypaddot = findViewById(R.id.keypadDot);
        MaterialButton keypadc = findViewById(R.id.keypadC);
        MaterialButton keypadmodulus = findViewById(R.id.keypadModulus);

        keypad1.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("1");
        });
        keypad2.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("2");
        });
        keypad3.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("3");
        });
        keypad4.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("4");
        });
        keypad5.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("5");
        });
        keypad6.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("6");
        });
        keypad7.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("7");
        });
        keypad8.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("8");
        });
        keypad9.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("9");
        });
        keypad0.setOnClickListener(v -> {
            editText.getText().clear();
            editText.append("0");
        });

        keypaddot.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty() && !text.contains(".")) {
                editText.append(".");
            }
        });

        keypadadd.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                double operand = Double.parseDouble(text);
                operandStack.push(operand);
                editText.getText().clear();
                editText.append("+");
                operandStack.push((double) 1);
            }
        });

        keypadsubtract.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                double operand = Double.parseDouble(text);
                operandStack.push(operand);
                editText.getText().clear();
                editText.append("-");
                operandStack.push((double) 2);
            }
        });

        keypadmultiply.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                double operand = Double.parseDouble(text);
                operandStack.push(operand);
                editText.getText().clear();
                editText.append("*");
                operandStack.push((double) 3);
            }
        });

        keypadmodulus.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                double operand = Double.parseDouble(text);
                operandStack.push(operand);
                editText.getText().clear();
                editText.append("%");
                operandStack.push((double) 4);
            }
        });

        keypaddivide.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                double operand = Double.parseDouble(text);
                operandStack.push(operand);
                editText.getText().clear();
                editText.append("/");
                operandStack.push((double) 5);
            }
        });

        keypadequal.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                double operand = Double.parseDouble(text);
                operandStack.push(operand);
                double result = evaluate();
                editText.getText().clear();
                editText.append(String.valueOf(result));
            }
        });

        keypadac.setOnClickListener(v -> {
            editText.getText().clear();
            operandStack.clear();
        });

        keypadc.setOnClickListener(v -> {
            editText.getText().delete(editText.length() - 1, editText.length());
        });
    }

    private double evaluate() {
        double result = 0;

        if (operandStack.size() >= 3) {
            double operand2 = operandStack.pop();
            double operator = operandStack.pop();
            double operand1 = operandStack.pop();
            
            int op = (int) operator;

            switch (op) {
                case 1:
                    result = operand1 + operand2;
                    break;
                case 2:
                    result = operand1 - operand2;
                    break;
                case 3:
                    result = operand1 * operand2;
                    break;
                case 4:
                    result = operand1 % operand2;
                    break;
                case 5:
                    result = operand1 / operand2;
                    break;
                default:
                    break;
            }

            operandStack.push(result);
        }

        return result;
    }
}
