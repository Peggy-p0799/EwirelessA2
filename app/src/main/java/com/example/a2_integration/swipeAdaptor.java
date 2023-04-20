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


    //Define the interface for button click listener

    public interface OnBtnDeleteClickListener {
        void onDeleteClick( int position);
    }
    public interface OnBtnLoadClickListener {
        void onLoadClick( int position);
    }

    private OnBtnDeleteClickListener btnDeleteListener;
    private OnBtnLoadClickListener btnLoadListener;

    private Context context;
    private ArrayList<String> mTrajectoryNum = new ArrayList<>();
    private ArrayList<String> mTrajectoryLocation = new ArrayList<>();
    private ArrayList<String> mTrajectoryTimestamp = new ArrayList<>();

    private final ViewBinderHelper viewBinderHelper= new ViewBinderHelper();

    public swipeAdaptor(Context context,ArrayList<String> trajectoryNum,
                        ArrayList<String> trajectoryLocation,ArrayList<String> trajectoryTimestamp,
                        OnBtnDeleteClickListener btnDelete, OnBtnLoadClickListener btnLoad){
        if(trajectoryNum != null) mTrajectoryNum = trajectoryNum;
        if(trajectoryLocation!= null) mTrajectoryLocation = trajectoryLocation;
        if(trajectoryTimestamp!= null) mTrajectoryTimestamp = trajectoryTimestamp;
        if(btnDelete != null) btnDeleteListener = btnDelete;
        if(btnDelete != null) btnLoadListener = btnLoad;
        this.context = context;
    }

    public void setTrajectory(){
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public swipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_trajectoryview, parent, false);
        return new swipeViewHolder(view,btnDeleteListener,btnLoadListener);
    }

    @Override
    public void onBindViewHolder(@NonNull swipeViewHolder holder, int position) {

        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout,String.valueOf(mTrajectoryNum.get(position)));
        viewBinderHelper.closeLayout(String.valueOf(mTrajectoryNum.get(position)));

        holder.trajectoryNum.setText(mTrajectoryNum.get(position));
        holder.trajectoryLocation.setText(mTrajectoryLocation.get(position));
        holder.trajectoryTimestamp.setText(mTrajectoryTimestamp.get(position));

        holder.tvDelete.setTag(position);
        holder.tvLoad.setTag(position);


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

        OnBtnLoadClickListener loadClickListener;
        OnBtnDeleteClickListener deleteClickListener;

        public swipeViewHolder(@NonNull View itemView,OnBtnDeleteClickListener btnDeleteClickListener,
                               OnBtnLoadClickListener btnLoadClickListener) {
            super(itemView);

            trajectoryNum = itemView.findViewById(R.id.tvTrajectoryNum);
            trajectoryLocation = itemView.findViewById(R.id.tvTrajectoryLocation);
            trajectoryTimestamp = itemView.findViewById(R.id.tvTrajectoryTime);
            tvLoad = itemView.findViewById(R.id.tvLoad);
            tvDelete = itemView.findViewById(R.id.tvDelete);
            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);

            this.deleteClickListener=btnDeleteClickListener;
            this.loadClickListener=btnLoadClickListener;

            //Handling the click events
            tvLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadClickListener.onLoadClick(getAdapterPosition());
                    Toast.makeText(context, "Load this trajectory", Toast.LENGTH_SHORT).show();
                }
            });

            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    if (position >= 0 && position < mTrajectoryNum.size()){
                        mTrajectoryNum.remove(position);
                        mTrajectoryLocation.remove(position);
                        mTrajectoryTimestamp.remove(position);
                        notifyItemRemoved(position);
                    }
                    deleteClickListener.onDeleteClick(getAdapterPosition());
                    Toast.makeText(context, "Delete this trajectory", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}