package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class task3api extends Fragment {

    // Declaration of Data Packet Variables
    Traj.Trajectory.Builder trajectory = Traj.Trajectory.newBuilder(); // Total Data Packet
    Traj.Pdr_Sample.Builder pdrsample = Traj.Pdr_Sample.newBuilder();
    Traj.Motion_Sample.Builder motionsample = Traj.Motion_Sample.newBuilder();
    Traj.Position_Sample.Builder positionsample = Traj.Position_Sample.newBuilder();
    Traj.Pressure_Sample.Builder pressuresample = Traj.Pressure_Sample.newBuilder();
    Traj.Light_Sample.Builder lightsample = Traj.Light_Sample.newBuilder();
    Traj.GNSS_Sample.Builder gnsssample = Traj.GNSS_Sample.newBuilder();
    Traj.WiFi_Sample.Builder wifisample = Traj.WiFi_Sample.newBuilder();
    Traj.Mac_Scan.Builder macscan = Traj.Mac_Scan.newBuilder();
    Traj.AP_Data.Builder apdata = Traj.AP_Data.newBuilder();
    // Defining sensor info
    Traj.Sensor_Info.Builder accelerometerinfo = Traj.Sensor_Info.newBuilder();
    Traj.Sensor_Info.Builder gyroscopeinfo = Traj.Sensor_Info.newBuilder();
    Traj.Sensor_Info.Builder rotationvectorinfo = Traj.Sensor_Info.newBuilder();
    Traj.Sensor_Info.Builder magnetometerinfo = Traj.Sensor_Info.newBuilder();
    Traj.Sensor_Info.Builder barometerinfo = Traj.Sensor_Info.newBuilder();
    Traj.Sensor_Info.Builder lightsensorinfo = Traj.Sensor_Info.newBuilder();


    ToggleButton GlobalpdrToggleButton;
    long Globalstarttime = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    RecyclerView trajectoryList;
    swipeAdaptor trajectorySwipeAdaptor;

    private ArrayList<String> myTrajectoryNum = new ArrayList<>();
    private ArrayList<String> myTrajectoryLocation = new ArrayList<>();
    private ArrayList<String> myTrajectoryTimestamp = new ArrayList<>()
            ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task3api, container, false);

        trajectoryList = view.findViewById(R.id.trajectoryRecycler);
        createList();

        if(trajectoryList!= null){
            trajectoryList.setLayoutManager(new LinearLayoutManager(getContext()));
            trajectoryList.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
            trajectorySwipeAdaptor = new swipeAdaptor(getContext(),myTrajectoryNum,myTrajectoryLocation,myTrajectoryTimestamp);
            trajectoryList.setAdapter(trajectorySwipeAdaptor);


        }

        return view;
    }

    private void createList() {
        myTrajectoryNum = new ArrayList<>();
        for(int i = 0;i<20; i++){
            myTrajectoryNum.add("Trajectory"+i);
            myTrajectoryLocation.add("Location"+i);
            myTrajectoryTimestamp.add("Timestamp"+i);
        }
    }

    public void setPDRStatus(ToggleButton pdrToggleButton, long starttime) {
        GlobalpdrToggleButton = pdrToggleButton;
        Globalstarttime = starttime;

        if(GlobalpdrToggleButton.isChecked()) {
            trajectory
                .setAndroidVersion(Build.VERSION.RELEASE)
                .setStartTimestamp(Globalstarttime)
                .setDataIdentifier("Identifier") // Need to choose identifier

                .setAccelerometerInfo(accelerometerinfo)
                .setGyroscopeInfo(gyroscopeinfo)
                .setRotationVectorInfo(rotationvectorinfo)
                .setMagnetometerInfo(magnetometerinfo)
                .setBarometerInfo(barometerinfo)
                .setLightSensorInfo(lightsensorinfo);
        }
        if(!(GlobalpdrToggleButton.isChecked())) {
            trajectory
                .build();

            byte[] bytes = trajectory.build().toByteArray();


            trajectory = Traj.Trajectory.newBuilder(); // Reset Trajectory
        }
    }

    public void setPDRData(float positionx, float positiony) {
        if(GlobalpdrToggleButton.isChecked()) {
            pdrsample
                .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                .setX(positionx).setY(positiony)
                .build();
            trajectory
                .addPdrData(pdrsample);
        }
    }

    public void setLocation(double latitude, double longitude, double altitude, double accuracy, double speed, String provider) {
        if(GlobalpdrToggleButton.isChecked()) {
            gnsssample
                .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                .setLatitude((float)latitude).setLongitude((float)longitude)
                .setAltitude((float)altitude)
                .setAccuracy((float)accuracy)
                .setSpeed((float)speed)
                .setProvider(provider)
                .build();
            trajectory
                .addGnssData(gnsssample);
        }
    }

    public void setAccelerometer(float[] acceleration, long accTimestamp) {
        if(GlobalpdrToggleButton.isChecked()) {
            motionsample
                .setRelativeTimestamp(10000000)
                .setAccX(100).setAccY(100).setAccZ(100)
                .setGyrX(100).setGyrY(100).setGyrZ(100)
                .setRotationVectorX(100).setRotationVectorY(100).setRotationVectorZ(100).setRotationVectorW(100)
                .setStepCount(100)
                .build();
            trajectory
                .addImuData(motionsample);
        }
    }

    public void setGyroscope(float[] gyrValues, long gyrTimestamp) {
        if(GlobalpdrToggleButton.isChecked()) {

        }
    }

    public void setRotationVector(float[] rotationvectorValues, long vecTimestamp) {
        if(GlobalpdrToggleButton.isChecked()) {

        }
    }

    public void setMagnetometer(float[] magValues, long magTimestamp) {
        if(GlobalpdrToggleButton.isChecked()) {
            positionsample
                .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                .setMagX(magValues[0]).setMagY(magValues[1]).setMagZ(magValues[2])
                .build();
            trajectory
                .addPositionData(positionsample);
        }
    }

    public void setPressure(float barValue, long barTimestamp) {
        if(GlobalpdrToggleButton.isChecked()) {
            pressuresample
                .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                .setPressure(barValue)
                .build();
            trajectory
                .addPressureData(pressuresample);
        }

    }

    public void setAmbientLight(float lightValue, long lightTimestamp) {
        if(GlobalpdrToggleButton.isChecked()) {
            lightsample
                .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                .setLight(lightValue)
                .build();
            trajectory
                .addLightData(lightsample);
        }
    }

    public void setAccelerometerInfo(String name, String vendor, double resolution, double power, float version, float type) {
        accelerometerinfo
            .setName(name)
            .setVendor(vendor)
            .setResolution((float)resolution)
            .setPower((float)power)
            .setVersion((int)version)
            .setType((int)type)
            .build();
    }

    public void setGyroscopeInfo(String name, String vendor, double resolution, double power, float version, float type) {
        gyroscopeinfo
            .setName(name)
            .setVendor(vendor)
            .setResolution((float)resolution)
            .setPower((float)power)
            .setVersion((int)version)
            .setType((int)type)
            .build();
    }

    public void setRotationVectorInfo(String name, String vendor, double resolution, double power, float version, float type) {
        rotationvectorinfo
            .setName(name)
            .setVendor(vendor)
            .setResolution((float)resolution)
            .setPower((float)power)
            .setVersion((int)version)
            .setType((int)type)
            .build();
    }

    public void setMagnetometerInfo(String name, String vendor, double resolution, double power, float version, float type) {
        magnetometerinfo
            .setName(name)
            .setVendor(vendor)
            .setResolution((float)resolution)
            .setPower((float)power)
            .setVersion((int)version)
            .setType((int)type)
            .build();
    }

    public void setBarometerInfo(String name, String vendor, double resolution, double power, float version, float type) {
        barometerinfo
            .setName(name)
            .setVendor(vendor)
            .setResolution((float)resolution)
            .setPower((float)power)
            .setVersion((int)version)
            .setType((int)type)
            .build();
    }

    public void setLightSensorInfo(String name, String vendor, double resolution, double power, float version, float type) {
        lightsensorinfo
            .setName(name)
            .setVendor(vendor)
            .setResolution((float)resolution)
            .setPower((float)power)
            .setVersion((int)version)
            .setType((int)type)
            .build();
    }

    // trajectory
      //       .addWifiData(wifisample)
        //    .addApsData(apdata);
}