package com.example.a2_integration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.ArrayList;

public class swipeAdaptor extends RecyclerView.Adapter<swipeAdaptor.swipeViewHolder> {


    private Context context;
    private ArrayList<String> mTrajectoryNum = new ArrayList<>();
    private ArrayList<String> mTrajectoryLocation = new ArrayList<>();
    private ArrayList<String> mTrajectoryTimestamp = new ArrayList<>();

    private final ViewBinderHelper viewBinderHelper= new ViewBinderHelper();

    public swipeAdaptor(Context context,ArrayList<String> trajectoryNum,
                        ArrayList<String> trajectoryLocation,ArrayList<String> trajectoryTimestamp){
        if(trajectoryNum != null) mTrajectoryNum = trajectoryNum;
        if(trajectoryLocation!= null) mTrajectoryLocation = trajectoryLocation;
        if(trajectoryTimestamp!= null) mTrajectoryTimestamp = trajectoryTimestamp;
        this.context = context;
    }

    public void setTrajectory(){
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public swipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_trajectoryview, parent, false);
        return new swipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull swipeViewHolder holder, int position) {

        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout,String.valueOf(mTrajectoryNum.get(position)));
        viewBinderHelper.closeLayout(String.valueOf(mTrajectoryNum.get(position)));

        holder.trajectoryNum.setText(mTrajectoryNum.get(position));
        holder.trajectoryLocation.setText(mTrajectoryLocation.get(position));
        holder.trajectoryTimestamp.setText(mTrajectoryTimestamp.get(position));


    }

    @Override
    public int getItemCount() {
        return mTrajectoryNum.size();
    }


    class swipeViewHolder extends RecyclerView.ViewHolder{

        private TextView trajectoryNum;
        private TextView trajectoryLocation;
        private  TextView trajectoryTimestamp;
        private TextView tvLoad;
        private  TextView tvDelete;

        private SwipeRevealLayout swipeRevealLayout;

        public swipeViewHolder(@NonNull View itemView) {
            super(itemView);

            trajectoryNum = itemView.findViewById(R.id.tvTrajectoryNum);
            trajectoryLocation = itemView.findViewById(R.id.tvTrajectoryLocation);
            trajectoryTimestamp = itemView.findViewById(R.id.tvTrajectoryTime);
            tvLoad = itemView.findViewById(R.id.tvLoad);
            tvDelete = itemView.findViewById(R.id.tvDelete);
            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);

            //Handling the click events
            tvLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Load this trajectory", Toast.LENGTH_SHORT).show();
                }
            });

            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Delete this trajectory", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
