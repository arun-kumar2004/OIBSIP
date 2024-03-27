package com.example.unit_go;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class timeActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView hour, minute, second, millisecond, microsecond, picosecond, day, week, year;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        hour = findViewById(R.id.hour);
        minute = findViewById(R.id.minute);
        second = findViewById(R.id.second);
        millisecond = findViewById(R.id.millisecond);
        microsecond = findViewById(R.id.microsecond);
        picosecond = findViewById(R.id.picosecond);
        day = findViewById(R.id.day);
        week = findViewById(R.id.week);
        year = findViewById(R.id.year);

        String[] arr = {"hr", "min", "sec", "ms", "microsec", "picosec", "day", "week", "yr"};
        unit.setAdapter(new ArrayAdapter(timeActivity.this, android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });

    }

    private void update(){

        if(!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "hr":
                    setKm(in);
                    break;
                case "min":
                    setKm(in/60);
                    break;
                case "sec":
                    setKm(in/3600);
                    break;
                case "ms":
                    setKm(in/3600000);
                    break;
                case "microsec":
                    double mi = 36 * 100000000;
                    setKm(in/mi);
                    break;
                case "picosec":
                    double d = 3.6 * 100000 * 100000 * 100000;
                    setKm(in/d);
                    break;
                case "day":
                    setKm(in*24);
                    break;
                case "week":
                    setKm(in*168);
                    break;
                case "yr":
                    setKm(in*8760);
                    break;

            }
        }


    }

    private void setKm(double km_in) {
        hour.setText(String.valueOf(km_in));
        minute.setText(String.valueOf(km_in*60));
        second.setText(String.valueOf(km_in*3600));
        millisecond.setText(String.valueOf(km_in*3600000));
        microsecond.setText(String.valueOf(km_in*36*100000000));
        picosecond.setText(String.valueOf(km_in*3.6*100000*100000*100000));
        day.setText(String.valueOf(km_in/24));
        week.setText(String.valueOf(km_in/168));
        year.setText(String.valueOf(km_in/8760));

    }

}