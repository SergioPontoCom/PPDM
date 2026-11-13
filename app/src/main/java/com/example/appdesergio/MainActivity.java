package com.example.appdesergio;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float v = sensorEvent.values[0];
        texto.setText(Float.toString(v));
    }
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //classe Sensor do java , classe abstrai um sensor especifico pode conter diversas propriedades
        Sensor sensor;
        //SensorEvent sensorEvent;

        //SensorEventListener ouvinteDoSensor;

        SensorManager sm =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST);

        texto = findViewById(R.id.TVSensor);
        texto.setText(sm.toString());



    }





}