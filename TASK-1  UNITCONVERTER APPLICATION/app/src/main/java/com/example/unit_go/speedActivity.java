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

public class speedActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView kmperhour, kmpersecond, meterpersecond, mileperhour, knot, lightspeed, footpersecond, inchpersecond;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        kmperhour = findViewById(R.id.kmperhour);
        kmpersecond = findViewById(R.id.kmpersecond);
        meterpersecond = findViewById(R.id.meterpersecond);
        mileperhour = findViewById(R.id.mileperhour);
        knot = findViewById(R.id.knot);
        lightspeed = findViewById(R.id.lightspeed);
        footpersecond = findViewById(R.id.footpersecond);
        inchpersecond = findViewById(R.id.inchpersecond);

        String[] arr = {"km/h", "km/s", "m/s", "mph", "kn", "c", "fps", "ips"};
        unit.setAdapter(new ArrayAdapter(speedActivity.this, android.R.layout.simple_list_item_1, arr));

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
                case "km/h":
                    setKm(in);
                    break;
                case "km/s":
                    setKm(in*3600);
                    break;
                case "m/s":
                    setKm(in*3.6);
                    break;
                case "mph":
                    setKm(in*1.609);
                    break;
                case "kn":
                    setKm(in*1.852);
                    break;
                case "c":
                    double d = 1079252848.80;
                    setKm(in*d);
                    break;
                case "fps":
                    setKm(in*1.097);
                    break;
                case "ips":
                    setKm(in/10.93613386);
                    break;

            }
        }


    }

    private void setKm(double km_in) {
        kmperhour.setText(String.valueOf(km_in));
        kmpersecond.setText(String.valueOf(km_in/3600));
        meterpersecond.setText(String.valueOf(km_in/3.6));
        mileperhour.setText(String.valueOf(km_in/1.609));
        knot.setText(String.valueOf(km_in/1.852));
        lightspeed.setText(String.valueOf(km_in/1079252848.80));
        footpersecond.setText(String.valueOf(km_in/1.097));
        inchpersecond.setText(String.valueOf(km_in*10.93613386));


    }


}