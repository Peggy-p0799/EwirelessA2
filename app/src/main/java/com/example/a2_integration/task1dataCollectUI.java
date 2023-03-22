package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class task1dataCollectUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1_ui);
    }

    //Click button to check real-time sensing data from Accelerator
    public void checkAcc(View view){
        Intent intentAccData = new Intent (this,task1_1acc.class);
        startActivity(intentAccData);
    }

    //Todo Add more data activities here
}
