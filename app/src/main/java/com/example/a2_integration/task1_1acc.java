package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class task1_1acc extends AppCompatActivity implements SensorEventListener {

    /************************** Class definition ***************************/
    //TextView
    TextView tvAccValue;
    TextView tvAccPower;
    TextView tvAccRange;

    //GraphView and ViewPort
    GraphView accGraph;
    Viewport accView;

    //Get access to sensors
    private SensorManager mSensorManager;

    //Represent sensors
    private Sensor aSensor; // accelerator

    //Variables

    double accelerometerValues = 0;
    final float alpha = (float) 0.8;
    private float gravity [] = new float[3];

    double accPower;
    double accRange;

    int pointsPlotted = 5;

    LineGraphSeries<DataPoint> accSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){

            // Add a high pass filter (Alpha contributed) to get the real acceleration.

            gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
            gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
            gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];

            float x, y, z;

            x = sensorEvent.values[0]- gravity[0];
            y = sensorEvent.values[1] - gravity[1];
            z = sensorEvent.values[2] - gravity[2];

            accelerometerValues = Math.sqrt(x*x+y*y+z*z);

            plotAccelerator();
        }
    }

    private void plotAccelerator(){

        //Display power state
        accPower = aSensor.getPower();
        tvAccPower=(TextView)findViewById(R.id.tvAccPower);
        tvAccPower.setText(String.format("Power State: %.2f mA", accPower));

        //Display Maximum range of acc
        accRange = aSensor.getMaximumRange();
        tvAccRange=(TextView)findViewById(R.id.tvAccRange);
        tvAccRange.setText(String.format("Maximum Range: %.2f m/s^2", accRange));
        //Text display
        tvAccValue = (TextView) findViewById(R.id.txAccReading);
        tvAccValue.setText(String.format("%.2f m/s^2", accelerometerValues));


        //Graph plot
        accGraph = (GraphView) findViewById(R.id.accGraph);
        accView = accGraph.getViewport();
        pointsPlotted++;

        if(pointsPlotted>800){
            pointsPlotted = 1;
            accSeries.resetData(new DataPoint[] {new DataPoint(1,0)});
        }

        accSeries.appendData(new DataPoint(pointsPlotted, accelerometerValues), true, pointsPlotted);
        accGraph.addSeries(accSeries);

        accView.setMaxX(pointsPlotted);
        accView.setMinX(pointsPlotted-100);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i){

    }

    @Override
    protected void onResume(){
        super. onResume();
        mSensorManager.registerListener(this, aSensor, 10000); // 100 samples/sec
        //Register the sensor when user returns to the activity
    }

    @Override
    protected void onPause(){
        //Disable all sensors
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task11acc);

        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        aSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }
}