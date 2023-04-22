package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.Objects;

/** This fragment performs a pedestrian dead reckoning (PDR) function.
 * Fundamental features include:
 * - PDR computation
 * - Sensor fusion for PDR correction (Gyro + Compass)
 * - Trajectory visualisation
 *
 * Extra features include:
 * - Initialise user's position by touch point input
 * - Floor-plan display for every floor of two required buildings: Nucleus and Murray Library.
 * - Floor-plan will be automatically updated if the altitude change of user is detected.
 * - Drop down menu added on UI, allowing User to choose initial building and floor.
 **/

public class task2pdr extends Fragment implements SensorEventListener {

    /************************ Class definition *********************/

    // A Canvas for viewing the trajectory
    myCanvas trajectoryView;

    // Spinners to select the building and initial floor
    Spinner spinnerBuilding;
    Spinner spinnerFloor;

    // ImageViews to view the floorplan and compass needle
    ImageView ivMap;
    ImageView ivCompass;

    // TextViews to view the information
    TextView tvHeading;
    TextView tvGyroHeading;
    TextView tvCompassHeading;
    TextView tvTimer;
    TextView tvTouchX;
    TextView tvTouchY;

    // Buttons to start/stop and reset the trajectory
    ToggleButton pdrToggleButton;
    Button pdrResetButton;

    // Get access to sensors
    private SensorManager mSensorManager;

    // Declare the activitycommander
    task2pdr.SensorsListener activitycommander;

    /************************Variables*********************/

    private int displayHeight;  // The height of the display in pixels
    private int displayWidth;   // The width of the display in pixels
    private boolean doPDR = false;  // Set true when PDR is active
    private boolean resetInitialPosition = true;    // True when initial position can be updated
    private final int[] mapOrigin = new int[2];   // Coordinates of lower left corner of canvas
    private float touchX;   // x coordinate of the user's touch
    private float touchY;   // y coordinate of the user's touch
    boolean pdrrunning = false; // Set to true when PDR is active

    // Declare the SensorsListener interface to allow data sharing between fragments
    public interface SensorsListener {
        void PDRStatus(boolean pdrrunning, long starttime, long stoptime,byte building,long
                currenttime);
        void PDRData(float positionx, float positiony, int strideCount);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activitycommander = (task2pdr.SensorsListener) activity;
    }

    // Height offset from status bar needs to be cut for precise touch event on map canvas
    // Get status bar height here
    int statusBarHeight;
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    // Called when the fragment is created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarHeight=getStatusBarHeight();

