package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class task2pdr extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task2pdr, container, false);

        Spinner spinner_building = (Spinner) view.findViewById(R.id.spnBuilding);
        Spinner spinner_floor = (Spinner) view.findViewById(R.id.spnFloor);

        ArrayAdapter<CharSequence> buildingAdapter = ArrayAdapter.createFromResource(getContext(),R.array.Buildings,R.layout.layout_spinner_text);
        ArrayAdapter<CharSequence> floorAdapter = ArrayAdapter.createFromResource(getContext(),R.array.Floors_N,R.layout.layout_spinner_text);

        buildingAdapter.setDropDownViewResource(R.layout.layout_spinner_text);
        floorAdapter.setDropDownViewResource(R.layout.layout_spinner_text);

        spinner_building.setAdapter(buildingAdapter);
        spinner_floor.setAdapter(floorAdapter);

        return view;
    }


    // These functions are triggered whenever a new value is sent from task1pdr.

    public void setLinearAcceleration(float[] linearAcceleration, long accTimestamp) {

    }

    public void setGravity(float[] gravity, long accTimestamp) {

    }

    public void setGyroscope(float[] gyrValues, long gyrTimestamp) {

    }

    public void setMagnetometer(float [] magneticFieldValues, long magTimestamp) {

    }

    public void setPressure(float barValue, long barTimestamp) {

    }

    public void setAmbientLight(float lightValue, long lightTimestamp) {

    }

    public void setProximity(float prxValue, long prxTimestamp) {

    }


}