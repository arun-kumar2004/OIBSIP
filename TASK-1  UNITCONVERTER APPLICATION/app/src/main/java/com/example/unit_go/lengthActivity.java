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

public class lengthActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView km, meter, cm, mm, micromet, nanom, mile, yard, foot, inch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km = findViewById(R.id.km);
        meter = findViewById(R.id.meter);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        micromet = findViewById(R.id.micromet);
        nanom = findViewById(R.id.nanom);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        String[] arr = {"km", "meter", "cm", "mm", "micromet", "nanom", "mile", "yard", "foot", "inch"};
        unit.setAdapter(new ArrayAdapter(lengthActivity.this, android.R.layout.simple_list_item_1, arr));

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
                case "km":
                    setKm(in);
                    break;
                case "meter":
                    setKm(in/1000);
                    break;
                case "cm":
                    setKm(in/100000);
                    break;
                case "mm":
                    setKm(in/1000000);
                    break;
                case "micromet":
                    setKm(in/1000000000);
                    break;
                case "nanom":
                    double d = 1000000 * 1000000;
                    setKm(in/d);
                    break;
                case "mile":
                    setKm(in*1.609);
                    break;
                case "yard":
                    setKm(in/1094);
                    break;
                case "foot":
                    setKm(in/3281);
                    break;
                case "inch":
                    setKm(in/39370);
                    break;

            }
        }

    }

    private void setKm(double km_in) {
        km.setText(String.valueOf(km_in));
        meter.setText(String.valueOf(km_in*1000));
        cm.setText(String.valueOf(km_in*100000));
        mm.setText(String.valueOf(km_in*1000000));
        micromet.setText(String.valueOf(km_in*1000000000));
        nanom.setText(String.valueOf(km_in*1000000 * 1000000));
        mile.setText(String.valueOf(km_in/1.609));
        yard.setText(String.valueOf(km_in*1094));
        foot.setText(String.valueOf(km_in*3281));
        inch.setText(String.valueOf(km_in*39370));

    }

}