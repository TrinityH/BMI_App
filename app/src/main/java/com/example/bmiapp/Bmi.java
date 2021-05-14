package com.example.bmiapp;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Bmi extends Activity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        TextView result = (TextView)findViewById(R.id.txtResult);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intPounds = sharedPref.getInt("key1", 0);
        int intInches = sharedPref.getInt("key2", 0);
        double bmi;
        bmi=(intPounds	* 703.0)/(intInches * intInches);
        DecimalFormat tenth = new DecimalFormat("#.#");
        result.setText("Your weight is: " + intPounds + " Making your Body Mass Index: " + tenth.format(bmi));

    }

}