        // Check and request permissions - ACTIVITY_RECOGNITION required for step detector
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.
                ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED) {
            // Ask for permission
            requestPermissions(new String[] {android.Manifest.permission.ACTIVITY_RECOGNITION},
                    Sensor.TYPE_STEP_DETECTOR);
        }

        // Get an instance of SensorManager for accessing sensors
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);

        // Get the dimensions of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayHeight = displayMetrics.heightPixels;
        displayWidth = displayMetrics.widthPixels;
    }

    private float initialPositionX = 0f;
    private float initialPositionY = 0f;
    // Called when the fragment view is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task2pdr, container, false);

        // Initialise the UI elements
        trajectoryView = (myCanvas) view.findViewById(R.id.trajectoryView);
        spinnerBuilding = (Spinner) view.findViewById(R.id.spnBuilding);
        spinnerFloor = (Spinner) view.findViewById(R.id.spnFloor);
        ivMap = (ImageView) view.findViewById(R.id.ivMap);
        pdrToggleButton = (ToggleButton)view.findViewById(R.id.pdrToggle);
        pdrResetButton = (Button)view.findViewById(R.id.pdrReset);
        ivCompass= (ImageView) view.findViewById(R.id.imagCompass);
        tvTimer = (TextView) view.findViewById(R.id.tvTimer);

        // Button Initialisation
        pdrToggleOnclick();
        pdrResetOnclick();

        // Spinner Initialisation
        spinnersInitialisation();

        // TouchEvent Initialisation
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent touchEvent) {
                // Detect when user lifts their finger
                if (touchEvent.getAction() == MotionEvent.ACTION_UP){
                    touchX = touchEvent.getX();
                    touchY = touchEvent.getY();
                }
                    // Only register the initial position if PDR is not active
                    if (resetInitialPosition) {
                    // Set mapOrigin to the coordinates of the lower left of the canvas
                    trajectoryView.getLocationOnScreen(mapOrigin);
                    // Only register the initial position if the touch is on the map
                    if (touchX >= mapOrigin[0] && touchX <= (mapOrigin[0]+trajectoryView.
                            getWidth())) {
                        if (touchY >= displayHeight-trajectoryView.getHeight()) {
                            // Draw a circle marker at the initial position
                            initialPositionX = touchX-mapOrigin[0];
                            initialPositionY = displayHeight-touchY-statusBarHeight;
                            trajectoryView.drawInitialPosition(initialPositionX,initialPositionY);
                        }
                    }
                }
                return true;
            }
        });
        return view;
    }


    long startTime = 0; // PDR start time
    long stopTime = 0;  // PDR stop time
    // Runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            // Update the timer
            tvTimer.setText(String.format("%d:%02d", minutes, seconds));
            timerHandler.postDelayed(this, 500);
        }
    };

    // Listeners for the reset button
    private void pdrResetOnclick(){
        pdrResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notify user a long click is required to reset the PDR
                doToast("Long tap Reset button to reset whole PDR");
            }
        });
        pdrResetButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Reset the PDR
                resetPDR();
                doToast("PDR has been successfully reset");
                return true;
            }
        });
    }

    // Listener for the start/stop toggle button
    private void pdrToggleOnclick(){
        pdrToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pdrToggleButton.isChecked()){
                    // Initialise and start the PDR
                    startPDR();
                    pdrrunning = true;
                    // Enable the timer
                    startTime = System.currentTimeMillis();
                    activitycommander.PDRStatus(pdrrunning, startTime,stopTime,building,System.
                            currentTimeMillis());
                    activitycommander.PDRData(positionX,positionY,strideCount);
                    timerHandler.postDelayed(timerRunnable, 0);
                    doToast("pdr started");
                }
                else {
                    // Stop the PDR
                    stopPDR();
                    pdrrunning = false;
                    activitycommander.PDRStatus(pdrrunning, startTime,stopTime,building,System.
                            currentTimeMillis());
                    activitycommander.PDRData(positionX,positionY,strideCount);
                    //Disable the timer
                    timerHandler.removeCallbacks(timerRunnable);
                    doToast("pdr stopped");
                }
            }
        });
    }

    // Initialise the spinners
    private void spinnersInitialisation(){

        // Create adapters for the spinners. There is no lower ground floor in the library.
        // Check out the layout file for customised spinner: layout_spinner_text

        ArrayAdapter<CharSequence> adapterBuilding = ArrayAdapter.createFromResource(getContext(),
                R.array.Buildings,R.layout.layout_spinner_text);
        ArrayAdapter<CharSequence> adapterFloorNucleus = ArrayAdapter.createFromResource(
                getContext(),R.array.Floors_N,R.layout.layout_spinner_text);
        ArrayAdapter<CharSequence> adapterFloorLibrary = ArrayAdapter.createFromResource(
                getContext(),R.array.Floors_L,R.layout.layout_spinner_text);

        // Set the drop down resources
        adapterBuilding.setDropDownViewResource(R.layout.layout_spinner_text);
        adapterFloorNucleus.setDropDownViewResource(R.layout.layout_spinner_text);
        adapterFloorLibrary.setDropDownViewResource(R.layout.layout_spinner_text);

        // Initialise the spinners to lower ground nucleus
        spinnerBuilding.setAdapter(adapterBuilding);
        spinnerFloor.setAdapter(adapterFloorNucleus);

        // Listeners for the building spinner
        spinnerBuilding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Update the adapter to show the correct floor options for the chosen building
                if (Objects.equals(parent.getItemAtPosition(position), "Nucleus")) {
                    building = NUCLEUS;
                    spinnerFloor.setAdapter(adapterFloorNucleus);
                } else if (Objects.equals(parent.getItemAtPosition(position),"Library")) {
                    building = LIBRARY;
                    spinnerFloor.setAdapter(adapterFloorLibrary);
                }
                // Always update the floorplan
                updateFloorplan();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Listeners for the floor spinner
        spinnerFloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Update the floor depending on the selection and display the correct floorplan
                if (Objects.equals(parent.getItemAtPosition(position),"LG")) {
                    floor = -1;
                } else if (Objects.equals(parent.getItemAtPosition(position),"G")) {
                    floor = 0;
                } else if (Objects.equals(parent.getItemAtPosition(position),"1")) {
                    floor = 1;
                } else if (Objects.equals(parent.getItemAtPosition(position),"2")) {
                    floor = 2;
                } else if (Objects.equals(parent.getItemAtPosition(position),"3")) {
                    floor = 3;
                }
                // Always update the floorplan
                updateFloorplan();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    // Register the sensors with SensorManager when user returns to the activity
    @Override
    public void onResume() {
        super.onResume();

        // Register the step detector sensor
        Sensor StepDetector = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        if (StepDetector != null) {
            mSensorManager.registerListener(this, StepDetector,
                    SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            // Warn if step detector not available on the device
            doToast("Step Detector not present.");
        }
    }

    private final float[] stepDetectorValues = new float[2];

    // Called when the step detector values change
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // Store the values
            System.arraycopy(sensorEvent.values, 0, stepDetectorValues,
                    0, 1);
            stepDetectorValues[1] = sensorEvent.timestamp;
            // Perform relevant processing
            onStepDetectorChanged();
        }
    }

    // Not used in this activity
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private int initialFloor;   // The floor the user begins the PDR on
    private float positionX = 0f;    // Position in the E direction
    private float positionY = 0f;    // Position in the N direction
    // Captures the initial position of the user
    private void setInitialPosition() {
        // Capture the initialFloor from the floor spinner
        initialFloor = floor;
        // Store (0,0) initial position in the trajectory
        updatePosition();
        // Plot on the map
        plotTrajectory(positionX,positionY);
        // Indicate initial position has been set and do not allow further updates
        resetInitialPosition = false;
    }

    // Called when the startPDR toggle button is active
    public void startPDR() {
        // Signal all sensor measurements to be reset
        resetAccMaxMin = true;
        resetBarometer = true;
        resetGyro = true;
        resetHeading = true;
        // Indicate no sensors have been initialised
        isGyroReady = false;
        isCompassReady = false;
        isBarometerReady = false;
        isMagnetometerReady = false;
        isGravityReady = false;
        // Reset the variables
        strideCount = 0;
        strideLength = 0f;
        positionX = 0f;
        positionY = 0f;
        // Remove the previous trajectory path from the canvas
        trajectoryView.clearPoints();
        // Lock the spinners so building cannot be changed
        spinnerBuilding.setEnabled(false);
        spinnerFloor.setEnabled(false);
        // Capture the initial position and convert to real world coordinates
        setInitialPosition();
        // Indicate that PDR is active
        doPDR = true;
    }

    // Called when the stopPDR toggle button is active
    public void stopPDR() {
        // Reset the variables
        strideCount = 0;
        // Unlock the spinners so user can change the floorplan
        spinnerBuilding.setEnabled(true);
        spinnerFloor.setEnabled(true);
        // Do not erase the trajectory, only do this when resetPDR is tapped
        // Indicate sensor updates should be ignored
        doPDR = false;
    }

    // Called when the resetPDR button is tapped
    private void resetPDR() {
        // If the PDR is active, toggle the stop button
        pdrToggleButton.setChecked(false);
        // Make sure the PDR is stopped
        stopPDR();
        // Erase the trajectory
        trajectoryView.clearPoints();
        // Allow initial position updates
        resetInitialPosition = true;
    }

    private Toast mToast;   // A toast message
    // Used to cancel the existing toast and display the new toast instead
    private void doToast(String message) {
        // Cancel the previous toast if it exists
        if (mToast != null) {
            mToast.cancel();
        }
        // Initiate a new toast
        mToast = Toast.makeText(getContext(), message, Toast.LENGTH_LONG);
        mToast.show();
    }

    /** The set sensor functions are triggered whenever a new value is sent from task1pdr. **/

    private boolean resetAccMaxMin = true;  // Set true to reset the max/min accelerations
    private float accVerticalMax;   // The maximum acceleration in the device z-axis
    private float accVerticalMin;   // The minimum acceleration in the device z-axis
    private final float[] accVerticalValues = new float[3];

    // Called when the accelerometer sensor values are updated
    public void setLinearAcceleration(float[] linearAcceleration, long accTimestamp) {
        // Ignore the sensor updates unless the PDR is active
        if (!doPDR) return;

        // Store the linear acceleration values
        System.arraycopy(linearAcceleration, 0, accVerticalValues, 0, 3);

        if (resetAccMaxMin) {
            // Reset the max/min accelerations after a step is detected
            // They are reset to the first accelerometer reading of the next stride
            accVerticalMax = accVerticalValues[2];
            accVerticalMin = accVerticalValues[2];
            resetAccMaxMin = false;
        } else {
            // Otherwise, update the running maximum and minimums
            if (accVerticalValues[2] > accVerticalMax) {
                accVerticalMax = accVerticalValues[2];
            }
            if (accVerticalValues[2] < accVerticalMin) {
                accVerticalMin = accVerticalValues[2];
            }
        }
    }

    private float[] gravityValues = new float[3];
    private boolean isGravityReady = false;
    // Called when the gravity sensor values are updated
    public void setGravity(float[] gravity, long accTimestamp) {
        // Ignore the sensor updates unless the PDR is active
        if (!doPDR) return;

        gravityValues = gravity;    // Store the gravity values
        isGravityReady = true;  // Flag when the gravity sensor values are initialised
        calculateOrientation(); // Recalculate the orientation with the new values
    }

    private boolean resetGyro = true;
    private boolean isGyroReady = false;
    private float previousGyroTimestamp;
    private float gyroDeltaHeading;
    // Calculate the change in device heading using the gyroscope
    public void setGyroscope(float[] gyroscopeValues, long gyrTimestamp) {
        // Ignore the sensor updates unless the PDR is active
        if (!doPDR) return;

        // Do not integrate on the first timestep, only initialise the previous timestamp
        if (resetGyro) {
            previousGyroTimestamp = gyrTimestamp; // Initialise the previous timestamp
            resetGyro = false;  // Flag the gyroscope has been initialised
            // Do not set isGyroReady to true here
            return;
        }

        // Calculate the change in time since the gyro was updated
        // Note the timestamps are in nanoseconds
        final float timestep = (gyrTimestamp - previousGyroTimestamp) * 0.000000001f;

        // Multiply the angular velocity around the z-axis by dT to get change in device heading
        gyroDeltaHeading = -gyroscopeValues[2] * timestep;

        // Advance the previous timestamp
        previousGyroTimestamp = gyrTimestamp;

        // Flag when the gyroscope change in angle is initialised
        isGyroReady = true;

        // Combine the gyroscope and compass headings to get a more accurate heading
        sensorFusionHeading();
    }

    private float[] magnetometerValues = new float[3];
    private boolean isMagnetometerReady = false;
    // Called when the magnetometer sensor values are updated
    public void setMagnetometer(float [] magneticFieldValues, long magTimestamp) {
        // Ignore the sensor updates unless the PDR is active
        if (!doPDR) return;

        magnetometerValues = magneticFieldValues;
        isMagnetometerReady = true; // Flag when the magnetometer values are initialised
        calculateOrientation(); // Recalculate the orientation with the new values
    }

    private float barometerValue;
    private float initialPressure;
    private boolean isBarometerReady = false;
    private boolean resetBarometer = true;
    // Called when the pressure sensor values are updated
    public void setPressure(float barometerValues, long barTimestamp) {
        // Ignore the sensor updates unless the PDR is active
        if (!doPDR) return;

        // Store the barometer pressure value
        barometerValue = barometerValues;

        // Reset the barometer initial values on the first update
        if (resetBarometer) {
            initialPressure = barometerValue;   // Get an initial pressure
            updateAltitude();   // Update the altitude before setting resetBarometer = false
            resetBarometer = false;  // Flag that the barometer initial value has been saved
            isBarometerReady = true;    // Flag that the barometer is
            return;
        }

        // Update the altitude
        updateAltitude();

        // Update the floorplan depending on the altitude
        updateFloorplan();

        isBarometerReady = true;

        activitycommander.PDRStatus(pdrrunning, startTime,stopTime,building,System.currentTimeMillis()); // checking whether 10 minutes has elapsed - every 1s
    }

    // Ambient light sensor is not used by the PDR
    public void setAmbientLight(float lightValue, long lightTimestamp) {
        // Do nothing
    }

    // Proximity sensor is not used by the PDR
    public void setProximity(float prxValue, long prxTimestamp) {
        // Do nothing
    }

    private float theta;    // The angle of the step relative to magnetic North
    private int strideCount = 0;    // The number of strides taken
    // Called when step detector sensor values are updated
    public void onStepDetectorChanged() {
        // Ignore the sensor updates unless doPDR is true
        if (!doPDR) return;

        // This method is called when a step event is detected
        strideCount++; // Count the step
        weinbergSL();  // Calculate the stride length based on [Weinberg 2002]
        theta = heading;    // Assign the stride to the current direction of the heading
        resetAccMaxMin = true; // Reset max/min accelerations for next step
        updatePosition();   // Calculate the new position of the user
    }

    private final float[] rotationMatrix = new float[9];    // Stores the rotation matrix
    private final float[] orientationAngles = new float[3]; // Stores the azimuth, pitch and roll
    private boolean isCompassReady = false; // True when compass has been initialised
    private float compassHeading;   // Stores the heading from the compass between -pi and pi
    // Calculate the orientation of the device using the gravity sensor and magnetometer
    private void calculateOrientation() {
        // Do not calculate the orientation until the gravity and magnetometer values are initialised
        if (!isGravityReady || !isMagnetometerReady) {
            return;
        }

        // Calculate the orientation relative to magnetic North
        SensorManager.getRotationMatrix(rotationMatrix,null,gravityValues,magnetometerValues);
        SensorManager.getOrientation(rotationMatrix,orientationAngles);

        // Store the device heading based on the gravity and magnetometer sensors
        compassHeading = orientationAngles[0];

        isCompassReady = true;  // Flag when the compass angle is initialised
    }

    private boolean resetHeading = true;    // True when heading needs initialised
    private float heading;  // The sensor fusion heading of the device between 0 and 2pi clockwise
    private float heading_degree;   // The heading converted to degrees
    // Sensor fusion for heading using a complementary filter with tau = 0.49, fc ~= 0.32 Hz
    private void sensorFusionHeading() {
        float PI = (float) Math.PI; // The constant pi
        float diff;
        // Do not update heading unless the compass and gyroscope delta have been initialised
        if (!isCompassReady || !isGyroReady) {
            return;
        }

        // Do not update heading on first valid call, only set initial condition
        if (resetHeading) {
            heading = compassHeading;
            resetHeading = false;
            return;
        }

        // Calculate the difference between the headings returned by the compass and gyroscope
        // Convert from -pi to pi into 0 to 2pi
        diff = (((heading + gyroDeltaHeading) - compassHeading + PI + (PI*2.0f)) % (PI*2.0f)) - PI;

        // Combine the headings returned by the compass and gyroscope using a weighted average
        heading = ((PI*2.0f) + compassHeading + (0.9999f*diff)) % (PI*2.0f);

        // Convert heading to degrees for the compass animation
        heading_degree = (float) Math.toDegrees(heading);
        compassRotation();  // Perform the compass animation
    }

    // Called when a new heading is available
    private void compassRotation(){
        // Set up the rotation
        RotateAnimation rotate = new RotateAnimation(
                heading_degree, heading_degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(Animation.INFINITE);

        // Animate the compass so the needle points towards magnetic North
        ivCompass.startAnimation(rotate);
    }

    private float strideLength;
    // Estimate the step length, based on [Weinberg, 2002]
    private void weinbergSL() {
        final float K = 0.7f; // Constant dependent on person and walking mode

        // Apply the Weinberg formula
        strideLength = (float) (Math.pow((accVerticalMax-accVerticalMin),(1.0/4))*K*K);
    }

    // Update the position based on SL+theta estimate
    private void updatePosition() {
        // Get new position from step length and heading
        positionX += (float) (strideLength*Math.sin(theta));
        positionY += (float) (strideLength*Math.cos(theta));

        // Plot the step on the trajectory
        // positionX (East) and positionY (North) already align with the on-screen map x and y
        plotTrajectory(positionX,positionY);

        // Send the position information to MainActivity
        activitycommander.PDRData(positionX, positionY, strideCount);
    }

    // Plot the step on the canvas
    private void plotTrajectory(float x, float y) {
        float nucleusPixelsToMetres = 55f / 1080f;  // Scaling factor to convert pixels to metres
        float libraryPixelsToMetres = 21.5f / 860f; // Scaling factor to convert pixels to metres

        // Choose scaling depending on the chosen building
        switch (building) {
            case NUCLEUS:
                // Convert from metres to pixels
                trajectoryView.addPoint((x/ nucleusPixelsToMetres)+initialPositionX,
                        (y/ nucleusPixelsToMetres)+initialPositionY);
                break;
            case LIBRARY:
                // Convert from metres to pixels
                trajectoryView.addPoint((x/ libraryPixelsToMetres)+initialPositionX,
                        (y/ libraryPixelsToMetres)+initialPositionY);
                break;
            default:
                // Do nothing
        }
    }

    private float referenceAltitude;    // The altitude of the ground floor relative to sea level
    private float altitude; // The current altitude of the user relative to sea level
    // Update the altitude based on the barometer sensor
    private void updateAltitude() {
        // Assume 5m between floors
        final float FLOOR_HEIGHT = 5.0f;

        // Only update the initial altitude on the first call of onBarometerChanged()
        if (resetBarometer) {
            // Get the altitude relative to sea level
            referenceAltitude = SensorManager.getAltitude(SensorManager.
                    PRESSURE_STANDARD_ATMOSPHERE, initialPressure);
            if (initialFloor != -1) {
                // Correct for the initial floor, so referenceAltitude is that of the ground floor
                referenceAltitude -= initialFloor*FLOOR_HEIGHT;
            } else {
                // Nucleus lower ground floor different height to other floors
                referenceAltitude -= NUCLEUS_LOWER_GROUND;
            }
            return;
        }

        // Always calculate the altitude relative to ground floor = 0m altitude
        altitude = SensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE,
                barometerValue) - referenceAltitude;

        // Always update the floor
        updateFloor();
    }

    private final byte NUCLEUS = 0x0;   // Code representing the nucleus building
    private final byte LIBRARY = 0x1;   // Code representing the library building
    private byte floor; // The current floor of the user
    private byte building = NUCLEUS;    // The building code
    private final float FLOOR_ERROR = 1f;   // Allowed error in altitude
    private final float NUCLEUS_LOWER_GROUND = -3.0f;   // Relative altitude of nucleus LG floor
    // Update the floor depending on the altitude
    private void updateFloor() {
        // Constants to improve readability
        float GROUND = 0f;
        float FIRST = 5.0f;
        float SECOND = 10.0f;
        float THIRD = 15.0f;

        // Change the current floor depending on the building and the altitude
        switch (building) {
            case NUCLEUS:
                if (altitude > (NUCLEUS_LOWER_GROUND - FLOOR_ERROR) && altitude < (NUCLEUS_LOWER_GROUND + FLOOR_ERROR)) {
                    // Indicate user is on the lower ground floor
                    floor = -1;
                    // Extra 0.5f accounts for ramped area in cafeteria of Nucleus
                } else if (altitude > (GROUND - FLOOR_ERROR) && altitude < (GROUND + FLOOR_ERROR + 0.5f)) {
                    // Indicate user is on the ground floor
                    floor = 0;
                } else if (altitude > (FIRST - FLOOR_ERROR) && altitude < (FIRST + FLOOR_ERROR)) {
                    // Indicate user is on the first floor
                    floor = 1;
                } else if (altitude > (SECOND - FLOOR_ERROR) && altitude < (SECOND + FLOOR_ERROR)) {
                    // Indicate user is on the second floor
                    floor = 2;
                } else if (altitude > (THIRD - FLOOR_ERROR) && altitude < (THIRD + FLOOR_ERROR)) {
                    // Indicate user is on the third floor
                    floor = 3;
                }
                // Always update the floor spinner
                spinnerFloor.setSelection(floor+1);
                break;
            case LIBRARY:
                if (altitude > (GROUND - FLOOR_ERROR) && altitude < (GROUND + FLOOR_ERROR)) {
                    // Indicate user is on the ground floor
                    floor = 0;
                } else if (altitude > (FIRST - FLOOR_ERROR) && altitude < (FIRST + FLOOR_ERROR)) {
                    // Indicate user is on the first floor
                    floor = 1;
                } else if (altitude > (SECOND - FLOOR_ERROR) && altitude < (SECOND + FLOOR_ERROR)) {
                    // Indicate user is on the second floor
                    floor = 2;
                } else if (altitude > (THIRD - FLOOR_ERROR) && altitude < (THIRD + FLOOR_ERROR)) {
                    // Indicate user is on the third floor
                    floor = 3;
                }
                // Always update the floor spinner
                spinnerFloor.setSelection(floor);
                break;
            default:
                // Do nothing
                break;
        }
    }

    // Choose how to update the floorplan depending on the building
    private void updateFloorplan() {
        switch (building) {
            case NUCLEUS:
                switchNucleusFloorPlan();
                break;
            case LIBRARY:
                switchLibraryFloorPlan();
                break;
            default:
                // Keep image the same
        }
    }

    // Update the nucleus floorplan depending on the current floor
    private void switchNucleusFloorPlan(){
        switch (floor) {
            case -1:
                // Set image to lower ground floor nucleus
                ivMap.setImageResource(R.drawable.nucleuslg);
                break;
            case 0:
                // Set image to ground floor nucleus
                ivMap.setImageResource(R.drawable.nucleusg);
                break;
            case 1:
                // Set image to first floor nucleus
                ivMap.setImageResource(R.drawable.nucleus1);
                break;
            case 2:
                // Set image to second floor nucleus
                ivMap.setImageResource(R.drawable.nucleus2);
                break;
            case 3:
                // Set image to third floor nucleus
                ivMap.setImageResource(R.drawable.nucleus3);
                break;
            default:
                // Keep image the same
        }
    }

    // Update the library floorplan depending on the current floor
    private void switchLibraryFloorPlan(){
        switch (floor) {
            case 0:
                // Set image to ground floor library
                ivMap.setImageResource(R.drawable.libraryg);
                break;
            case 1:
                // Set image to first floor library
                ivMap.setImageResource(R.drawable.library1);
                break;
            case 2:
                // Set image to second floor library
                ivMap.setImageResource(R.drawable.library2);
                break;
            case 3:
                // Set image to third floor library
                ivMap.setImageResource(R.drawable.library3);
                break;
            default:
                // Keep image the same
        }
    }
}