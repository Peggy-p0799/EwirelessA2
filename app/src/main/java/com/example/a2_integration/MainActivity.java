package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Click button to start checking all sensor data
    public void sensorList(View view){
        Intent intentSensorList = new Intent (this,task1dataCollectUI.class);
        startActivity(intentSensorList);
    }

    // Click button to start PDR
    public void startPDR(View view){
        Intent intentPDR = new Intent (this,task2pdrUI.class);
        startActivity(intentPDR);
    }

    // Click button to start API data transfer
    public void dataTransfer(View view){
        Intent intentDataTransfer = new Intent (this,task3APIUI.class);
        startActivity(intentDataTransfer);
    }
}