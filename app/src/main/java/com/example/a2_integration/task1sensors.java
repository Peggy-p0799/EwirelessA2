package com.example.a2_integration;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class task1sensors extends Fragment implements SensorEventListener,
        sensorRecyclerViewAdaptor.OnButton1ClickListener,sensorRecyclerViewAdaptor.OnButton2ClickListener {

    private static final String TAG = "Task1Activity";

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;
    private Sensor magnetometer;
    private Sensor barometer;
    private Sensor ambientLightSensor;
    private Sensor proximitySensor;
    private LocationManager locationManager;
    private WifiManager wifiManager;



    private final ArrayList<String> mSensorNames = new ArrayList<>();
    private final ArrayList<Integer> mImages = new ArrayList<>();
    private final ArrayList<String> mSensorResolution = new ArrayList<>();
    private final ArrayList<String> mSensorMinDelay = new ArrayList<>();
    private final ArrayList<String> mSensorPower = new ArrayList<>();
    private final ArrayList<String> mSensorRange = new ArrayList<>();

    /************************** Class definition ***************************/

    //GraphView and ViewPort
    GraphView Graph;
    Viewport View;
    TextView legend;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;

    //debug:
    TextView tvTimeStamp;



    float accelerometerValues = 0;
    final float alpha = (float) 0.8;
    private float gravity [] = new float[3];

    double accPower,accRange,accResolution,accMinDelay;
    double magPower,magRange,magResolution,magMinDelay;
    double gyrPower,gyrRange,gyrResolution,gyrMinDelay;
    double barPower,barRange,barResolution,barMinDelay;
    double prxPower,prxRange,prxResolution,prxMinDelay;
    double lightPower,lightRange,lightResolution,lightMinDelay;

    float[] magneticFieldValues = new float[3];
    float magnetometerValue;
    float[] gyroValues = new float[3];
    float gyroIntValue;

    float barValue;
    float lightValue;
    float prxValue;
    int pointsPlotted = 5;
    int plotCode=99;
    boolean stopPlot=false;
    //Sensor timeStamp
    long accTimestamp,magTimestamp,gyrTimestamp,barTimestamp,prxTimestamp,lightTimestamp;
    double lastTimestamp=0;
    double mLastXvalue=0;
    boolean timeRecord=false;


    LineGraphSeries<DataPoint> accSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });

    SensorsListener activitycommander;

    public interface SensorsListener {
        void SensorData(float sensor);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activitycommander = (SensorsListener) activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task1sensors, container, false);
        // Defining
        Graph = (GraphView) view.findViewById(R.id.accGraph);
        legend = (TextView) view.findViewById(R.id.tvLegend);
        recyclerView = view.findViewById(R.id.sensorRecyclerView);
        tvTimeStamp = (TextView)view.findViewById(R.id.tvtimestamp);

        // set the color of the x-axis
        Graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
        Graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        accSeries.setColor(Color.parseColor("#FF6200EE"));

        if(recyclerView!=null){
            layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(layoutManager);
            sensorRecyclerViewAdaptor adapter = new sensorRecyclerViewAdaptor(getContext(), mImages,mSensorNames,
                    mSensorResolution,mSensorMinDelay,mSensorPower,mSensorRange,this,this);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

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
            accTimestamp = sensorEvent.timestamp;

            accelerometerValues = (float) Math.sqrt(x*x+y*y+z*z);//-----------sensor data required.

            // Start plotting and time framing if button is hit

            if(plotCode==0){
                if(timeRecord){
                    lastTimestamp=accTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,accelerometerValues, accTimestamp,"-Accelerometer");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magneticFieldValues = sensorEvent.values;
            magTimestamp = sensorEvent.timestamp;
            magnetometerValue = (float) Math.sqrt(magneticFieldValues[0]*magneticFieldValues[0]
                    +magneticFieldValues[1]*magneticFieldValues[1]
                    +magneticFieldValues[2]*magneticFieldValues[2]); //-----------sensor data required.

            // Start plotting and time framing if button is hit

            if(plotCode==1){
                if(timeRecord){
                    lastTimestamp=magTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,magnetometerValue,magTimestamp,"-Magnetometer");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            gyroValues = sensorEvent.values;
            gyrTimestamp = sensorEvent.timestamp;
            gyroIntValue =(float) Math.sqrt(gyroValues[0]*gyroValues[0]
                    +gyroValues[1]*gyroValues[1]
                    +gyroValues[2]*gyroValues[2]);//-----------sensor data required.

            // Start plotting and time framing if button is hit

            if(plotCode==2){
                if(timeRecord){
                    lastTimestamp=gyrTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,gyroIntValue,gyrTimestamp,"-Gyroscope");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PRESSURE){
            barValue = sensorEvent.values[0]; //-----------sensor data required.
            barTimestamp = sensorEvent.timestamp;

            // Start plotting and time framing if button is hit

            if(plotCode==3){
                if(timeRecord){
                    lastTimestamp=barTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,barValue,barTimestamp,"-Barometer");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
            lightValue = sensorEvent.values[0]; //-----------sensor data required.
            lightTimestamp = sensorEvent.timestamp;

            // Start plotting and time framing if button is hit

            if(plotCode==4){
                if(timeRecord){
                    lastTimestamp=lightTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,lightValue,lightTimestamp,"-Light sensor");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY){
            prxValue = sensorEvent.values[0]; //-----------sensor data required.
            prxTimestamp = sensorEvent.timestamp;

            // Start plotting and time framing if button is hit

            if(plotCode==5){
                if(timeRecord){
                    lastTimestamp=prxTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,prxValue,prxTimestamp,"-Proximity");
            }
        }
    }

    // Constants for sampling
    private final int SENSOR_RATE = 100; // Hz
    private final int TARGET_RATE = 20; // Hz
    private final int SAMPLE_PERIOD_MS = 1000 / TARGET_RATE; // Milliseconds

    // Variables for sampling
    private float[] mSensorBuffer = new float[SENSOR_RATE / TARGET_RATE];
    private int mSensorBufferIndex = 0;

    private void plotSensor(boolean stop,float sensorValue, long timestamp,String sensorLegend){

        //Time frame
        double xValue = timestamp/1000000; //ms
        double currentTimestamp = xValue-lastTimestamp;

        //Graph plot
        legend.setText(sensorLegend);
        View = Graph.getViewport();

        // Add data to buffer
        mSensorBuffer[mSensorBufferIndex++] = sensorValue;
        if (mSensorBufferIndex == mSensorBuffer.length){
            // Calculate average of buffer
            float average = 0;
            for (float value : mSensorBuffer) {
                average += value;
            }
            average /= mSensorBuffer.length;
            if(currentTimestamp-mLastXvalue>=SAMPLE_PERIOD_MS){
                accSeries.appendData(new DataPoint(currentTimestamp, average), true, 100);
                mLastXvalue=currentTimestamp;
            }

            //Reset buffer index
            mSensorBufferIndex = 0;
        }

        tvTimeStamp.setText("Timestamp:"+currentTimestamp);


        if(stop){
            Graph.removeAllSeries();
            legend.setText("N/A");
            currentTimestamp=0;
        }else{
            Graph.addSeries(accSeries);
        }

        View.setMaxX(currentTimestamp);
        View.setMinX(currentTimestamp-2000);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i){

    }

    @Override
    public void onResume(){
        super. onResume();
        //sensorManager.registerListener(this, accelerometer, 60000); // 10000-100 samples/sec; 60000 - 20 samples/sec
        sensorManager.registerListener(this, accelerometer, 10000);
        sensorManager.registerListener(this, gyroscope, 10000);
        sensorManager.registerListener(this, magnetometer, 10000);
        sensorManager.registerListener(this, barometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, ambientLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        //Register the sensor when user returns to the activity
        // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        //wifiManager.startScan();
    }

    @Override
    public void onPause(){
        //Disable all sensors
        super.onPause();
        sensorManager.unregisterListener(this);
        // locationManager.removeUpdates(this);
        // wifiManager.stopScan();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_task1sensors);



        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        barometer = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        ambientLightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        // locationManager = (LocationManager).getSystemService(Context.LOCATION_SERVICE);
        // wifiManager = (WifiManager) .getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (accelerometer != null){

            accPower = accelerometer.getPower();
            accRange = accelerometer.getMaximumRange();
            accResolution = accelerometer.getResolution();
            accMinDelay= accelerometer.getMinDelay();
        }
        if(magnetometer != null){
            magPower = magnetometer.getPower();
            magRange = magnetometer.getMaximumRange();
            magResolution = magnetometer.getResolution();
            magMinDelay= magnetometer.getMinDelay();
        }
        if(gyroscope != null){
            gyrPower = gyroscope.getPower();
            gyrRange = gyroscope.getMaximumRange();
            gyrResolution = gyroscope.getResolution();
            gyrMinDelay= gyroscope.getMinDelay();
        }
        if(barometer != null){
            barPower = barometer.getPower();
            barRange = barometer.getMaximumRange();
            barResolution = barometer.getResolution();
            barMinDelay= barometer.getMinDelay();
        }
        if(proximitySensor != null){
            prxPower = proximitySensor.getPower();
            prxRange = proximitySensor.getMaximumRange();
            prxResolution = proximitySensor.getResolution();
            prxMinDelay= proximitySensor.getMinDelay();
        }
        if(ambientLightSensor != null){
            lightPower = ambientLightSensor.getPower();
            lightRange = ambientLightSensor.getMaximumRange();
            lightResolution = ambientLightSensor.getResolution();
            lightMinDelay= ambientLightSensor.getMinDelay();
        }

        initSensorCardView();

    }
    @SuppressLint("DefaultLocale")
    private void initSensorCardView(){
        Log.d(TAG,"Sensor information gathering.");

        int[] imageArray = {R.drawable.performance, R.drawable.magnet,
                R.drawable.gyroscope,R.drawable.barometer,
                R.drawable.lightbulb,R.drawable.radar};


        mImages.add(imageArray[0]);
        mSensorNames.add("Accelerator");

        mSensorResolution.add(String.format("Resolution= %.4f m/s^2", accResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", accMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", accPower));
        mSensorRange.add(String.format("maxRange= %.2f m/s^2", accRange));

        mImages.add(imageArray[1]);
        mSensorNames.add("Magnetometer");
        mSensorResolution.add(String.format("Resolution= %.4f µT", magResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", magMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", magPower));
        mSensorRange.add(String.format("maxRange= %.2f µT", magRange));

        mImages.add(imageArray[2]);
        mSensorNames.add("Gyroscope");
        mSensorResolution.add(String.format("Resolution= %.4f rad/s", gyrResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", gyrMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", gyrPower));
        mSensorRange.add(String.format("maxRange= %.2f rad/s", gyrRange));

        mImages.add(imageArray[3]);
        mSensorNames.add("Barometer");
        mSensorResolution.add(String.format("Resolution= %.4f hPa", barResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", barMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", barPower));
        mSensorRange.add(String.format("maxRange= %.2f hPa", barRange));

        mImages.add(imageArray[4]);
        mSensorNames.add("Ambient Light Sensor");
        mSensorResolution.add(String.format("Resolution= %.4f lx", lightResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", lightMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", lightPower));
        mSensorRange.add(String.format("maxRange= %.2f lx", lightRange));

        mImages.add(imageArray[5]);
        mSensorNames.add("Proximity");
        mSensorResolution.add(String.format("Resolution= %.4f cm", prxResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", prxMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", prxPower));
        mSensorRange.add(String.format("maxRange= %.2f cm", prxRange));

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
    }


    @Override
    public void onButton1Click(int position) {
        Log.d(TAG, "Item clicked at position: " + position);
        plotCode = position;
        stopPlot = false;
        timeRecord = true;
        Log.d(TAG, "onButton1Click: Start Plot Clicked!");
    }

    @Override
    public void onButton2Click(int position) {
        stopPlot = true;
        Log.d(TAG, "onButton2Click: Stop Plot clicked!");
    }
}
