package com.example.a2_integration;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** This fragment receives, formats and stores all data into trajectory class as required
 * and sends them to the cloud.
 *
 * Fundamental Features include:
 *  - Collect all data inform as required
 *  - Automatically upload trajectory to the cloud every 10 minutes (?? may be not that accurate
 *
 * Extra Features include:
 * - segment the trajectories into 10 min sections and prepare them for sending.
 * - Store and access previous trajectories for viewing.
 * - UI allows the user check local trajectory, preview trajectory inform and manually upload trajectory to the cloud.
 */

public class task3api extends Fragment implements swipeAdaptor.OnBtnDeleteClickListener,
        swipeAdaptor.OnBtnLoadClickListener, swipeAdaptor.OnBtnUploadClickListener{

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
    // Boolean checks on whether data from 3 sensors is ready (motion sample)
    boolean accelerometerready = false;
    boolean gyroscopeready = false;
    boolean vectorrotationready = false;

    int GlobalStrideCount = 0; // Step counter

    boolean Globalpdrrunning = false;
    boolean Globalfilegenerated = false;

    // Global time counters
    long Globalstarttime = 0;
    long GlobalStopTime = 0;
    long Globalcurrenttime = 0;

    String GlobalBuilding;

    // UI Views
    TextView binaryFileToString;
    RecyclerView trajectoryList;
    swipeAdaptor trajectorySwipeAdaptor;

    // Array Lists for Swipe Adapter
    private ArrayList<String> myTrajectoryNum = new ArrayList<>();
    private ArrayList<String> myTrajectoryLocation = new ArrayList<>();
    private ArrayList<String> myTrajectoryTimestamp = new ArrayList<>();

    // Array list for Files in Downloads Directory (Load Trajectory Views)
    private List<String> filePaths = new ArrayList<>();

    private boolean isRunning = false;

    int trajectoryNum = 0; // trajectory number
    long previousTimestamp = 0; // timestamp
    int count = 1; // counter

    // File directories/ lists
    File storagedir2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    List<File> fileList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task3api, container, false);

        // UI Views (text view for data file preview and swipe adapter for data file list)

        trajectoryList = view.findViewById(R.id.trajectoryRecycler);
        binaryFileToString = view.findViewById(R.id.tvProtoFile);

        // Setting layout of swipe adapter list
        // Check out the layout file of customised swipe recyclerview: layout_trajectoryView.xml
        // Check out the adaptor for this recyclerview: swipeAdaptor.java

        if(trajectoryList!= null){
            trajectoryList.setLayoutManager(new LinearLayoutManager(getContext()));
            trajectoryList.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
            trajectorySwipeAdaptor = new swipeAdaptor
                    (getContext(),myTrajectoryNum,myTrajectoryLocation,myTrajectoryTimestamp,this,this,this);
            trajectoryList.setAdapter(trajectorySwipeAdaptor);
        }

        // Set flag to true
        isRunning = true;
        previousTimestamp=Globalstarttime;

        refreshListView(); // Refresh list of data files, searching Downloads directory

        return view; // return view
    }

    // Create data file list item
    private void createList(int i, String Building, long timestamp, long initialTimestamp, String name) {
        //Format timestamp before display on UI;
        long millis = timestamp-initialTimestamp;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        String formatTime = String.format("%d:%02d", minutes, seconds);
        // Add text fields to the data file list item
        myTrajectoryNum.add(name); // name of data file (Trajectory_<Building>_<Timestamp>) format
        myTrajectoryLocation.add("");
        myTrajectoryTimestamp.add("");
        trajectorySwipeAdaptor.notifyDataSetChanged();
    }

    // Sets/ checks status of PDR and packages up data packet if it is time to send
    public void setPDRStatus(boolean pdrrunning, long starttime, long stoptime, byte building, long currenttime) {
        // Global flags assigned
        Globalpdrrunning = pdrrunning;
        Globalstarttime = starttime;
        GlobalStopTime = stoptime;
        Globalcurrenttime = currenttime;
        long timesincestart = Globalcurrenttime - Globalstarttime; // indicates how long has passed since PDR test began
        if(building == 0X0) { // Assign string to building of PDR test
            GlobalBuilding = "Nucleus";
        } else {
            GlobalBuilding = "Library";
        }

        // If PDR stop is pressed or 10 minutes elapse, package up data packet, write to a local binary file, store
        // in downloads and send to the API
<<<<<<< HEAD
        if(!(Globalpdrrunning) || ((timesincestart) > 240000*count)) {
            if((timesincestart) > (240000*count)) {
                oldStrideCount = GlobalStrideCount;
            }

            count++;
            if(!(Globalpdrrunning)) {
                count = 1;
                oldStrideCount = 0;
=======
        if(!(Globalpdrrunning) || ((timesincestart) > 600000*count)) {
            count++;
            if(!(Globalpdrrunning)) {
                count = 1;
>>>>>>> parent of f0144df (22/04 optimisation v1)
            }
            // Set sensor information and other static elements of trajectory data packet.
            trajectory
                    .setAndroidVersion(Build.VERSION.RELEASE)
                    .setStartTimestamp(Globalstarttime)
                    .setDataIdentifier("Building:" + GlobalBuilding) // Need to choose identifier

                    .setAccelerometerInfo(accelerometerinfo)
                    .setGyroscopeInfo(gyroscopeinfo)
                    .setRotationVectorInfo(rotationvectorinfo)
                    .setMagnetometerInfo(magnetometerinfo)
                    .setBarometerInfo(barometerinfo)
                    .setLightSensorInfo(lightsensorinfo)
                    .build();

            // Bytes of Data from Trajectory
            byte[] bytes = trajectory.build().toByteArray();

            File trajectorydata = null;
            try {
                trajectorydata = createBinaryFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Write contents of bytes to a binary file
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

            // Indicate upload of trajectory has begun
            Toast.makeText(getContext(), "Upload trajectory started", Toast.LENGTH_SHORT).show();
            // Begin asynchronous task to upload data. This means data can upload in the background
            // without interrupting the PDR or other app tasks.
            MyAsyncTask task = new MyAsyncTask(currentBinaryPath, getContext());
            task.execute();
            // Refresh data file list view since new item has been created
            refreshListView();
            trajectory = Traj.Trajectory.newBuilder(); // Reset Trajectory data
        }
    }

    // Set latest PDR sample data and write it into current trajectory packet
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

    // Set latest Wifi sample data and write it into current trajectory packet
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

    // Set latest Wifi access point data and write it into current trajectory packet
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

    // Set latest location sample data and write it into current trajectory packet
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

    // Set latest accelerometer sample data and write it into current trajectory packet
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

    // Set latest gyroscope sample data and write it into current trajectory packet
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

    // Set latest rotation vector sample data and write it into current trajectory packet
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

    // Set latest magnetometer sample data and write it into current trajectory packet
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

    // Set latest Pressure sample data and write it into current trajectory packet
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

    // Set latest ambient light sample data and write it into current trajectory packet
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

    // Set accelerometer sensor info
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

    // Set gyroscope sensor info
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

    // Set rotation vector sensor info
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

    // Set magnetometer sensor info
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

    // Set barometer sensor info
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

    // Set light sensor info
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

    String currentBinaryPath;
    String imageFileName;
    // Function to create local binary file in phone directory that we write binary trajectory data packet to.
    private File createBinaryFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("_ddMMyy_HHmmss").format(new Date());
        imageFileName = "Trajectory_" + GlobalBuilding + timeStamp;
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File trajectory = new File(storageDir + "/" + File.separator + imageFileName + ".bin");
        trajectory.createNewFile();
        // Save a file: path for use with ACTION_VIEW intents
        currentBinaryPath = trajectory.getAbsolutePath();
        return trajectory;
    }

    // Function when upload button is pressed for data file in list view
    @Override
    public void onUploadClick(int position) {
        Log.d(TAG, "onUploadClick: upload button is clicked");
        // Refresh the data file list view
        refreshListView();
        currentBinaryPath = fileList.get(position).getAbsolutePath();
        MyAsyncTask task = new MyAsyncTask(currentBinaryPath, getContext());
        task.execute();
    }

    //Delete and load function to process trajectory data set
    @Override
    public void onDeleteClick(int position) {
        Log.d(TAG, "onDeleteClick: delete button is clicked");
        // Refresh the data file list view
        refreshListView();
        if(position>=0 && position<myTrajectoryNum.size()){
            myTrajectoryNum.remove(position);
            trajectorySwipeAdaptor.notifyItemRemoved(position);
            trajectorySwipeAdaptor.notifyItemRangeChanged(position, myTrajectoryNum.size());
        }
        // Delete appropriate file that was clicked
        fileList.get(position).delete();
        // Refresh again
        refreshListView();
    }

    @Override
    public void onLoadClick(int position) {
        Log.d(TAG, "load button is clicked");
        try {
            // Refresh data file list
            refreshListView();
            String filename = fileList.get(position).getName();
            Path path = Paths.get(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);
            byte[] data = Files.readAllBytes(path);
            Traj.Trajectory displaytraj = Traj.Trajectory.parseFrom(data);
            String display = displaytraj.toString();
            binaryFileToString.setText(display.substring(0,100000) + "..."); // get string data
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

        // Null checker to prevent crash of app.
        if(file == null) { }
        else {
            int j = 0;
            for (int i = 0; i < file.length; i++) {
                if (file[i].getName().contains("Trajectory")) {
                    fileList.add(file[i]);
                    //String[] naming = file[i].getName().split("_");
                    createList(trajectoryNum, "string", 0, 0, fileList.get(j).getName());
                    trajectoryNum++;
                    j++;
                }
            }
        }
    }

}

// Asynchronous background task responsible for uploading data to the cloud.
class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    String currentBinaryPath; // string storing path to current binary file to upload
    Context context;
    int responseCode; // response code fed back from http connection (200 is successful, 400 indicates invalid, 422 indicates error with connection)

    public MyAsyncTask(String data, Context context) {
        this.currentBinaryPath = data;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            // Open HTTPs connection to API
            URL url = new URL("https://openpositioning.org/api/live/trajectory/upload/7Dqa_-rdwWk_ym3xrMlrFg/?key=ewireless");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST"); // POST request
            conn.setRequestProperty("accept", "application/json"); // Set accept
            String boundary = Long.toHexString(System.currentTimeMillis());
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary); // Set content type
            // Write the file contents to the request body
            File file = new File(currentBinaryPath.toString()); // Feed current binary path into a file
            // Create output stream with data from that file.
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
            // Get the response from the server in code form (400, 200, 422)
            responseCode = conn.getResponseCode();
            System.out.println("Response code: " + responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        // Send feedback message to user indicating whether upload was successful or if there was an error.
        if(responseCode == 200) {
            Toast.makeText(context, "Upload Trajectory Completed", Toast.LENGTH_SHORT).show();
        } else if(responseCode == 400) {
            Toast.makeText(context, "Upload Failed, Code 400", Toast.LENGTH_SHORT).show();
        } else if(responseCode == 422) {
            Toast.makeText(context, "Upload Failed, Code 422", Toast.LENGTH_SHORT).show();
        }
    }
}