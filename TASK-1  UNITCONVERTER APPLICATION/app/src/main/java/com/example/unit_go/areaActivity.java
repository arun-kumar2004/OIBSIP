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

public class areaActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView km2, meter2, cm2, mm2, hectare, acre, milesquare, yardsquare, footsquare, inchsquare;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km2 = findViewById(R.id.km2);
        meter2 = findViewById(R.id.meter2);
        cm2 = findViewById(R.id.cm2);
        mm2 = findViewById(R.id.mm2);
        hectare = findViewById(R.id.hectare);
        acre = findViewById(R.id.acre);
        milesquare = findViewById(R.id.milesquare);
        yardsquare = findViewById(R.id.yardsquare);
        footsquare = findViewById(R.id.footsquare);
        inchsquare = findViewById(R.id.inchsquare);

        String[] arr = {"km2", "meter2", "cm2", "mm2", "ha", "ac", "mile2", "yd2", "ft2", "in2"};
        unit.setAdapter(new ArrayAdapter(areaActivity.this, android.R.layout.simple_list_item_1, arr));

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

    private void update() {

        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "km2":
                    setKm(in);
                    break;
                case "meter2":
                    setKm(in / 1000000);
                    break;
                case "cm2":
                    double c = 100000 * 100000;
                    setKm(in / c);
                    break;
                case "mm2":
                    double m = 1000000 * 1000000;
                    setKm(in / m);
                    break;
                case "ha":
                    setKm(in / 100);
                    break;
                case "ac":
                    setKm(in / 247.1);
                    break;
                case "mile2":
                    setKm(in * 2.59);
                    break;
                case "yd2":
                    setKm(in / 1195990.0463011);
                    break;
                case "ft2":
                    setKm(in / 10763910.4);
                    break;
                case "in2":
                    setKm(in / 1550003100.0062);
                    break;

            }
        }

    }

    private void setKm(double km_in) {
        km2.setText(String.valueOf(km_in));
        meter2.setText(String.valueOf(km_in*1000000));
        cm2.setText(String.valueOf(km_in*100000 * 100000));
        mm2.setText(String.valueOf(km_in*1000000 * 1000000));
        hectare.setText(String.valueOf(km_in*100));
        acre.setText(String.valueOf(km_in*247.1));
        milesquare.setText(String.valueOf(km_in/2.59));
        yardsquare.setText(String.valueOf(km_in*1195990.0463011));
        footsquare.setText(String.valueOf(km_in*10763910.4));
        inchsquare.setText(String.valueOf(km_in*1550003100.0062));

    }

}