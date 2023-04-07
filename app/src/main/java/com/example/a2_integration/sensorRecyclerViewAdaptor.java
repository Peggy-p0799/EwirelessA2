package com.example.a2_integration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class sensorRecyclerViewAdaptor extends RecyclerView.Adapter<sensorRecyclerViewAdaptor.ViewHolder>{

    /***************** Initialisation *************************/

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mSensorNames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mSensorResolution = new ArrayList<>();
    private ArrayList<String> mSensorMinDelay = new ArrayList<>();
    private ArrayList<String> mSensorPower = new ArrayList<>();
    private ArrayList<String> mSensorRange = new ArrayList<>();
    private Context mContext;

    //Define the interface for button click listener

    public interface OnButton1ClickListener {
        void onButton1Click( int position);
    }
    public interface OnButton2ClickListener {
        void onButton2Click( int position);
    }

    private OnButton1ClickListener button1Listener;
    private OnButton2ClickListener button2Listener;

    /***************** Adaptor structure *************************/

    public sensorRecyclerViewAdaptor(Context context, ArrayList<Integer> images, ArrayList<String> sensorNames,
                                     ArrayList<String> sensorResolution, ArrayList<String> sensorMinDelay,
                                     ArrayList<String> sensorPower, ArrayList<String> sensorRange,
                                     OnButton1ClickListener btnStart, OnButton2ClickListener btnStop) {
        if(images != null) mImages = images;
        if(sensorNames != null) mSensorNames = sensorNames;
        if(sensorResolution != null) mSensorResolution = sensorResolution;
        if(sensorResolution != null) mSensorMinDelay = sensorMinDelay;
        if(sensorPower != null) mSensorPower = sensorPower;
        if(sensorRange != null) mSensorRange = sensorRange;
        mContext = context;
        if(btnStart !=null) button1Listener = btnStart;
        if(btnStop != null) button2Listener = btnStop;
    }

    /***************** View holder methods *************************/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sensorlist, parent, false);
        ViewHolder holder = new ViewHolder(view,button1Listener,button2Listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.sensorImage.setImageResource(mImages.get(position));

        holder.sensorName.setText(mSensorNames.get(position));
        holder.sensorResolution.setText(mSensorResolution.get(position));
        holder.sensorMinDelay.setText(mSensorMinDelay.get(position));
        holder.sensorPower.setText(mSensorPower.get(position));
        holder.sensorRange.setText(mSensorRange.get(position));

        holder.sensorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mSensorNames.get(position));

                Toast.makeText(mContext, mSensorNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return mSensorNames.size();
    }

    /***************** View holder Customisation *************************/

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView sensorImage;
        TextView sensorName,sensorResolution,sensorMinDelay,sensorPower,sensorRange;
        Button btPlot,btStop;

        OnButton1ClickListener startPlotListener;
        OnButton2ClickListener stopPlotListener;


        public ViewHolder( View itemView, OnButton1ClickListener button1Listener, OnButton2ClickListener button2Listener) {
            super(itemView);
            sensorImage = itemView.findViewById(R.id.imageSensor);
            sensorName = itemView.findViewById(R.id.tvSensorName);
            sensorResolution = itemView.findViewById(R.id.tvSensorResolution);
            sensorMinDelay = itemView.findViewById(R.id.tvSensorMinDelay);
            sensorPower = itemView.findViewById(R.id.tvSensorPower);
            sensorRange = itemView.findViewById(R.id.tvSensorRange);
            btPlot = itemView.findViewById(R.id.btPlot);
            btStop = itemView.findViewById(R.id.btStop);

            this.startPlotListener = button1Listener;
            this.stopPlotListener = button2Listener;

            btPlot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPlotListener.onButton1Click(getAbsoluteAdapterPosition());
                }
            });
            btStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopPlotListener.onButton2Click(getAbsoluteAdapterPosition());
                }
            });
        }

    }
}
