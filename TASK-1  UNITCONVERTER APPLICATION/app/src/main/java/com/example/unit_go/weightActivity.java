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

public class weightActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView kg, gram, milligram, tonne, quintal, pound, ounce, carat, grain, microgram;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        kg = findViewById(R.id.kg);
        gram = findViewById(R.id.gram);
        milligram = findViewById(R.id.milligram);
        tonne = findViewById(R.id.tonne);
        quintal = findViewById(R.id.quintal);
        pound = findViewById(R.id.pound);
        ounce = findViewById(R.id.ounce);
        carat = findViewById(R.id.carat);
        grain = findViewById(R.id.grain);
        microgram = findViewById(R.id.microgram);

        String[] arr = {"kg", "g", "mg", "t", "q", "lb", "oz", "ct", "gr", "micg"};
        unit.setAdapter(new ArrayAdapter(weightActivity.this, android.R.layout.simple_list_item_1, arr));

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
                case "kg":
                    setKm(in);
                    break;
                case "g":
                    setKm(in/1000);
                    break;
                case "mg":
                    setKm(in/1000000);
                    break;
                case "t":
                    setKm(in*1000);
                    break;
                case "q":
                    setKm(in*100);
                    break;
                case "lb":
                    setKm(in/2.205);
                    break;
                case "oz":
                    setKm(in/35.274);
                    break;
                case "ct":
                    setKm(in/5000);
                    break;
                case "gr":
                    setKm(in/15430);
                    break;
                case "micg":
                    setKm(in/1000000000);
                    break;

            }
        }


    }

    private void setKm(double km_in) {
        kg.setText(String.valueOf(km_in));
        gram.setText(String.valueOf(km_in*1000));
        milligram.setText(String.valueOf(km_in*1000000));
        tonne.setText(String.valueOf(km_in/1000));
        quintal.setText(String.valueOf(km_in/100));
        pound.setText(String.valueOf(km_in*2.205));
        ounce.setText(String.valueOf(km_in*35.274));
        carat.setText(String.valueOf(km_in*5000));
        grain.setText(String.valueOf(km_in*15430));
        microgram.setText(String.valueOf(km_in*1000000000));

    }

}