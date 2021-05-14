package com.example.bmiapp;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    int intHeight, intWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight=(EditText)findViewById(R.id.txtWeight);
        final EditText height=(EditText)findViewById(R.id.txtHeight);
        Button btStatus = (Button)findViewById(R.id.btnCompute);
        final SharedPreferences sharedPref =PreferenceManager.getDefaultSharedPreferences(this);
        btStatus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                intWeight = Integer.parseInt(weight.getText().toString());
                intHeight = Integer.parseInt(height.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intWeight);
                editor.putInt("key2", intHeight);
                editor.apply();
                startActivity(new Intent(MainActivity.this, Bmi.class));
            }
        });
    }



}
