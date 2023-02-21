package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText epa,eir,ltm;

    Button calculate;

    TextView Emi,TotalAmount,InterestAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epa = findViewById(R.id.epa);
        eir = findViewById(R.id.eir);
        ltm = findViewById(R.id.ltm);
        calculate = findViewById(R.id.calculate);
        Emi = findViewById(R.id.Emi);
        TotalAmount=findViewById(R.id.TotalAmount);
        InterestAmount=findViewById(R.id.IntrestAmount);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ep = Integer.parseInt(epa.getText().toString());
                double ei = Double.parseDouble(eir.getText().toString());
                int lt = Integer.parseInt(ltm.getText().toString());

             double r= ei/(12*100);
             double cal1 = 1;
                for (int i = 0; i <lt ; i++) {
                    cal1 *=(1+r);
                }

               double ans = ep*r*(cal1/(cal1-1));
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                Emi.setText("EMI ="+df.format(ans));
                double total = ans*lt;
                TotalAmount.setText("Total Amount= "+df.format(total));
                double iAmount = total-ep;
                InterestAmount.setText("Interest Amount= "+df.format(iAmount));
            }
        });


    }
}