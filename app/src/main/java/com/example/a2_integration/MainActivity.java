package com.example.a2_integration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.WindowManager;
import com.google.android.material.navigation.NavigationView;

/** This activity integrates
 *  Author: Thomas Harley
 *
 *  Features:
 *  - Modular hierarchy including three fragments.
 *  - Navigation bar to move between fragments.
 *  - Handles data sharing between fragments.
 */

public class MainActivity extends AppCompatActivity implements task1sensors.SensorsListener,
        task2pdr.SensorsListener {
    /************************** Declarations ***************************/

    FragmentManager fragmentManager; // Declare manager

    // Declare all fragments
    Fragment sensorsfragment = new task1sensors();
    Fragment pdrfragment = new task2pdr();
    Fragment apifragment = new task3api();
    Fragment currentfragment;

    // For the Nav Bar
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    String title; // Used to change title at top of app

    /************************** onCreate ***************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // So user can always see the display
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // This executes on creation of the app
        setTitle("Assignment 2"); // Title of this app is Compass+

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set view to activity_main.xml file
        handlingNavBar(); // initialises navbar
        initialiseFragments(); // initialises all the fragments and shows default (compass)
    }

    /************************** onPause ***************************/

    @Override
    protected void onPause() {
        super.onPause();
    }

    /************************** onResume ***************************/

    @Override
    protected void onResume() {
        super.onResume();
    }

    /************************** Navigation bar initialisation ***************************/

    private void handlingNavBar() {
        // The drawer layout toggles menu icon to open drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        drawerLayout.openDrawer(Gravity.LEFT);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open,
                R.string.nav_close);

        // Passes the Open and Close toggle for the drawer layout listener to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // makes the Navigation drawer icon always appear on the action bar
        NavigationView navigation = findViewById(R.id.navigation);

        // Listens for clicks of nav bar buttons
        navigation.setNavigationItemSelectedListener(item -> {
            // hide current fragment
            fragmentManager.beginTransaction().hide(currentfragment).commit();
            // switch statement to select between fragments
            switch(item.getItemId()) {
                case R.id.nav_sensorList:
                    currentfragment =  sensorsfragment; // switch to compass
                    title = "Sensor View App";
                    break;
                case R.id.nav_pdrNucleus:
                    currentfragment = pdrfragment; // switch to pedometer
                    title = "PDR App";
                    break;
                case R.id.nav_cloud:
                    currentfragment = apifragment; // switch to settings
                    title = "Cloud API App";
                default:
                    break;
            }
            // Show the fragment that was just selected
            fragmentManager.beginTransaction().show(currentfragment).commit();
            drawerLayout.closeDrawer(GravityCompat.START); // close Navigation drawer

            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // When menu/back button is pressed
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /************************** Fragment initialisation ***************************/

    private void initialiseFragments() {
        fragmentManager = getSupportFragmentManager();

        // Initialise fragments and add them to flcontent frame layout declared in activity_main.xml
        fragmentManager.beginTransaction().add(R.id.flContent, sensorsfragment).commit();
        fragmentManager.beginTransaction().add(R.id.flContent, pdrfragment).commit();
        fragmentManager.beginTransaction().add(R.id.flContent, apifragment).commit();

        // Hide secondary fragments (pedometer, settings)
        fragmentManager.beginTransaction().hide(pdrfragment).commit();
        fragmentManager.beginTransaction().hide(apifragment).commit();

        // Set current fragment to the default (compass)
        currentfragment = sensorsfragment;
    }

    /************************** Listeners from task1sensors Fragment ***************************/

    @Override
    public void LocationData(double tlat, double tlong, double altitude, double accuracy,
                             double speed, String provider) {
        task3api apidata = (task3api) apifragment;
        apidata.setLocation(tlat, tlong, altitude, accuracy, speed, provider);
    }

    @Override
    public void AccelerometerData(float[] acceleration, long accTimestamp) {
        task3api apidata = (task3api) apifragment;
        apidata.setAccelerometer(acceleration, accTimestamp);
    }

    @Override
    public void LinearAccelerationData(float[] linearacceleration, long accTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setLinearAcceleration(linearacceleration, accTimestamp);
    }

    @Override
    public void GravityData(float[] gravity, long accTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setGravity(gravity, accTimestamp);
    }

    @Override
    public void GyroscopeData(float[] gyrValues, long gyrTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setGyroscope(gyrValues, gyrTimestamp);

        task3api apidata = (task3api) apifragment;
        apidata.setGyroscope(gyrValues, gyrTimestamp);
    }

    @Override
    public void MagnetometerData(float[] magneticFieldValues, long magTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setMagnetometer(magneticFieldValues, magTimestamp);

        task3api apidata = (task3api) apifragment;
        apidata.setMagnetometer(magneticFieldValues, magTimestamp);
    }

    @Override
    public void PressureData(float barValue, long barTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setPressure(barValue, barTimestamp);

        task3api apidata = (task3api) apifragment;
        apidata.setPressure(barValue, barTimestamp);
    }

    @Override
    public void ProximityData(float prxValue, long prxTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setProximity(prxValue, prxTimestamp);
    }

    @Override
    public void AmbientLightData(float lightValue, long lightTimestamp) {
        task2pdr pdrdata = (task2pdr) pdrfragment;
        pdrdata.setAmbientLight(lightValue, lightTimestamp);

        task3api apidata = (task3api) apifragment;
        apidata.setAmbientLight(lightValue, lightTimestamp);
    }

    @Override
    public void RotationVectorData(float[] rotationvectorValues, long vecTimestamp) {
        task3api apidata = (task3api) apifragment;
        apidata.setRotationVector(rotationvectorValues, vecTimestamp);
    }

    @Override
    public void AccelerometerInfo(String name, String vendor, double resolution, double power,
                                  float version, float type) {
        task3api apidata = (task3api) apifragment;
        apidata.setAccelerometerInfo(name, vendor, resolution, power, version, type);
    }

    @Override
    public void GyroscopeInfo(String name, String vendor, double resolution, double power,
                              float version, float type) {
        task3api apidata = (task3api) apifragment;
        apidata.setGyroscopeInfo(name, vendor, resolution, power, version, type);
    }

    @Override
    public void RotationVectorInfo(String name, String vendor, double resolution, double power,
                                   float version, float type) {
        task3api apidata = (task3api) apifragment;
        apidata.setRotationVectorInfo(name, vendor, resolution, power, version, type);
    }

    @Override
    public void MagnetometerInfo(String name, String vendor, double resolution, double power,
                                 float version, float type) {
        task3api apidata = (task3api) apifragment;
        apidata.setMagnetometerInfo(name, vendor, resolution, power, version, type);
    }

    @Override
    public void BarometerInfo(String name, String vendor, double resolution, double power,
                              float version, float type) {
        task3api apidata = (task3api) apifragment;
        apidata.setBarometerInfo(name, vendor, resolution, power, version, type);
    }

    @Override
    public void LightSensorInfo(String name, String vendor, double resolution, double power,
                                float version, float type) {
        task3api apidata = (task3api) apifragment;
        apidata.setLightSensorInfo(name, vendor, resolution, power, version, type);
    }

    @Override
    public void wifiData(long macaddress, int rssi, int i, int scanlistsize) {
        task3api apidata = (task3api) apifragment;
        apidata.setwifiData(macaddress, rssi, i, scanlistsize);
    }

    @Override
    public void AccessPointData(long mac, String ssid, long frequency) {
        task3api apidata = (task3api) apifragment;
        apidata.setAccessPointData(mac, ssid, frequency);
    }

    /************************** Listeners from task2pdr Fragment ***************************/

    @Override
    public void PDRStatus(boolean pdrrunning, long starttime, long stoptime, byte building,
                          long currenttime) {
        task3api apidata = (task3api) apifragment;
        apidata.setPDRStatus(pdrrunning, starttime,stoptime,building,currenttime);
    }

    @Override
    public void PDRData(float positionx, float positiony, int strideCount) {
        task3api apidata = (task3api) apifragment;
        apidata.setPDRData(positionx, positiony, strideCount);
    }
}