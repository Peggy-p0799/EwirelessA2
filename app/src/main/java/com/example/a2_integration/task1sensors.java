package com.example.a2_integration;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
        sensorRecyclerViewAdaptor.OnButton1ClickListener, sensorRecyclerViewAdaptor.OnButton2ClickListener {

    private static final String TAG = "Task1Activity";

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;
    private Sensor magnetometer;
    private Sensor barometer;
    private Sensor ambientLightSensor;
    private Sensor proximitySensor;
    private Sensor gravitySensor;
    private Sensor linearAccelerationSensor;
    private Sensor rotationvector;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private WifiManager wifiManager;

    private final ArrayList<String> mSensorNames = new ArrayList<>();
    private final ArrayList<Integer> mImages = new ArrayList<>();
    private final ArrayList<String> mSensorResolution = new ArrayList<>();
    private final ArrayList<String> mSensorMinDelay = new ArrayList<>();
    private final ArrayList<String> mSensorPower = new ArrayList<>();
    private final ArrayList<String> mSensorRange = new ArrayList<>();
    private final ArrayList<String> mbtPlot = new ArrayList<>();
    private final ArrayList<String> mbtStop = new ArrayList<>();


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
    TextView xValues, yValue, zValue, AbsValue;
    TextView proximity, lightsensor, elevation;

    //WIFI
    String wifis[];
    ListView lv;

    String coord, coord2;

    float linearAccelerometerValues = 0;
    final float alpha = (float) 0.9;
    private float gravity[] = new float[3];

    double accPower, accRange, accResolution, accMinDelay;
    double magPower, magRange, magResolution, magMinDelay;
    double gyrPower, gyrRange, gyrResolution, gyrMinDelay;
    double barPower, barRange, barResolution, barMinDelay;
    double prxPower, prxRange, prxResolution, prxMinDelay;
    double lightPower, lightRange, lightResolution, lightMinDelay;
    double gravityPower, gravityRange, gravityResolution, gravityMinDelay;

    float[] magneticFieldValues = new float[3];
    float magnetometerValue;
    float[] gyroValues = new float[3];
    float gravityValues = 0;
    float[] rawAcceleration = new float[3];
    float[] rotationvectorValues = new float[4];
    float[] linearAcceleration = new float[3];

    float gyroIntValue;
    float barValue;
    float lightValue;
    float prxValue;
    int pointsPlotted = 5;
    int plotCode = 99;
    boolean stopPlot = true;
    //Sensor timeStamp
    long accTimestamp, magTimestamp, gyrTimestamp, barTimestamp, prxTimestamp, lightTimestamp, gravityTimestamp, linearAccelerationTimestamp, vecTimestamp;
    double lastTimestamp = 0;
    double mLastXvalue = 0;
    boolean timeRecord = false;
    boolean plotrunning = false;


    LineGraphSeries<DataPoint> accSeries = new LineGraphSeries<DataPoint>(new DataPoint[]{
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });
    LineGraphSeries<DataPoint> accSeriesx = new LineGraphSeries<DataPoint>(new DataPoint[]{
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });
    LineGraphSeries<DataPoint> accSeriesy = new LineGraphSeries<DataPoint>(new DataPoint[]{
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });
    LineGraphSeries<DataPoint> accSeriesz = new LineGraphSeries<DataPoint>(new DataPoint[]{
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });


    SensorsListener activitycommander;

    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_Location_PERMISSION = 100;

    private void askWIFInGPSPermissions() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            //CHECK IF WE HAVE READ/WRITE PERMISSION
            int wifiAccessPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_WIFI_STATE);
            int wifiAChangePermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CHANGE_WIFI_STATE);
            int coarseLocationPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION);
            int fineLocationPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
            int internetPermission = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.INTERNET);

            if (wifiAccessPermission != PackageManager.PERMISSION_GRANTED ||
                    wifiAChangePermission != PackageManager.PERMISSION_GRANTED ||
                    coarseLocationPermission != PackageManager.PERMISSION_GRANTED ||
                    fineLocationPermission != PackageManager.PERMISSION_GRANTED) {
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

            if (coarseLocationPermission != PackageManager.PERMISSION_GRANTED ||
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
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case REQUEST_ID_READ_WRITE_PERMISSION: {
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        && grantResults[3] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "WIFI Permission granted!", Toast.LENGTH_LONG).show();
                }
                //Cancel or denied
                else {
                    Toast.makeText(getContext(), "WIFI Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }

            case REQUEST_ID_Location_PERMISSION: {
                //If request is cancelled, the result arrays are empty.
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(getContext(), "GPS Permission granted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "GPS Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }

        }
    }

    private final ArrayList<Integer> mWifiRSSI = new ArrayList<>();
    private final ArrayList<String> mWifiMacAddress = new ArrayList<>();

    //Scan wifi every 2s
    private static final int WIFI_SCAN_INTERVAL_MS = 2000; // 2 seconds
    private final Handler mHandler = new Handler();
    private final Runnable mWifiScanRunnable = new Runnable() {
        @Override
        public void run() {
            scanForWifi();
            mHandler.postDelayed(this, WIFI_SCAN_INTERVAL_MS);
        }
    };

    private void startWifiScanning() {
        mHandler.post(mWifiScanRunnable);
    }

    private void stopWifiScanning() {
        mHandler.removeCallbacks(mWifiScanRunnable);
        mWifiRSSI.clear();
        mWifiMacAddress.clear();
    }

    TextView tvWifi1;
    TextView tvWifi2;

    private void scanForWifi() {
        wifiManager = (WifiManager) getContext().getSystemService(Context.WIFI_SERVICE);

        // Start a Wi-Fi scan
        wifiManager.startScan();

        // Get the list of available Wi-Fi networks
        List<ScanResult> scanResults = wifiManager.getScanResults();
        List<ScanResult> wifiScanList = wifiManager.getScanResults();
        WifiInfo wifiinfo = wifiManager.getConnectionInfo();
        String ssid = wifiinfo.getSSID();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        String[] split1 = wifiinfo.getMacAddress().split(":");
        StringBuilder builder1 = new StringBuilder();
        builder1.append(split1[0]);builder1.append(split1[1]);builder1.append(split1[2]);builder1.append(split1[3]);builder1.append(split1[4]);builder1.append(split1[5]);
        long mac = Long.parseLong(builder1.toString(), 16);

        long frequency = wifiinfo.getFrequency();
        activitycommander.AccessPointData(mac, ssid, frequency);


        wifis = new String[wifiScanList.size()];
        Log.e("WiFi", String.valueOf(wifiScanList.size()));
        for (int i = 0; i < wifiScanList.size(); i++) {
            mWifiRSSI.add(wifiScanList.get(i).level);
            mWifiMacAddress.add(wifiScanList.get(i).BSSID);

            String[] split2 = wifiinfo.getMacAddress().split(":");
            StringBuilder builder2 = new StringBuilder();
            builder2.append(split2[0]);builder2.append(split2[1]);builder2.append(split2[2]);builder2.append(split2[3]);builder2.append(split2[4]);builder2.append(split2[5]);

            activitycommander.wifiData(Long.parseLong(builder2.toString(), 16), wifiScanList.get(i).level, i, wifiScanList.size());

            Log.e("WiFi", String.valueOf(wifis[i]));
        }
        tvWifi2.setText(""+mac);

    }

    public interface SensorsListener {
        void LocationData(double tlat, double tlong, double altitude, double accuracy, double speed, String provider);
        void AccelerometerData(float[] accelerometer, long accTimestamp);
        void LinearAccelerationData(float[] linearacceleration, long accTimestamp);
        void GravityData(float[] gravity, long accTimestamp);
        void GyroscopeData(float[] gyroValues, long gyrTimestamp);
        void MagnetometerData(float[] magneticFieldValues, long magTimestamp);
        void PressureData(float barValue, long barTimestamp);
        void ProximityData(float prxValue, long prxTimestamp);
        void AmbientLightData(float lightValue, long lightTimestamp);
        void RotationVectorData(float[] rotationvectorValues, long vecTimestamp);

        void wifiData(long macaddress, int rssi, int i, int scanlistsize);
        void AccessPointData(long mac, String ssid, long frequency);

        // Sensor info
        void AccelerometerInfo(String name, String vendor, double resolution, double power, float version, float type);
        void GyroscopeInfo(String name, String vendor, double resolution, double power, float version, float type);
        void RotationVectorInfo(String name, String vendor, double resolution, double power, float version, float type);
        void MagnetometerInfo(String name, String vendor, double resolution, double power, float version, float type);
        void BarometerInfo(String name, String vendor, double resolution, double power, float version, float type);
        void LightSensorInfo(String name, String vendor, double resolution, double power, float version, float type);
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
        xValues = (TextView)view.findViewById(R.id.xValue);
        yValue = (TextView)view.findViewById(R.id.yValue);
        zValue = (TextView)view.findViewById(R.id.zValue);
        AbsValue = (TextView)view.findViewById(R.id.AbsValue);
        proximity = (TextView)view.findViewById(R.id.Proximity);
        lightsensor = (TextView)view.findViewById(R.id.LightSensor);
        elevation = (TextView)view.findViewById(R.id.Elevation);

        textGPS = (TextView) view.findViewById(R.id.tvGPS);
        tvWifi1 = (TextView)view.findViewById(R.id.tvWifiRRSI);
        tvWifi2 = (TextView)view.findViewById(R.id.tvWifiBSSID);
/*
        ImageView btMenu = view.findViewById(R.id.btMenu);
        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawerLayout = view.findViewById(R.id.my_drawer_layout);
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
*/
        // set the color of the x-axis
        Graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.BLACK);
        Graph.getGridLabelRenderer().setVerticalLabelsColor(Color.BLACK);
        accSeries.setColor(Color.parseColor("#98473e")); // red
        accSeriesx.setColor(Color.parseColor("#3a5541")); // green
        accSeriesy.setColor(Color.parseColor("#a37c40")); // yellow
        accSeriesz.setColor(Color.parseColor("#b49082")); // pink

        //accSeries.setDrawDataPoints(true);
        //accSeries.setDataPointsRadius(10);

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

            //Pass raw data to the cloud
            rawAcceleration[0] = sensorEvent.values[0];
            rawAcceleration[1] = sensorEvent.values[1];
            rawAcceleration[2] = sensorEvent.values[2];



            accTimestamp = sensorEvent.timestamp;
            activitycommander.AccelerometerData(rawAcceleration, accTimestamp);

        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {

            rotationvectorValues[0] = sensorEvent.values[0];
            rotationvectorValues[1] = sensorEvent.values[1];
            rotationvectorValues[2] = sensorEvent.values[2];
            rotationvectorValues[3] = sensorEvent.values[3];

            vecTimestamp = sensorEvent.timestamp;
            activitycommander.RotationVectorData(rotationvectorValues, vecTimestamp);
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY) {
            gravity = sensorEvent.values;
            gravityTimestamp = sensorEvent.timestamp;
            gravityValues = (float) Math.sqrt(gravity[0]*gravity[0]+gravity[1]*gravity[1]+gravity[2]*gravity[2]);
            activitycommander.GravityData(gravity, gravityTimestamp);

            if(plotCode==4 & stopPlot == false){
                if(timeRecord){
                    lastTimestamp=accTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot, gravityValues, gravity[0], gravity[1], gravity[2], accTimestamp, "Gravity");

            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            float alpha3Hz = 0.84f;
            linearAcceleration[0] = alpha3Hz * linearAcceleration[0] + (1 - alpha3Hz) * sensorEvent.values[0];
            linearAcceleration[1] = alpha3Hz * linearAcceleration[1] + (1 - alpha3Hz) * sensorEvent.values[1];
            linearAcceleration[2] = alpha3Hz * linearAcceleration[2] + (1 - alpha3Hz) * sensorEvent.values[2];
            linearAccelerationTimestamp = sensorEvent.timestamp;
            linearAccelerometerValues = (float) Math.sqrt(linearAcceleration[0]*linearAcceleration[0]+
                    linearAcceleration[1]*linearAcceleration[1]+
                    linearAcceleration[2]*linearAcceleration[2]);
            activitycommander.LinearAccelerationData(linearAcceleration, linearAccelerationTimestamp);

            // Start plotting and time framing if button is hit

            if(plotCode==0 & stopPlot == false){
                if(timeRecord){
                    lastTimestamp=linearAccelerationTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot, linearAccelerometerValues, linearAcceleration[0], linearAcceleration[1], linearAcceleration[2], accTimestamp, "Accelerometer");

            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magneticFieldValues = sensorEvent.values;
            magTimestamp = sensorEvent.timestamp;

            activitycommander.MagnetometerData(magneticFieldValues, magTimestamp);

            magnetometerValue = (float) Math.sqrt(magneticFieldValues[0]*magneticFieldValues[0]
                    +magneticFieldValues[1]*magneticFieldValues[1]
                    +magneticFieldValues[2]*magneticFieldValues[2]); //-----------sensor data required.

            // Start plotting and time framing if button is hit

            if(plotCode==1 & stopPlot == false){
                if(timeRecord){
                    lastTimestamp=magTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,magnetometerValue,magneticFieldValues[0],magneticFieldValues[1],magneticFieldValues[2],magTimestamp,"Magnetometer");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            gyroValues = sensorEvent.values;
            gyrTimestamp = sensorEvent.timestamp;

            activitycommander.GyroscopeData(gyroValues, gyrTimestamp);

            gyroIntValue =(float) Math.sqrt(gyroValues[0]*gyroValues[0]
                    +gyroValues[1]*gyroValues[1]
                    +gyroValues[2]*gyroValues[2]);//-----------sensor data required.

            // Start plotting and time framing if button is hit

            if(plotCode==2 & stopPlot == false){
                if(timeRecord){
                    lastTimestamp=gyrTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,gyroIntValue,gyroValues[0],gyroValues[1],gyroValues[2],gyrTimestamp,"Gyroscope");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PRESSURE){
            barValue = sensorEvent.values[0]; //-----------sensor data required.
            barTimestamp = sensorEvent.timestamp;

            activitycommander.PressureData(barValue, barTimestamp);

            // Start plotting and time framing if button is hit

            if(plotCode==3 & stopPlot == false){
                if(timeRecord){
                    lastTimestamp=barTimestamp/1000000;
                    timeRecord = false;
                }
                plotSensor(stopPlot,barValue,0,0,0,barTimestamp,"Barometer");
            }
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightValue = sensorEvent.values[0]; //-----------sensor data required.
            lightTimestamp = sensorEvent.timestamp;

            activitycommander.AmbientLightData(lightValue, lightTimestamp);

            double lightValue1 = (double)Math.round(lightValue * 10d) / 10d;
            lightsensor.setText(lightValue1 + " lx");

        }
            // Start plotting and time framing if button is hit

        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            prxValue = sensorEvent.values[0]; //-----------sensor data required.
            prxTimestamp = sensorEvent.timestamp;

            activitycommander.ProximityData(prxValue, prxTimestamp);

            if(prxValue > 0) {
                proximity.setText("Far");
            }
            else {
                proximity.setText("Close");
            }
        }

        if(plotCode==5 | plotCode==6){
            Toast.makeText(getContext(), "This Sensor Cannot Be Plotted",Toast.LENGTH_LONG).show();
            plotCode=7;
        }

    }

    // Constants for sampling
    private final int SENSOR_RATE = 100; // Hz
    private final int TARGET_RATE = 5; // Hz
    private final int SAMPLE_PERIOD_MS = 1000 / TARGET_RATE; // Milliseconds

    // Variables for sampling
    private float[] mSensorBuffer = new float[SENSOR_RATE / TARGET_RATE];
    private int mSensorBufferIndex = 0;

    private void plotSensor(boolean stop,float sensorValue, float xcoord, float ycoord, float zcoord, long timestamp,String sensorLegend){

        //Time frame
        double xValue = timestamp/1000000; //ms
        double currentTimestamp = xValue-lastTimestamp;

        //Graph plot
        legend.setText(sensorLegend);
        //Graph.setTitle(sensorLegend);
        View = Graph.getViewport();

        // Add data to buffer
        mSensorBuffer[mSensorBufferIndex] = sensorValue;
        mSensorBufferIndex++;

        if (mSensorBufferIndex == mSensorBuffer.length){
            // Calculate average of buffer
            float average = 0, averagex = 0, averagey = 0, averagez = 0;
            for (float value : mSensorBuffer) {
                average += value;
                averagex += xcoord;
                averagey += ycoord;
                averagez += zcoord;
            }
            average /= mSensorBuffer.length;
            averagex /= mSensorBuffer.length;
            averagey /= mSensorBuffer.length;
            averagez /= mSensorBuffer.length;


            if(currentTimestamp-mLastXvalue>=SAMPLE_PERIOD_MS){
                accSeries.appendData(new DataPoint(currentTimestamp, average), true, 100);
                accSeriesx.appendData(new DataPoint(currentTimestamp, averagex), true, 100);
                accSeriesy.appendData(new DataPoint(currentTimestamp, averagey), true, 100);
                accSeriesz.appendData(new DataPoint(currentTimestamp, averagez), true, 100);

                mLastXvalue=currentTimestamp;
                Graph.addSeries(accSeries);
                Graph.addSeries(accSeriesx);
                Graph.addSeries(accSeriesy);
                Graph.addSeries(accSeriesz);

                xValues.setText(Math.round(averagex * 10000d) / 10000d + "");
                yValue.setText(Math.round(averagey * 10000d) / 10000d + "");
                zValue.setText(Math.round(averagez * 10000d) / 10000d+ "");
                AbsValue.setText(Math.round(average * 10000d) / 10000d + "");
            }

            //Reset buffer index
            mSensorBufferIndex = 0;
        }

        //debug line
        tvTimeStamp.setText(currentTimestamp/1000 + " s");


        /*if(stop){
            legend.setText("GraphView");
            currentTimestamp=0;
            tvTimeStamp.setText(currentTimestamp/1000 + " s");
            accSeries.resetData(new DataPoint[0]);
            accSeriesx.resetData(new DataPoint[0]);
            accSeriesy.resetData(new DataPoint[0]);
            accSeriesz.resetData(new DataPoint[0]);
            Graph.removeAllSeries();

            xValues.setText("0.0");
            yValue.setText("0.0");
            zValue.setText("0.0");
            AbsValue.setText("0.0");


            //Zero buffer
            //for (int i = 0; i < mSensorBuffer.length; i++) {
            //    mSensorBuffer[i] = 0;
            //}
            //mSensorBufferIndex = 0;
            mLastXvalue = 0;

        } */

        if(currentTimestamp>30000) {
            currentTimestamp=0;
            tvTimeStamp.setText(currentTimestamp/1000 + " s");
            accSeries.resetData(new DataPoint[0]);
            accSeriesx.resetData(new DataPoint[0]);
            accSeriesy.resetData(new DataPoint[0]);
            accSeriesz.resetData(new DataPoint[0]);
            Graph.removeAllSeries();

            stopPlot = false;
            timeRecord = true;
            mLastXvalue = 0;
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
        sensorManager.registerListener(this, linearAccelerationSensor, 10000);
        sensorManager.registerListener(this, rotationvector, 10000);
        //Register the sensor when user returns to the activity
      //  getContext().registerReceiver(wifiScanReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        //wifiManager.startScan();
    }

    @Override
    public void onPause(){
        //Disable all sensors
        super.onPause();
        sensorManager.unregisterListener(this);
        stopWifiScanning();
       // getContext().unregisterReceiver(wifiScanReciever);
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
                    double Elevation = location.getAltitude();
                    double Accuracy = location.getAccuracy();
                    double Speed = location.getSpeed();
                    String Provider = location.getProvider();

                    activitycommander.LocationData(tlat, tlong, Elevation, Accuracy, Speed, Provider);

                    tlat = (double)Math.round(tlat * 100000d) / 100000d;
                    tlong = (double)Math.round(tlong * 100000d) / 100000d;
                    Elevation = (double)Math.round(Elevation * 1000d) / 1000d;
                    if (tlat >= 0) { coord = "N"; }
                    else { coord = "S"; tlat = -tlat; }
                    if (tlong >= 0) { coord2 = "E"; }
                    else { coord2 = "W"; tlong = -tlong; }

                    textGPS.setText(tlat + "°" + coord + ", " + tlong + "°" + coord2);
                    elevation.setText(Elevation + " m");
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

        startWifiScanning();
        /*
                wifiManager = (WifiManager) getContext().getSystemService(Context.WIFI_SERVICE);
        if(wifiManager.getWifiState()==wifiManager.WIFI_STATE_DISABLED) {
            wifiManager.setWifiEnabled(true);
        }

        getContext().registerReceiver(wifiScanReciever, new IntentFilter(wifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();
        //Toast.makeText(getContext(), "Scanning WIFI ...", Toast.LENGTH_SHORT).show();

                if(wifiManager.getWifiState()==wifiManager.WIFI_STATE_ENABLED) {
            wifiManager.getConnectionInfo().getSSID();
            wifiManager.getConnectionInfo().getBSSID();
            wifiManager.getConnectionInfo().getFrequency();
            wifiManager.getConnectionInfo().getRssi();
        }

         */

        //-----------------------Sensor manager--------------------------//
        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        barometer = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        ambientLightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        linearAccelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        rotationvector = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);


        if (accelerometer != null){
            accPower = accelerometer.getPower();
            accRange = accelerometer.getMaximumRange();
            accResolution = accelerometer.getResolution();
            accMinDelay= accelerometer.getMinDelay();

            activitycommander.AccelerometerInfo(accelerometer.getName(), accelerometer.getVendor(), accResolution, accPower, accelerometer.getVersion(), accelerometer.getType());
        }
        if(magnetometer != null){
            magPower = magnetometer.getPower();
            magRange = magnetometer.getMaximumRange();
            magResolution = magnetometer.getResolution();
            magMinDelay= magnetometer.getMinDelay();

            activitycommander.MagnetometerInfo(magnetometer.getName(), magnetometer.getVendor(), magResolution, magPower, magnetometer.getVersion(), magnetometer.getType());
        }
        if(gyroscope != null){
            gyrPower = gyroscope.getPower();
            gyrRange = gyroscope.getMaximumRange();
            gyrResolution = gyroscope.getResolution();
            gyrMinDelay= gyroscope.getMinDelay();

            activitycommander.GyroscopeInfo(gyroscope.getName(), gyroscope.getVendor(), gyrResolution, gyrPower, gyroscope.getVersion(), gyroscope.getType());
        }
        if(barometer != null){
            barPower = barometer.getPower();
            barRange = barometer.getMaximumRange();
            barResolution = barometer.getResolution();
            barMinDelay= barometer.getMinDelay();

            activitycommander.BarometerInfo(barometer.getName(), barometer.getVendor(), barResolution, barPower, barometer.getVersion(), barometer.getType());
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

            activitycommander.LightSensorInfo(ambientLightSensor.getName(), ambientLightSensor.getVendor(), lightResolution, lightPower, ambientLightSensor.getVersion(), ambientLightSensor.getType());
        }

        if(gravitySensor != null){
            gravityPower = gravitySensor.getPower();
            gravityRange = gravitySensor.getMaximumRange();
            gravityResolution = gravitySensor.getResolution();
            gravityMinDelay= gravitySensor.getMinDelay();
        }

        if(rotationvector != null){

            activitycommander.RotationVectorInfo(rotationvector.getName(), rotationvector.getVendor(), rotationvector.getResolution(), rotationvector.getPower(), rotationvector.getVersion(), rotationvector.getType());
        }

    }
    @SuppressLint("DefaultLocale")
    private void initSensorCardView(){
        Log.d(TAG,"Sensor information gathering.");

        int[] imageArray = {R.drawable.icons8_dashboard_100, R.drawable.icons8_magnetic_90,
                R.drawable.icons8_gyroscope_100,R.drawable.icons8_barometer_64,R.drawable.icons8_gravity_66,
                R.drawable.icons8_light_bulb_64,R.drawable.icons8_proximity_sensor_100};


        mImages.add(imageArray[0]);
        mSensorNames.add("Accelerometer");
        mSensorResolution.add(String.format("Resolution: %.4f m/s²", accResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", accMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", accPower));
        mSensorRange.add(String.format("Max Range: %.2f m/s²", accRange));

        mImages.add(imageArray[1]);
        mSensorNames.add("Magnetometer");
        mSensorResolution.add(String.format("Resolution: %.4f µT", magResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", magMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", magPower));
        mSensorRange.add(String.format("Max Range: %.2f µT", magRange));

        mImages.add(imageArray[2]);
        mSensorNames.add("Gyroscope");
        mSensorResolution.add(String.format("Resolution: %.4f rad/s", gyrResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", gyrMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", gyrPower));
        mSensorRange.add(String.format("Max Range: %.2f rad/s", gyrRange));

        mImages.add(imageArray[3]);
        mSensorNames.add("Barometer");
        mSensorResolution.add(String.format("Resolution: %.4f hPa", barResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", barMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", barPower));
        mSensorRange.add(String.format("Max Range: %.2f hPa", barRange));

        mImages.add(imageArray[4]);
        mSensorNames.add("Gravity");
        mSensorResolution.add(String.format("Resolution: %.4f cm", gravityResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", gravityMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", gravityPower));
        mSensorRange.add(String.format("Max Range: %.2f cm", gravityRange));

        mImages.add(imageArray[5]);
        mSensorNames.add("Ambient Light Sensor");
        mSensorResolution.add(String.format("Resolution: %.4f lx", lightResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", lightMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", lightPower));
        mSensorRange.add(String.format("Max Range: %.2f lx", lightRange));

        mImages.add(imageArray[6]);
        mSensorNames.add("Proximity");
        mSensorResolution.add(String.format("Resolution: %.4f cm", prxResolution));
        mSensorMinDelay.add(String.format("Min Delay: %.2f ms", prxMinDelay));
        mSensorPower.add(String.format("Power: %.2f mA", prxPower));
        mSensorRange.add(String.format("Max Range: %.2f cm", prxRange));



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

        Graph.removeAllSeries();
        accSeries.resetData(new DataPoint[0]);
        accSeriesx.resetData(new DataPoint[0]);
        accSeriesy.resetData(new DataPoint[0]);
        accSeriesz.resetData(new DataPoint[0]);
        xValues.setText("0.0");
        yValue.setText("0.0");
        zValue.setText("0.0");
        AbsValue.setText("0.0");
        //Zero buffer
        for (int i = 0; i < mSensorBuffer.length; i++) {
            mSensorBuffer[i] = 0;
        }
        mLastXvalue = 0;
    }

    @Override
    public void onButton2Click(int position) {
        //plotCode = 99;
        stopPlot = true;
        Log.d(TAG, "onButton2Click: Stop Plot clicked!");
        legend.setText("GraphView");
        //currentTimestamp=0;
        //tvTimeStamp.setText(currentTimestamp/1000 + " s");
        accSeries.resetData(new DataPoint[0]);
        accSeriesx.resetData(new DataPoint[0]);
        accSeriesy.resetData(new DataPoint[0]);
        accSeriesz.resetData(new DataPoint[0]);
        Graph.removeAllSeries();

        xValues.setText("0.0");
        yValue.setText("0.0");
        zValue.setText("0.0");
        AbsValue.setText("0.0");

        tvTimeStamp.setText("0.0 s");

        //Zero buffer
        //for (int i = 0; i < mSensorBuffer.length; i++) {
        //    mSensorBuffer[i] = 0;
        //}
        //mSensorBufferIndex = 0;
        mLastXvalue = 0;
    }

}
