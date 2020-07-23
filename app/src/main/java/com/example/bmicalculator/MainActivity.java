package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText etHeight, etWeight;
   Button btnCalc;
   TextView tvResult,tvRemarks;
   final String normal = "Normal";
   final String obese = "Obese";
   final String ovrWeight = "Over Weight";
   final String UnderWeight = "Under Weight";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         etHeight = findViewById(R.id.height);
         etWeight= findViewById(R.id.weight);
         btnCalc = findViewById(R.id.calc_btn);
         tvResult = findViewById(R.id.result);
         tvRemarks = findViewById(R.id.remarks);

         btnCalc.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 calculate();
             }
         });
    }

    public void calculate(){
            String weight = etWeight.getText().toString();
            String height = etHeight.getText().toString();
            if(weight.isEmpty()){
                etWeight.setError("Enter Weight");
            }
            else if(height.isEmpty()){
                etHeight.setError("Enter Height");
            }

            else {
                float h = Float.parseFloat(height);
                float w = Float.parseFloat(weight);
                double a = (h * h * 0.01 * 0.01 );
                double bmi = w /a;


                if(bmi >= 18.5 && bmi <= 25.0)
                {
                    tvRemarks.setText("Normal");
                }
                else if( bmi <=18.5){
                    tvRemarks.setText(UnderWeight);
                }
                else if( bmi >= 25.0 && bmi <= 30.0){
                    tvRemarks.setText(ovrWeight);
                }
                else if( bmi >30.0){
                    tvRemarks.setText(obese);
                }
                 int res = (int) bmi;
                tvResult.setText(String.valueOf(res));


            }


    }
}