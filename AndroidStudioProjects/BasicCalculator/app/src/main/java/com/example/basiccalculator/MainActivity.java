package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    Stack<String> memory = new Stack<>();
    boolean isCalculated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

    }

    public boolean updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        }
        display.setSelection(cursorPos + 1);
        return true;
    }

    public void pushBTN(View view){
        if(display.getText().toString().isEmpty()){
            display.setText("Enter a value");
            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getString(R.string.display).equals(display.getText().toString())){
                        display.setText("");
                    }
                }
            });
        }
        else{
            String result = equalsBTN(view);
            float resultFloat = Float.parseFloat(result);
            String operator, pushedResult;
            Expression exp;
            float sum = 0;
            if(memory.isEmpty()){
                operator = ""+sum+" + "+memory.push(Float.toString(resultFloat))+"";
                exp = new Expression(operator);
                pushedResult = String.valueOf(exp.calculate());
            }
            else{
                operator = ""+memory.pop()+" + "+memory.push(Float.toString(resultFloat))+"";
                exp = new Expression(operator);
                pushedResult = String.valueOf(exp.calculate());
                memory.push(pushedResult);
            }
            display.setText(pushedResult);
            display.setSelection(pushedResult.length());
        }
    }
    public void popBTN(View view){
        String nan = "NaN";
        if(memory.isEmpty()){
            display.setText(nan);
            display.setSelection(nan.length());
            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getString(R.string.display).equals(display.getText().toString())){
                        display.setText("");
                    }
                }
            });
        }
        else{
            String result = equalsBTN(view);
            String operator, pushedResult;
            Expression exp;
            operator = ""+memory.peek()+" - "+result+"";
            exp = new Expression(operator);
            pushedResult = String.valueOf(exp.calculate());
            memory.push(pushedResult);
            display.setText(pushedResult);
            display.setSelection(pushedResult.length());
        }
    }
    public void memclearBTN(View view){
        String nan = "NaN";
        String cleared = "Memory Cleared";
        if(memory.isEmpty()){
            display.setText(nan);
            display.setSelection(nan.length());
        }
        else{
            memory.clear();
            display.setText(cleared);
            display.setSelection(cleared.length());
            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getString(R.string.display).equals(display.getText().toString())){
                        display.setText("");
                    }
                }
            });
        }
    }
    public void peakBTN(View view){
        String nan = "NaN";
        if(memory.isEmpty()){
            display.setText(nan);
            display.setSelection(nan.length());
        }
        else{
            display.setText(memory.peek());
            display.setSelection(memory.peek().length());
            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getString(R.string.display).equals(display.getText().toString())){
                        display.setText("");
                    }
                }
            });
        }
    }


    public void clearBTN(View view){
        display.setText("");
    }

    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        if(cursorPos != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }


    public void moduloBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        String userInput = display.getText().toString();
        if(userInput.endsWith("÷") || userInput.endsWith("×") || userInput.endsWith("+") || userInput.endsWith("-")) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(textLength - 1, textLength, "%");
            display.setText(selection);
            display.setSelection(selection.length());
        }
        else{
            updateText("%");
        }
    }
    public void divideBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        String userInput = display.getText().toString();
        if(userInput.endsWith("%") || userInput.endsWith("×") || userInput.endsWith("+") || userInput.endsWith("-")) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(textLength - 1, textLength, "÷");
            display.setText(selection);
            display.setSelection(selection.length());
        }
        else{
            updateText("÷");
        }
    }
    public void multiplyBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        String userInput = display.getText().toString();
        if(userInput.endsWith("%") || userInput.endsWith("÷") || userInput.endsWith("+") || userInput.endsWith("-")) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(textLength - 1, textLength, "×");
            display.setText(selection);
            display.setSelection(selection.length());
        }
        else{
            updateText("×");
        }
    }
    public void addBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        String userInput = display.getText().toString();
        if(userInput.endsWith("%") || userInput.endsWith("÷") || userInput.endsWith("×") || userInput.endsWith("-")) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(textLength - 1, textLength, "+");
            display.setText(selection);
            display.setSelection(selection.length());
        }
        else{
            updateText("+");
        }
    }
    public void subtractBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        String userInput = display.getText().toString();
        if(userInput.endsWith("%") || userInput.endsWith("÷") || userInput.endsWith("×") || userInput.endsWith("+")) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(textLength - 1, textLength, "-");
            display.setText(selection);
            display.setSelection(selection.length());
        }
        else{
            updateText("-");
        }
    }
    public String equalsBTN(View view){
        String userInput = display.getText().toString();
        userInput = userInput.replaceAll("÷", "/");
        userInput = userInput.replaceAll("×", "*");
        userInput = userInput.replaceAll("%", "#");

        Expression exp = new Expression(userInput);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
        isCalculated = true;
        return result;
    }


    public void pointBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText(".");
    }
    public void parenthesisBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        int openPar = 0;
        int closedPar = 0;

        for(int i = 0; i < cursorPos; i++){
            if(display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if(display.getText().toString().substring(i, i+1).equals(")")){
                closedPar += 1;
            }
        }

        if(openPar == closedPar || display.getText().toString().substring(textLength - 1, textLength).equals("(")){
            updateText("(");
        }
        else if(closedPar < openPar && !display.getText().toString().substring(textLength - 1, textLength).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPos + 1);
    }


    public void zeroBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("0");
    }
    public void oneBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("1");
    }
    public void twoBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("2");
    }
    public void threeBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("3");
    }
    public void fourBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("4");
    }
    public void fiveBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("5");
    }
    public void sixBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("6");
    }
    public void sevenBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("7");
    }
    public void eightBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("8");
    }
    public void nineBTN(View view){
        if(isCalculated){
            display.setText("");
            isCalculated = false;
        }
        updateText("9");
    }

}