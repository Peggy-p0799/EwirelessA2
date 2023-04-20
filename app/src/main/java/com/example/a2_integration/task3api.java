package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class task3api extends Fragment implements swipeAdaptor.OnBtnDeleteClickListener,swipeAdaptor.OnBtnLoadClickListener{

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

    private static final String TAG = "Task3Activity";

    boolean accelerometerready = false;
    boolean gyroscopeready = false;
    boolean vectorrotationready = false;

    int GlobalStrideCount = 0;
    long Globalstarttime = 0;
    boolean Globalpdrrunning = false;

    boolean Globalfilegenerated = false;
    long GlobalStopTime = 0;
    String GlobalBuilding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        askReadWritePermissions();

    }

    TextView binaryFileToString;
    RecyclerView trajectoryList;
    swipeAdaptor trajectorySwipeAdaptor;

    private ArrayList<String> myTrajectoryNum = new ArrayList<>();
    private ArrayList<String> myTrajectoryLocation = new ArrayList<>();
    private ArrayList<String> myTrajectoryTimestamp = new ArrayList<>();

    private List<String> filePaths = new ArrayList<>();

    private boolean isRunning = false;
    int trajectoryNum = 0;
    long previousTimestamp = 0;
    long initialTimestamp = 0 ;

    File storagedir2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    List<File> fileList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task3api, container, false);

        trajectoryList = view.findViewById(R.id.trajectoryRecycler);
        binaryFileToString = view.findViewById(R.id.tvProtoFile);

        if(trajectoryList!= null){
            trajectoryList.setLayoutManager(new LinearLayoutManager(getContext()));
            trajectoryList.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
            trajectorySwipeAdaptor = new swipeAdaptor
                    (getContext(),myTrajectoryNum,myTrajectoryLocation,myTrajectoryTimestamp,this,this);
            trajectoryList.setAdapter(trajectorySwipeAdaptor);
        }

        isRunning = true;
        previousTimestamp=Globalstarttime;

        if(!storagedir2.exists()){
            storagedir2.mkdirs();
        }

        refreshListView();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while(isRunning) {
                    // do something here
                    if(initialTimestamp==0){
                        initialTimestamp = Globalstarttime; // Record the initial timestamp when user firstly hits start button
                    }

                    if((!Globalpdrrunning)&&(previousTimestamp!=Globalstarttime)&&(Globalfilegenerated)) {
                        myTrajectoryNum.clear();
                        myTrajectoryLocation.clear();
                        myTrajectoryTimestamp.clear();

                        File f = new File(storagedir2.toString());
                        File file[] = f.listFiles();
                        File trajectoryfiles[] = new File[file.length];

                        //createList(trajectoryNum,GlobalBuilding,0,0,imageFileName);
                        //trajectoryNum++;
                        //previousTimestamp=Globalstarttime;
                        int j = 0;
                        for(int i = 0; i < file.length; i++) {
                            if(file[i].getName().contains("Trajectory")){

                                trajectoryfiles[j] = file[i];
                                //String[] naming = file[i].getName().split("_");
                                createList(trajectoryNum, "string", 0, 0, trajectoryfiles[j].getName());
                                trajectoryNum++;
                                j++;
                            }
                        }
                        Globalfilegenerated = false;
                    }
                }
            }
        }).start();
        */

        return view;
    }

    private void createList(int i, String Building, long timestamp, long initialTimestamp, String name) {
        //Format timestamp before display on UI;
        long millis = timestamp-initialTimestamp;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        String formatTime = String.format("%d:%02d", minutes, seconds);

        myTrajectoryNum.add(name);
        myTrajectoryLocation.add("");
        myTrajectoryTimestamp.add("");
        trajectorySwipeAdaptor.notifyDataSetChanged();
    }

    public void setPDRStatus(boolean pdrrunning, long starttime, long stoptime, byte building) {
        Globalpdrrunning = pdrrunning;
        Globalstarttime = starttime;
        GlobalStopTime = stoptime;
        if(building == 0X0) {
            GlobalBuilding = "Nucleus";
        } else {
            GlobalBuilding = "Library";
        }


        if(Globalpdrrunning) {
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
        if(!(Globalpdrrunning)) {
            trajectory
                    .build();

            // Bytes of Data from Trajectory
            byte[] bytes = trajectory.build().toByteArray();

            // Create and Write Data to Binary File, store in Downloads
            /*
            File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if(!directory.exists()){
                directory.mkdirs();
            }
            String filename = "trajectorydata_" + trajectoryNum + ".bin";
            File trajectorydata = new File(directory, filename);
            */

            File trajectorydata = null;
            try {
                trajectorydata = createBinaryFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(trajectorydata);
                fos.write(bytes);
                fos.flush();
                fos.close();
                Globalfilegenerated = true;

                // Store the path of the created file
                String filePath = trajectorydata.getAbsolutePath();
                filePaths.add("debug lines");
                filePaths.add(filePath);
            } catch (IOException ex) {
                ex.printStackTrace();
                Log.e(TAG, "IOException occurred: " + ex.getMessage());
            }



            try {
                URL url = new URL("https://openpositioning.org/api/live/trajectory/upload/7Dqa_-rdwWk_ym3xrMlrFg/?key=ewireless");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("accept", "application/json");
                String boundary = Long.toHexString(System.currentTimeMillis());
                conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

                // Write the file contents to the request body
                File file = new File(currentBinaryPath.toString());
                try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
                     OutputStream os = conn.getOutputStream()) {
                    os.write(("--" + boundary + "\r\n").getBytes());
                    os.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n").getBytes());
                    os.write(("Content-Type: application/octet-stream\r\n\r\n").getBytes());

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }

                    os.write(("\r\n--" + boundary + "--\r\n").getBytes());
                }

                // Get the response
                int responseCode = conn.getResponseCode();
                System.out.println("Response code: " + responseCode);
            } catch (IOException e) {
                e.printStackTrace();
            }

            refreshListView();
            trajectory = Traj.Trajectory.newBuilder(); // Reset Trajectory
        }
    }

    String srcdebug;
    public String readBinaryFileToString(List<String> filePaths, int index) {
        String filePath = filePaths.get(index);

        byte[] bytes = new byte[0];
        try {
            // Read bytes from the binary file
            FileInputStream fis = new FileInputStream(filePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buf)) != -1) {
                bos.write(buf, 0, bytesRead);
            }
            bytes = bos.toByteArray();
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Convert bytes to string
        String str = new Scanner(new ByteArrayInputStream(bytes), "UTF-8").useDelimiter("\\A").next(); // convert bytes to string
        srcdebug = "str";
        return srcdebug;
    }

    public void setPDRData(float positionx, float positiony, int strideCount) {
        if(Globalpdrrunning) {
            GlobalStrideCount = strideCount;
            pdrsample
                    .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                    .setX(positionx).setY(positiony)
                    .build();
            trajectory
                    .addPdrData(pdrsample);
        }
    }

    public void setwifiData(long macaddress, int rssi, int i, int scanlistsize) {
        if(Globalpdrrunning) {
            macscan
                    .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                    .setMac(macaddress)
                    .setRssi(rssi)
                    .build();
            wifisample
                    .addMacScans(macscan);

            if(i == (scanlistsize - 1)) {
                wifisample
                        .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                        .build();
                trajectory
                        .addWifiData(wifisample);

                wifisample = Traj.WiFi_Sample.newBuilder(); // reset wifisample
            }
        }
    }

    public void setAccessPointData(long mac, String ssid, long frequency) {
        if(Globalpdrrunning) {
            apdata
                    .setMac(mac)
                    .setSsid(ssid)
                    .setFrequency(frequency)
                    .build();
            trajectory
                    .addApsData(apdata);
        }
    }

    public void setLocation(double latitude, double longitude, double altitude, double accuracy, double speed, String provider) {
        if(Globalpdrrunning) {
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
        if(Globalpdrrunning) {
            motionsample
                    .setAccX(acceleration[0]).setAccY(acceleration[1]).setAccZ(acceleration[2]);
            accelerometerready = true;
            if(vectorrotationready & gyroscopeready & accelerometerready) {
                motionsample
                        .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                        .setStepCount(GlobalStrideCount)
                        .build();
                trajectory
                        .addImuData(motionsample);

                vectorrotationready = false; gyroscopeready = false; accelerometerready = false;
            }
        }
    }

    public void setGyroscope(float[] gyrValues, long gyrTimestamp) {
        if(Globalpdrrunning) {
            motionsample
                    .setGyrX(gyrValues[0]).setGyrY(gyrValues[1]).setGyrZ(gyrValues[2]);
            gyroscopeready = true;
            if(vectorrotationready & gyroscopeready & accelerometerready) {
                motionsample
                        .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                        .setStepCount(GlobalStrideCount)
                        .build();
                trajectory
                        .addImuData(motionsample);

                vectorrotationready = false; gyroscopeready = false; accelerometerready = false;
            }
        }
    }

    public void setRotationVector(float[] rotationvectorValues, long vecTimestamp) {
        if(Globalpdrrunning) {
            motionsample
                    .setRotationVectorX(rotationvectorValues[0]).setRotationVectorY(rotationvectorValues[1]).setRotationVectorZ(rotationvectorValues[2]).setRotationVectorW(rotationvectorValues[3]);
            vectorrotationready = true;
            if(vectorrotationready & gyroscopeready & accelerometerready) {
                motionsample
                        .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                        .setStepCount(GlobalStrideCount)
                        .build();
                trajectory
                        .addImuData(motionsample);

                vectorrotationready = false; gyroscopeready = false; accelerometerready = false;
            }
        }
    }

    public void setMagnetometer(float[] magValues, long magTimestamp) {
        if(Globalpdrrunning) {
            positionsample
                    .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                    .setMagX(magValues[0]).setMagY(magValues[1]).setMagZ(magValues[2])
                    .build();
            trajectory
                    .addPositionData(positionsample);
        }
    }

    public void setPressure(float barValue, long barTimestamp) {
        if(Globalpdrrunning) {
            pressuresample
                    .setRelativeTimestamp(System.currentTimeMillis()-Globalstarttime)
                    .setPressure(barValue)
                    .build();
            trajectory
                    .addPressureData(pressuresample);
        }

    }

    public void setAmbientLight(float lightValue, long lightTimestamp) {
        if(Globalpdrrunning) {
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

    //Seems not using this function---------------//

    String currentBinaryPath;
    String imageFileName;
    private File createBinaryFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("_ddMMyy_HHmmss").format(new Date());
        imageFileName = "Trajectory_" + GlobalBuilding + timeStamp;
        //String imageFileName = "test6";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        File trajectory = new File(storageDir + "/" + File.separator + imageFileName + ".bin");
        trajectory.createNewFile();

        // Save a file: path for use with ACTION_VIEW intents
        currentBinaryPath = trajectory.getAbsolutePath();
        return trajectory;
    }


    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;

    private void askReadWritePermissions() {
        if(android.os.Build.VERSION.SDK_INT >= 23) {
            // Check if we have read/write permissions
            int readPermission = ActivityCompat.checkSelfPermission(getContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ActivityCompat.checkSelfPermission(getContext(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

            int cameraPermission = ActivityCompat.checkSelfPermission(getContext(),
                    android.Manifest.permission.CAMERA);

            if(writePermission != PackageManager.PERMISSION_GRANTED ||
                    readPermission != PackageManager.PERMISSION_GRANTED ||
                    cameraPermission != PackageManager.PERMISSION_GRANTED) {
                // If we don't have permission prompt the user
                this.requestPermissions(
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.CAMERA},
                        REQUEST_ID_READ_WRITE_PERMISSION
                );
                return;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case REQUEST_ID_READ_WRITE_PERMISSION: {
                // Note: If request is cancelled, the result arrays are empty.
                // Permissions granted (read/write/camera).
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                }
                // Cancelled or denied.
                else {
                    Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    //Delete and load function to process trajectory data set
    @Override
    public void onDeleteClick(int position) {
        Log.d(TAG, "onDeleteClick: delete button is clicked");
        refreshListView();

        fileList.get(position+1).delete();

        refreshListView();

    }

    @Override
    public void onLoadClick(int position) {
        Log.d(TAG, "load button is clicked");
        try {
            refreshListView();

            String filename = fileList.get(position).getName();
            Path path = Paths.get(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);
            byte[] data = Files.readAllBytes(path);
            Traj.Trajectory displaytraj = Traj.Trajectory.parseFrom(data);
            binaryFileToString.setText(displaytraj.toString().substring(0,10000) + "..."); // get string data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshListView() {
        myTrajectoryNum.clear();
        myTrajectoryLocation.clear();
        myTrajectoryTimestamp.clear();

        File f = new File(storagedir2.toString());
        File file[] = f.listFiles();
        fileList.clear();

        //createList(trajectoryNum,GlobalBuilding,0,0,imageFileName);
        //trajectoryNum++;
        //previousTimestamp=Globalstarttime;
        int j = 0;
        for(int i = 0; i < file.length; i++) {
            if(file[i].getName().contains("Trajectory")){

                fileList.add(file[i]);
                //String[] naming = file[i].getName().split("_");
                createList(trajectoryNum, "string", 0, 0, fileList.get(j).getName());
                trajectoryNum++;
                j++;
            }
        }
    }
}