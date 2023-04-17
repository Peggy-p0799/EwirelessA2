package com.example.a2_integration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class task3api extends Fragment {

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
}