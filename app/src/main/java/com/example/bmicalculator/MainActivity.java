package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
   EditText etHeight, etWeight;
   Button btnCalc;
   TextView tvResult,tvRemarks;

   final String normal = getString(R.string.remark_normal);
   final String obese = getString(R.string.remark_obese);
   final String ovrWeight = getString(R.string.remark_overweight);
   final String UnderWeight = getString(R.string.remark_underweight);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         etHeight = findViewById(R.id.height);
         etWeight= findViewById(R.id.weight);
         btnCalc = findViewById(R.id.calc_btn);
         tvResult = findViewById(R.id.result);
         tvRemarks = findViewById(R.id.remarks);

        etWeight.setHint("Weight in Kgs");

         btnCalc.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 closeKeyboard();
                 calculate();
             }
         });


    }

    public void closeKeyboard(){

        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }



    }  //Collapse Keyboard

    public void calculate(){
            String weight = etWeight.getText().toString();
            String height = etHeight.getText().toString();
            if(weight.isEmpty()){
                etWeight.setError("Kindly enter your Weight");
            }
            else if(height.isEmpty()){
                etHeight.setError("Kindly enter your Height");
            }

            else {
                float h = Float.parseFloat(height);
                float w = Float.parseFloat(weight);
                double a = (h * h * 0.01 * 0.01 );

                double bmi = w /a;




                if(bmi >= 18.5 && bmi <= 25.0)
                {
                    tvRemarks.setText(normal);
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
                tvResult.setText(String.valueOf("res"));


            }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_tab,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
   switch (item.getItemId()){
       case R.id.ic_settings:
           Intent settings_intent = new Intent(getApplicationContext(),settings_activity.class);
           startActivity(settings_intent);
           break;

       case R.id.ic_info_chart:
           Intent charViewIntent = new Intent(getApplicationContext(),bmi_chart.class);
           startActivity(charViewIntent);
           break;

   }

        return super.onOptionsItemSelected(item);
    }


}
