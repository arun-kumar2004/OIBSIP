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

public class volumeActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView liter, cubicmeter, cubiccentimeter, cubicmillimeter, hectoliter, centiliter, milliliter, yardcubic, footcubic, inchcubic;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        liter = findViewById(R.id.liter);
        cubicmeter = findViewById(R.id.cubicmeter);
        cubiccentimeter = findViewById(R.id.cubiccentimeter);
        cubicmillimeter = findViewById(R.id.cubicmillimeter);
        hectoliter = findViewById(R.id.hectoliter);
        centiliter = findViewById(R.id.centiliter);
        milliliter = findViewById(R.id.milliliter);
        yardcubic = findViewById(R.id.yardcubic);
        footcubic = findViewById(R.id.footcubic);
        inchcubic = findViewById(R.id.inchcubic);

        String[] arr = {"L", "m3", "cm3", "mm3", "hl", "cl", "ml", "yd3", "ft3", "in3"};
        unit.setAdapter(new ArrayAdapter(volumeActivity.this, android.R.layout.simple_list_item_1, arr));

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
                case "L":
                    setKm(in);
                    break;
                case "m3":
                    setKm(in*1000);
                    break;
                case "cm3":
                    setKm(in/1000);
                    break;
                case "mm3":
                    setKm(in/1000000);
                    break;
                case "hl":
                    setKm(in*100);
                    break;
                case "cl":
                    setKm(in/100);
                    break;
                case "ml":
                    setKm(in/1000);
                    break;
                case "yd3":
                    setKm(in*764.6);
                    break;
                case "ft3":
                    setKm(in*28.317);
                    break;
                case "in3":
                    setKm(in/61.024);
                    break;

            }
        }

    }

    private void setKm(double km_in) {
        liter.setText(String.valueOf(km_in));
        cubicmeter.setText(String.valueOf(km_in/1000));
        cubiccentimeter.setText(String.valueOf(km_in*1000));
        cubicmillimeter.setText(String.valueOf(km_in*1000000));
        hectoliter.setText(String.valueOf(km_in/100));
        centiliter.setText(String.valueOf(km_in*100));
        milliliter.setText(String.valueOf(km_in*1000));
        yardcubic.setText(String.valueOf(km_in/764.6));
        footcubic.setText(String.valueOf(km_in/28.317));
        inchcubic.setText(String.valueOf(km_in*61.024));

    }

}