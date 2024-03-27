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

public class currencyActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView india, unitedstates, euro, japan, britain, china, iran, russia, swizterland, turkey;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        india = findViewById(R.id.india);
        unitedstates = findViewById(R.id.unitedstates);
        euro = findViewById(R.id.euro);
        japan = findViewById(R.id.japan);
        britain = findViewById(R.id.britain);
        china = findViewById(R.id.china);
        iran = findViewById(R.id.iran);
        russia = findViewById(R.id.russia);
        swizterland = findViewById(R.id.swizterland);
        turkey = findViewById(R.id.turkey);

        String[] arr = {"INR", "USD", "JPY", "GBP", "CNY", "IRR", "RUB", "CHF"};
        unit.setAdapter(new ArrayAdapter(currencyActivity.this, android.R.layout.simple_list_item_1, arr));

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
                case "INR":
                    setKm(in);
                    break;
                case "USD":
                    setKm(in/0.012);
                    break;
                case "EUR":
                    setKm(in/0.011);
                    break;
                case "JPY":
                    setKm(in*1.73);
                    break;
                case "GBP":
                    setKm(in/0.0107);
                    break;
                case "CNY":
                    setKm(in/0.088);
                    break;
                case "IRR":
                    setKm(in*515.30);
                    break;
                case "RUB":
                    setKm(in*1.10);
                    break;
                case "CHF":
                    setKm(in/0.011);
                    break;
                case "TRY":
                    setKm(in/0.33);
                    break;

            }
        }


    }

    private void setKm(double km_in) {
        india.setText(String.valueOf(km_in));
        unitedstates.setText(String.valueOf(km_in*0.012));
        euro.setText(String.valueOf(km_in*0.011));
        japan.setText(String.valueOf(km_in/1.73));
        britain.setText(String.valueOf(km_in*0.0107));
        china.setText(String.valueOf(km_in*0.088));
        iran.setText(String.valueOf(km_in/515.30));
        russia.setText(String.valueOf(km_in/1.10));
        swizterland.setText(String.valueOf(km_in*0.011));
        turkey.setText(String.valueOf(km_in*0.33));

    }

}