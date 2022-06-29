package com.example.sci_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity {
    TextView tNum1, tNum2, result;
    Button bAdd, bMinus, bMultiply, bDivide, bSin, bCos, bTan, bLog, bPow, bSqrt, bClear, bLoc;
    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
            Uri.parse("https://www.google.com/maps/@26.4711483,73.1231582,15z?hl=fr"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAdd = findViewById(R.id.badd);
        bMinus = findViewById(R.id.bsub);
        bMultiply = findViewById(R.id.bmul);
        bDivide = findViewById(R.id.bdiv);
        bSin = findViewById(R.id.bsin);
        bCos = findViewById(R.id.bcos);
        bTan = findViewById(R.id.btan);
        bLog = findViewById(R.id.blog);
        bSqrt = findViewById(R.id.sqrt);
        bPow = findViewById(R.id.bpow);
        bClear = findViewById(R.id.bclear);
        bLoc = findViewById(R.id.bloc);
        tNum1 = findViewById(R.id.bnum1);
        tNum2 = findViewById(R.id.bnum2);
        result = findViewById(R.id.bresult);
    }


    public void calculate(View view) {
        double num1=0;
        double num2=0;
        try {
            num1 = Double.parseDouble(tNum1.getText().toString());
            num2 = Double.parseDouble(tNum2.getText().toString());

            switch (view.getId()) {
                case R.id.badd:
                    result.setText(String.format("%s", num1 + num2));
                    break;
                case R.id.bsub:
                    result.setText(String.format("%s", num1 - num2));
                    break;
                case R.id.bmul:
                    result.setText(String.format("%s", num1 * num2));
                    break;
                case R.id.bdiv:
                    result.setText(String.format("%s", num1 / num2));
                    break;
                case R.id.bsin:
                    result.setText(String.format("sin(%f)=%s",num1, sin(num1)));
                    break;
                case R.id.bcos:
                    result.setText(String.format("cos(%f)=%s",num1,cos(num1)));
                    break;
                case R.id.btan:
                    result.setText(String.format("tan(%f)=%s",num1,tan(num1)));
                    break;
                case R.id.bclear:
                    result.setText("");
                    tNum1.setText("");
                    tNum2.setText("");
                    break;
                case R.id.bpow:
                    result.setText(String.format("%s",pow(num1,num2)));
                    break;
                case R.id.sqrt:
                    result.setText(String.format("sqrt(%.3f) =%.6f",num1,sqrt(num1)));
                    break;
                case R.id.blog:
                    result.setText(String.format("log of %1$.2f base %2$.2f %3$.2f ",num2,num1,(log(num2))/(log(num1))));
                    break;
                case R.id.bloc:
                    startActivity(intent);
                    break;

            }
        }catch (Exception e){
            Log.e("Error",e.toString());
        }

    }
}