package com.example.a2_integration;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

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
    private Sensor gravitySensor;
    private LocationManager locationManager;
    private LocationListener locationListener;
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
    TextView textGPS;

    //WIFI
    String wifis[];
    ListView lv;

    float accelerometerValues = 0;
    final float alpha = (float) 0.8;
    private float gravity [] = new float[3];

    double accPower,accRange,accResolution,accMinDelay;
    double magPower,magRange,magResolution,magMinDelay;
    double gyrPower,gyrRange,gyrResolution,gyrMinDelay;
    double barPower,barRange,barResolution,barMinDelay;
    double prxPower,prxRange,prxResolution,prxMinDelay;
    double lightPower,lightRange,lightResolution,lightMinDelay;
    double gravityPower,gravityRange,gravityResolution,gravityMinDelay;

    float[] magneticFieldValues = new float[3];
    float magnetometerValue;
    float[] gyroValues = new float[3];
    float[] gravityValues = new float[3];

    float gyroIntValue;
    float gravityValue;
    float barValue;
    float lightValue;
    float prxValue;
    int pointsPlotted = 5;
    int plotCode=99;
    boolean stopPlot=false;
    //Sensor timeStamp
    long accTimestamp,magTimestamp,gyrTimestamp,barTimestamp,prxTimestamp,lightTimestamp,gravityTimestamp;
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

    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_Location_PERMISSION = 100;

    private void askWIFInGPSPermissions(){
        if(android.os.Build.VERSION.SDK_INT >=23){
            //CHECK IF WE HAVE READ/WRITE PERMISSION
            int wifiAccessPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_WIFI_STATE);
            int wifiAChangePermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CHANGE_WIFI_STATE);
            int coarseLocationPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION);
            int fineLocationPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
            int internetPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.INTERNET);

            if(wifiAccessPermission != PackageManager.PERMISSION_GRANTED ||
                    wifiAChangePermission != PackageManager.PERMISSION_GRANTED ||
                    coarseLocationPermission != PackageManager.PERMISSION_GRANTED ||
                    fineLocationPermission != PackageManager.PERMISSION_GRANTED){
                //if dont have permission so prompt the user
                this.requestPermissions(
                        new String[]{
                                android.Manifest.permission.ACCESS_WIFI_STATE,
                                android.Manifest.permission.CHANGE_WIFI_STATE,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                android.Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_ID_READ_WRITE_PERMISSION

                );
                return;
            }

            if(coarseLocationPermission != PackageManager.PERMISSION_GRANTED ||
                    internetPermission != PackageManager.PERMISSION_GRANTED ||
                    fineLocationPermission != PackageManager.PERMISSION_GRANTED) {
                //If dont have permission so prompt the user.
                this.requestPermissions(
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.INTERNET
                        },
                        REQUEST_ID_Location_PERMISSION
                );
                return;
            }
        }
    }

    //when you have the request results
    @Override
    public void onRequestPermissionsResult( int requestCode,
                                            String permissions[], int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        switch (requestCode){

            case REQUEST_ID_READ_WRITE_PERMISSION:{
                if(grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        && grantResults[3] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(), "WIFI Permission granted!", Toast.LENGTH_LONG).show();
                }
                //Cancel or denied
                else{
                    Toast.makeText(getContext(), "WIFI Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }

            case REQUEST_ID_Location_PERMISSION:{
                //If request is cancelled, the result arrays are empty.
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(getContext(), "GPS Permission granted!",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getContext(), "GPS Permission denied!",Toast.LENGTH_LONG).show();
                }
                break;
            }

        }
    }

    BroadcastReceiver wifiScanReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context C, Intent intent) {
            List<ScanResult> wifiScanList = wifiManager.getScanResults();
            getContext().unregisterReceiver(this);
            wifis = new String[wifiScanList.size()];
            Log.e("WiFi", String.valueOf(wifiScanList.size()));
                for(int i = 0; i< wifiScanList.size();i++){
                wifis[i]=wifiScanList.get(i).SSID +
                        "," + wifiScanList.get(i).BSSID +
                        "," + String.valueOf(wifiScanList.get(i).level);
                Log.e("WiFi", String.valueOf(wifis[i]));
            }
           // lv.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,wifis));

        }
    };

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

        textGPS = (TextView) view.findViewById(R.id.tvGPS);

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

        //Collect data from desired sensors

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

        if (sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY){
            gravityValues = sensorEvent.values;
            gravityTimestamp = sensorEvent.timestamp;
            gravityValue =(float) Math.sqrt(gravityValues[0]*gravityValues[0]
                    +gravityValues[1]*gravityValues[1]
                    +gravityValues[2]*gravityValues[2]);//-----------sensor data required.

            // Start plotting and time framing if button is hit

            if(plotCode==6){
                if(timeRecord){
                    lastTimestamp=gravityTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,gravityValue,gravityTimestamp,"-Gravity");
            }
        }
    }

    // Constants for sampling
    private final int SENSOR_RATE = 100; // Hz
    private final int TARGET_RATE = 5; // Hz
    private final int SAMPLE_PERIOD_MS = 1000 / TARGET_RATE; // Milliseconds

    // Variables for sampling
    private float[] mSensorBuffer = new float[SENSOR_RATE / TARGET_RATE];
    private int mSensorBufferIndex = 0;

    private void plotSensor(boolean stop,float sensorValue, long timestamp,String sensorLegend){

        //Time frame
        double xValue = timestamp/1000000; //ms
        double currentTimestamp = xValue-lastTimestamp;
        int pointsPlotted=0;

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
                pointsPlotted++;
                accSeries.appendData(new DataPoint(currentTimestamp, average), true, 100);
                mLastXvalue=currentTimestamp;
                Graph.addSeries(accSeries);
            }

            //Reset buffer index
            mSensorBufferIndex = 0;
        }

        //debug line
        tvTimeStamp.setText("Timestamp:"+currentTimestamp);

        if(stop){
            Graph.removeAllSeries();
            legend.setText("N/A");
            currentTimestamp=0;
            //Zero buffer
            for (int i = 0; i < mSensorBuffer.length; i++) {
                mSensorBuffer[i] = 0;
            }

        }else{

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
        sensorManager.registerListener(this, barometer, 10000);
        sensorManager.registerListener(this, ambientLightSensor, 10000);
        sensorManager.registerListener(this, proximitySensor, 10000);
        sensorManager.registerListener(this,gravitySensor,10000);
        //Register the sensor when user returns to the activity
        getContext().registerReceiver(wifiScanReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        //wifiManager.startScan();
    }

    @Override
    public void onPause(){
        //Disable all sensors
        super.onPause();
        sensorManager.unregisterListener(this);
        getContext().unregisterReceiver(wifiScanReciever);
        // locationManager.removeUpdates(this);
        // wifiManager.stopScan();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        askWIFInGPSPermissions();
        initialisedManager();
        initSensorCardView();

    }

    public void initialisedManager(){

        //Location manager
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener(){
            public void onLocationChanged (@NonNull Location location){
                if(location != null){
                    double tlat = location.getLatitude();
                    double tlong = location.getLongitude();
                    textGPS.setText(Double.toString(tlat));
                }
            }
        };

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(getContext(), "Open GPS",Toast.LENGTH_LONG).show();
        }

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            askWIFInGPSPermissions();
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);

        //Wifi manager
        wifiManager = (WifiManager) getContext().getSystemService(Context.WIFI_SERVICE);
        if(wifiManager.getWifiState()==wifiManager.WIFI_STATE_DISABLED) {
            wifiManager.setWifiEnabled(true);
        }

        getContext().registerReceiver(wifiScanReciever, new IntentFilter(wifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();
        Toast.makeText(getContext(), "Scanning WIFI ...", Toast.LENGTH_SHORT).show();

        if(wifiManager.getWifiState()==wifiManager.WIFI_STATE_ENABLED) {
            wifiManager.getConnectionInfo().getSSID();
            wifiManager.getConnectionInfo().getBSSID();
            wifiManager.getConnectionInfo().getFrequency();
            wifiManager.getConnectionInfo().getRssi();
        }

        //-----------------------Sensor manager--------------------------//
        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        barometer = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        ambientLightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);


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

        if(gravitySensor != null){
            gravityPower = gravitySensor.getPower();
            gravityRange = gravitySensor.getMaximumRange();
            gravityResolution = gravitySensor.getResolution();
            gravityMinDelay= gravitySensor.getMinDelay();
        }

    }
    @SuppressLint("DefaultLocale")
    private void initSensorCardView(){
        Log.d(TAG,"Sensor information gathering.");

        int[] imageArray = {R.drawable.performance, R.drawable.magnet,
                R.drawable.gyroscope,R.drawable.barometer,
                R.drawable.lightbulb,R.drawable.radar,R.drawable.gravity};


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

        mImages.add(imageArray[6]);
        mSensorNames.add("Gravity");
        mSensorResolution.add(String.format("Resolution= %.4f cm", gravityResolution));
        mSensorMinDelay.add(String.format("minDelay=%.2f ms", gravityMinDelay));
        mSensorPower.add(String.format("Power=%.2f mA", gravityPower));
        mSensorRange.add(String.format("maxRange= %.2f cm", gravityRange));

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
