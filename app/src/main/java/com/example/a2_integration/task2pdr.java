package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Objects;

public class task2pdr extends Fragment implements SensorEventListener {

    /************************Definition*********************/
    //________________________View_________________________//
    myCanvas trajectoryView;

    Spinner spinnerBuilding;
    Spinner spinnerFloor;

    ImageView ivMap;

    ToggleButton pdrToggleButton;
    Button pdrResetButton;

    // Get access to sensors
    private SensorManager mSensorManager;


    //________________________Var_________________________//
    private int displayHeight;
    private int displayWidth;

    private boolean doPDR = false;
    private boolean resetPDR = false;

    //Height offset from status bar needs to be cut for precise touch event on map canvas
    //Get status bar height here

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    int statusBarHeight;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task2pdr, container, false);

        trajectoryView = (myCanvas) view.findViewById(R.id.trajectoryView);
        spinnerBuilding = (Spinner) view.findViewById(R.id.spnBuilding);
        spinnerFloor = (Spinner) view.findViewById(R.id.spnFloor);
        ivMap = (ImageView) view.findViewById(R.id.ivMap);
        pdrToggleButton = (ToggleButton)view.findViewById(R.id.pdrToggle);
        pdrResetButton = (Button)view.findViewById(R.id.pdrReset);

        //Button Initialisation
        pdrToggleOnclick();
        pdrResetOnclick();

        //Spinner Initialisation
        spinnersInitialisation();

        //TouchEvent Initialisation
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent touchEvent) {

                if(touchEvent.getAction() == MotionEvent.ACTION_UP){
                    touchX = touchEvent.getX();
                    touchY = touchEvent.getY();
                }
                // Only register the initial position if PDR is not active
                // Remember to set this flag true when the resetPDR button is pressed

                    if (resetInitialPosition) {
                    // Set mapOrigin to the coordinates of the lower left of the canvas
                    trajectoryView.getLocationOnScreen(mapOrigin);
                    // Only register the initial position if the touch is on the map
                        float canvasWidth = trajectoryView.getWidth();
                        float canvasHeight = trajectoryView.getHeight();
                    if (touchX >= mapOrigin[0] && touchX <= (mapOrigin[0]+trajectoryView.getWidth())) {
                        float debug=touchY;
                        if (touchY >= displayHeight-trajectoryView.getHeight()) {
                            // Draw a marker at the initial position
                            float scaledTouchX = touchX-mapOrigin[0];
                            float scaledTouchY = displayHeight-touchY-statusBarHeight;
                            drawInitialPosition(scaledTouchX,scaledTouchY);
                        }
                    }
                }
                return true;
                //return super.onTouch(v, touchEvent);
            }
        });

        return view;
    }

    private void pdrResetOnclick(){
        pdrResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Long tap Reset button to reset whole PDR", Toast.LENGTH_SHORT).show();
            }
        });
        pdrResetButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Reset the PDR
                resetPDR();
                Toast.makeText(getContext(), "PDR has been successfully reset", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void pdrToggleOnclick(){
        pdrToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdrToggleButton.isChecked()){
                    // Initialise and start the PDR
                    startPDR();
                    Toast.makeText(getContext(), "pdr started", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Stop the PDR
                    stopPDR();
                    Toast.makeText(getContext(), "pdr stopped", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void spinnersInitialisation(){

        ArrayAdapter<CharSequence> adapterBuilding = ArrayAdapter.createFromResource(getContext(),R.array.Buildings,R.layout.layout_spinner_text);
        ArrayAdapter<CharSequence> adapterFloorNucleus = ArrayAdapter.createFromResource(getContext(),R.array.Floors_N,R.layout.layout_spinner_text);
        ArrayAdapter<CharSequence> adapterFloorLibrary = ArrayAdapter.createFromResource(getContext(),R.array.Floors_L,R.layout.layout_spinner_text);

        adapterBuilding.setDropDownViewResource(R.layout.layout_spinner_text);
        adapterFloorNucleus.setDropDownViewResource(R.layout.layout_spinner_text);
        adapterFloorLibrary.setDropDownViewResource(R.layout.layout_spinner_text);

        spinnerBuilding.setAdapter(adapterBuilding);
        spinnerFloor.setAdapter(adapterFloorNucleus);

        spinnerBuilding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

        spinnerFloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

        // Register the sensors
        Sensor StepDetector = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        if (StepDetector != null) {
            mSensorManager.registerListener(this, StepDetector,
                    SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            doToast("Step Detector not present.");
        }
    }

    private final float[] stepDetectorValues = new float[2];

    // Called when sensor values change
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // Convert step detector float output to boolean
            System.arraycopy(sensorEvent.values, 0, stepDetectorValues,
                    0, 1);
            stepDetectorValues[1] = sensorEvent.timestamp;
            onStepDetectorChanged();
        }
    }

    // Not used in this activity
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private float touchX;
    private float touchY;
    private int[] mapOrigin = new int[2];
    private boolean resetInitialPosition = true;
    private final float nucleusPixelsToMetres = 46.5f/1050f;
    private final float libraryPixelsToMetres = 21.5f/1050f;

    private void setInitialPosition() {
        // Capture the initialFloor from the floor spinner
        initialFloor = floor;
        // Convert touch position to real world position depending on the building
        switch (building) {
            case NUCLEUS:
                positionX = (touchX-mapOrigin[0])*nucleusPixelsToMetres;
                positionY = (displayHeight-touchY-statusBarHeight)*nucleusPixelsToMetres;
                break;
            case LIBRARY:
                positionX = (touchX-mapOrigin[0])*libraryPixelsToMetres;
                positionY = (displayHeight-touchY-statusBarHeight)*libraryPixelsToMetres;
                break;
            default:
                // Do nothing
        }
        // Store the initial position in the trajectory
        plotTrajectory(positionX,positionY);
        // Indicate initial position has been set
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
        // Remove the previous trajectory path
        trajectoryView.clearPoints();
        // Lock the spinners
        spinnerBuilding.setEnabled(false);
        spinnerFloor.setEnabled(false);
        // Capture the initial position and convert to real world coordinates
        setInitialPosition();
        // Set the doPDR flag to true
        doPDR = true;
    }

    // Called when the stopPDR toggle button is active
    public void stopPDR() {
        // Unlock the spinners
        spinnerBuilding.setEnabled(true);
        spinnerFloor.setEnabled(true);
        // Do not erase the trajectory, only do this when resetPDR is tapped
        // Ignore sensor updates
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

    private Toast mToast;
    private void doToast(String message) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(getContext(), message, Toast.LENGTH_LONG);
        mToast.show();
    }


    // These functions are triggered whenever a new value is sent from task1pdr.
    private final float[] rotationMatrixTranspose = new float[16];   // 4x4 so multiplyMV() can be applied
    private boolean resetAccMaxMin = true;
    private float accVerticalMax;
    private float accVerticalMin;
    private final float[] linearAccelerationPadded = new float[4];
    private final float[] accVerticalValues = new float[4];
    // Called when the accelerometer sensor values are updated

    public void setLinearAcceleration(float[] linearAcceleration, long accTimestamp) {
        // Ignore the sensor updates unless doPDR is true
        if (!doPDR) return;

        // Pad the accelerometer values into a 4-element vector for multiplyMV() method
        System.arraycopy(linearAcceleration, 0, linearAccelerationPadded, 0, 3);
        accVerticalValues[3] = 0;

        // Transform the acceleration from the device axes to global axes
        // Transpose is needed to convert row-major matrix to column-major matrix for opengl
        // Now the z-axis ie. accFilteredValues[2] should be perpendicular to the ground
        Matrix.transposeM(rotationMatrixTranspose,0,rotationMatrix,0);
        Matrix.multiplyMV(accVerticalValues, 0, rotationMatrixTranspose, 0,
                linearAccelerationPadded, 0);

        // Reset the max/min accelerations after a step is detected
        // They are reset to the first accelerometer reading of the next stride
        if (resetAccMaxMin) {
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
        // Ignore the sensor updates unless doPDR is true
        if (!doPDR) return;
        gravityValues = gravity;
        isGravityReady = true;  // Flag when the gravity sensor values are initialised
        calculateOrientation(); // Recalculate the orientation with the new values
    }

    private boolean resetGyro = true;
    private boolean isGyroReady = false;
    private float previousGyroTimestamp;
    private float gyroDeltaHeading;
    private float gyroHeading = 0f;
    // Calculate the change in device heading using the gyroscope
    public void setGyroscope(float[] gyroscopeValues, long gyrTimestamp) {
        // Ignore the sensor updates unless doPDR is true
        if (!doPDR) return;
        // Reset the gyroscope
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

        // Integrate the angular velocity around the z-axis over the time step to get the change in device heading
        // Convert angle between device heading and North to 0 > angle > 2*pi
        gyroDeltaHeading = -gyroscopeValues[2] * timestep;
        gyroHeading += -gyroscopeValues[2] * timestep;

        // Advance the previous timestamp
        previousGyroTimestamp = gyrTimestamp;

        // Flag when the gyroscope change in angle is initialised
        isGyroReady = true;

        // Update the device angle using sensor fusion
        sensorFusionHeading();
    }

    private float[] magnetometerValues = new float[3];
    private boolean isMagnetometerReady = false;
    // Called when the magnetometer sensor values are updated
    public void setMagnetometer(float [] magneticFieldValues, long magTimestamp) {
        // Ignore the sensor updates unless doPDR is true
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
        // Ignore the sensor updates unless doPDR is true
        if (!doPDR) return;
        barometerValue = barometerValues;
        // Reset the barometer initial values
        if (resetBarometer) {
            initialPressure = barometerValue;   // Get an initial pressure
            updateAltitude();   // Update the altitude before setting resetBarometer = false
            resetBarometer = false;  // Flag that the barometer initial value has been saved
            isBarometerReady = true;
            return;
        }

        // Update the altitude
        updateAltitude();

        // Update the floorplan depending on the altitude
        updateFloorplan();

        isBarometerReady = true;
    }

    public void setAmbientLight(float lightValue, long lightTimestamp) {
        // Do nothing
    }

    public void setProximity(float prxValue, long prxTimestamp) {
        // Do nothing
    }

    private float theta;
    private int strideCount = 0;

    // Called when step detector sensor values are updated
    public void onStepDetectorChanged() {
        // Ignore the sensor updates unless doPDR is true
        if (!doPDR) return;
        strideCount++; // Count the step
        weinbergSL();  // Calculate the stride length based on [Weinberg 2002]
        theta = heading;
        resetAccMaxMin = true; // Reset the accelerometer max/min on next call of onAccelerometerChanged()
        updatePosition();
    }

    private final float[] rotationMatrix = new float[16];   // 4x4 so multiplyMV() can be applied
    private final float[] orientationAngles = new float[3]; // Stores the azimuth, pitch and roll
    private boolean isCompassReady = false;
    private float compassHeading;
    // Calculate the orientation of the device using the gravity sensor and magnetometer
    private void calculateOrientation() {
        // Do not calculate the orientation until the gravity and magnetometer values are initialised
        if (!isGravityReady || !isMagnetometerReady) {
            return;
        }
        SensorManager.getRotationMatrix(rotationMatrix,null,gravityValues,magnetometerValues);
        SensorManager.getOrientation(rotationMatrix,orientationAngles);
        // Store the device heading based on the gravity and magnetometer sensors
        // Convert angle between device heading and North to 0 > angle > 2*pi
        compassHeading = orientationAngles[0];
        isCompassReady = true;  // Flag when the compass angle is initialised
    }

    private boolean resetHeading = true;
    private float heading;
    // Sensor fusion for heading using a complementary filter with tau = 0.49, fc ~= 0.32 Hz
    private void sensorFusionHeading() {
        float PI = (float) Math.PI;
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
        diff = (((heading + gyroDeltaHeading) - compassHeading + PI + (PI*2.0f)) % (PI*2.0f)) - PI;
        // heading is the sensor fusion heading
        // gyroDeltaHeading is the change in heading derived from the gyroscope
        // compassHeading is derived from the gravity and magnetometer sensors
        // heading = (0.98f) * (heading + gyroDeltaHeading) + (0.02f) * compassHeading;
        // Combine the headings returned by the compass and gyroscope using a weighted average
        heading = ((PI*2.0f) + compassHeading + (0.98f*diff)) % (PI*2.0f);
    }

    private float strideLength;
    // Estimate the step length, based on [Weinberg, 2002]
    private void weinbergSL() {
        //final float K = 0.364f; // Constant dependent on person and walking mode
        final float K = 0.65f; // Constant dependent on person and walking mode

        // Apply the Weinberg formula
        strideLength = (float) (Math.pow((accVerticalMax-accVerticalMin),(1.0/4))*K*K);
    }

    private float positionX;    // Position in the E direction
    private float positionY;    // Position in the N direction
    // Update the position based on SL+theta estimate
    private void updatePosition() {
        // Get new position from step length and heading
        positionX += (float) (strideLength*Math.sin(theta));
        positionY += (float) (strideLength*Math.cos(theta));
        // Plot the step on the trajectory
        // positionX (East) and positionY (North) already align with the on-screen map
        // coordinates x (Right) and y (Down) respectively
        plotTrajectory(positionX,positionY);
        //trajectoryView.addPoint(577,437);
    }

    // Plot the step on the canvas
    private void plotTrajectory(float x, float y) {
        switch (building) {
            case NUCLEUS:
                // Convert from metres to pixels
                trajectoryView.addPoint(x/nucleusPixelsToMetres,y/nucleusPixelsToMetres);
                break;
            case LIBRARY:
                // Convert from metres to pixels
                trajectoryView.addPoint(x/libraryPixelsToMetres,y/libraryPixelsToMetres);
                break;
        }
    }

    // Plot the initial position as a circle on the screen
    private void drawInitialPosition(float x, float y) {
        trajectoryView.drawInitialPosition(x,y);
    }

    private int initialFloor;
    private float referenceAltitude;
    private float altitude;
    // Update the altitude based on the barometer sensor
    private void updateAltitude() {
        // Assume 5m between floors
        final float FLOOR_HEIGHT = 5.0f;
        // Only update the initial altitude on the first call of onBarometerChanged()
        if (resetBarometer) {
            referenceAltitude = SensorManager.getAltitude(SensorManager.
                    PRESSURE_STANDARD_ATMOSPHERE, initialPressure);
            // Correct for the initial floor, so referenceAltitude is that of the ground floor
            // Assume 5m between floors
            if (initialFloor != -1) {
                referenceAltitude -= initialFloor*FLOOR_HEIGHT;
                // Nucleus lower ground floor different height to other floors
            } else {
                referenceAltitude -= NUCLEUS_LOWER_GROUND;
            }
            return;
        }
        // Calculate the altitude relative to ground floor = 0m altitude
        altitude = SensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE,
                barometerValue) - referenceAltitude;
        // Always update the floor
        updateFloor();
    }

    private final byte NUCLEUS = 0x0;
    private final byte LIBRARY = 0x1;
    private byte floor;
    private byte building= 0x0;
    private final float FLOOR_ERROR = 1f;
    private final float NUCLEUS_LOWER_GROUND = -3.0f;
    private final float GROUND = 0f;
    private final float NUCLEUS_FIRST = 5.0f;
    private final float NUCLEUS_SECOND = 10.0f;
    private final float NUCLEUS_THIRD = 15.0f;
    private final float LIBRARY_FIRST = 5.0f;
    private final float LIBRARY_SECOND = 10.0f;
    private final float LIBRARY_THIRD = 15.0f;

    // Update the floor depending on the altitude
    private void updateFloor() {
        switch (building) {
            case NUCLEUS:
                if (altitude > (NUCLEUS_LOWER_GROUND - FLOOR_ERROR) && altitude < (NUCLEUS_LOWER_GROUND + FLOOR_ERROR)) {
                    // Indicate user is on the lower ground floor
                    floor = -1;
                    // Extra 0.5f accounts for ramped area in cafeteria of Nucleus
                } else if (altitude > (GROUND - FLOOR_ERROR) && altitude < (GROUND + FLOOR_ERROR + 0.5f)) {
                    // Indicate user is on the ground floor
                    floor = 0;
                } else if (altitude > (NUCLEUS_FIRST - FLOOR_ERROR) && altitude < (NUCLEUS_FIRST + FLOOR_ERROR)) {
                    // Indicate user is on the first floor
                    floor = 1;
                } else if (altitude > (NUCLEUS_SECOND - FLOOR_ERROR) && altitude < (NUCLEUS_SECOND + FLOOR_ERROR)) {
                    // Indicate user is on the second floor
                    floor = 2;
                } else if (altitude > (NUCLEUS_THIRD - FLOOR_ERROR) && altitude < (NUCLEUS_THIRD + FLOOR_ERROR)) {
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
                } else if (altitude > (LIBRARY_FIRST - FLOOR_ERROR) && altitude < (LIBRARY_FIRST + FLOOR_ERROR)) {
                    // Indicate user is on the first floor
                    floor = 1;
                } else if (altitude > (LIBRARY_SECOND - FLOOR_ERROR) && altitude < (LIBRARY_SECOND + FLOOR_ERROR)) {
                    // Indicate user is on the second floor
                    floor = 2;
                } else if (altitude > (LIBRARY_THIRD - FLOOR_ERROR) && altitude < (LIBRARY_THIRD + FLOOR_ERROR)) {
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

    // Update the floorplan being displayed depending on the value of floor
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