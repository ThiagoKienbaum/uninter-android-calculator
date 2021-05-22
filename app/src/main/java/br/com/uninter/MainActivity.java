package br.com.uninter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView mathExpressionView;
    TextView mathResultView;
    String expression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViews();
    }

    private void initViews() {
        mathExpressionView = (TextView)findViewById(R.id.mathExpressionView);
        mathResultView = (TextView)findViewById(R.id.mathResultView);
    }

    private void setExpression(String value) {
        expression = expression + value;
        mathExpressionView.setText(expression);
    }

    public void additionOnClick(View view) {
        setExpression("+");
    }

    public void subtractionOnClick(View view) {
        setExpression("-");
    }

    public void multiplicationOnClick(View view) {
        setExpression("X");
    }

    public void divisionOnClick(View view) {
        setExpression("/");
    }

    public void clearOnClick(View view) {
        mathExpressionView.setText("");
        mathResultView.setText("");
        expression = "";
    }

    public void backspaceOnClick(View view) {
        CharSequence expressionText = mathExpressionView.getText();
        expressionText = expressionText.subSequence(0, expressionText.length() - 1);
        mathExpressionView.setText(expressionText);
        expression = expressionText.toString();
    }

    public void equalsOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double) engine.eval(expression);
        } catch (ScriptException scriptException) {
            Toast.makeText(this, "Expressão invalida", Toast.LENGTH_SHORT).show();
        }

        if (result != null) {
            mathResultView.setText(String.valueOf(result.doubleValue()));
        }
    }

    public void separatorOnClick(View view) {
        setExpression(".");
    }

    public void zeroOnClick(View view) {
        setExpression("0");
    }

    public void oneOnClick(View view) {
        setExpression("1");
    }

    public void twoOnClick(View view) {
        setExpression("2");
    }

    public void threeOnClick(View view) {
        setExpression("3");
    }

    public void fourOnClick(View view) {
        setExpression("4");
    }

    public void fiveOnClick(View view) {
        setExpression("5");
    }

    public void sixOnClick(View view) {
        setExpression("6");
    }

    public void sevenOnClick(View view) {
        setExpression("7");
    }

    public void eightOnClick(View view) {
        setExpression("8");
    }

    public void nineOnClick(View view) {
        setExpression("9");
    }
}