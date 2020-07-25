package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class settings_activity extends AppCompatActivity {
    TextView tvWeightPounds;
    SwitchCompat swWeight;
EditText etWeight;
boolean checked;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_activity);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        tvWeightPounds = findViewById(R.id.weight_pounds);
        swWeight = findViewById(R.id.switch_weight);
        etWeight = findViewById(R.id.weight);
        swWeight.setChecked(false);
        SharedPreferences sharedPreferences =  getSharedPreferences("save",MODE_PRIVATE);
        swWeight.setChecked(sharedPreferences.getBoolean("value",true));
        swWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swWeight.isChecked()){
                  Toast.makeText(getApplicationContext(),"Weight Changed to Pounds",Toast.LENGTH_SHORT).show();
                  SharedPreferences.Editor editor= getSharedPreferences("save",MODE_PRIVATE).edit();
                  editor.putBoolean("value",true);
                  editor.apply();
                  swWeight.setChecked(true);


                }

                else{
                    Toast.makeText(settings_activity.this, "Weight Changed to Kilograms", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor= getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    swWeight.setChecked(false);
                }

            }
        });
    }
}