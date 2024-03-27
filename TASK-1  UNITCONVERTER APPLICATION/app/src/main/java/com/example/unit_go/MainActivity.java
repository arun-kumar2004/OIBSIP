package com.example.unit_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView lengthImageView, AreaImageView, VolumeImageView, WeightImageView, TemperatureImageView, SpeedImageView, TimeImageView, CurrencyImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthImageView = findViewById(R.id.lengthImageView);
        AreaImageView = findViewById(R.id.AreaImageView);
        VolumeImageView = findViewById(R.id.VolumeImageView);
        WeightImageView = findViewById(R.id.WeightImageView);
        TemperatureImageView = findViewById(R.id.TemperatureImageView);
        SpeedImageView =findViewById(R.id.SpeedImageView);
        TimeImageView =findViewById(R.id.TimeImageView);
        CurrencyImageView =findViewById(R.id.CurrencyImageView);

        lengthImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lengthActivity.class);
                startActivity(intent);
            }
        });

        AreaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, areaActivity.class);
                startActivity(intent);
            }
        });

        VolumeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, volumeActivity.class);
                startActivity(intent);
            }
        });

        WeightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, weightActivity.class);
                startActivity(intent);
            }
        });

        TemperatureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, temperatureActivity.class);
                startActivity(intent);
            }
        });

        SpeedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, speedActivity.class);
                startActivity(intent);
            }
        });

        TimeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, timeActivity.class);
                startActivity(intent);
            }
        });

        CurrencyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, currencyActivity.class);
                startActivity(intent);
            }
        });




    }
}