package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;

    double value1, value2;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.etDisplay);

        Button b0=findViewById(R.id.b0);
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        Button b5=findViewById(R.id.b5);
        Button b6=findViewById(R.id.b6);
        Button b7=findViewById(R.id.b7);
        Button b8=findViewById(R.id.b8);
        Button b9=findViewById(R.id.b9);

        Button dot=findViewById(R.id.bDot);

        Button add=findViewById(R.id.bAdd);
        Button sub=findViewById(R.id.bSub);
        Button mul=findViewById(R.id.bMul);
        Button div=findViewById(R.id.bDiv);

        Button equal=findViewById(R.id.bEqual);
        Button clear=findViewById(R.id.bClear);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button)v;
                et.append(b.getText().toString());
            }
        };

        b0.setOnClickListener(numberListener);
        b1.setOnClickListener(numberListener);
        b2.setOnClickListener(numberListener);
        b3.setOnClickListener(numberListener);
        b4.setOnClickListener(numberListener);
        b5.setOnClickListener(numberListener);
        b6.setOnClickListener(numberListener);
        b7.setOnClickListener(numberListener);
        b8.setOnClickListener(numberListener);
        b9.setOnClickListener(numberListener);
        dot.setOnClickListener(numberListener);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1=Double.parseDouble(et.getText().toString());
                operator='+';
                et.setText("");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1=Double.parseDouble(et.getText().toString());
                operator='-';
                et.setText("");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1=Double.parseDouble(et.getText().toString());
                operator='*';
                et.setText("");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1=Double.parseDouble(et.getText().toString());
                operator='/';
                et.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value2=Double.parseDouble(et.getText().toString());

                double result=0;

                switch(operator)
                {
                    case '+':
                        result=value1+value2;
                        break;

                    case '-':
                        result=value1-value2;
                        break;

                    case '*':
                        result=value1*value2;
                        break;

                    case '/':
                        if(value2!=0)
                            result=value1/value2;
                        else
                        {
                            et.setText("Error");
                            return;
                        }
                        break;
                }

                et.setText(String.valueOf(result));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                value1=0;
                value2=0;
            }
        });

    }
}
