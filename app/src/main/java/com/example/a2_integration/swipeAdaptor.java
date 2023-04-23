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

/** This is an adaptor for the swipe recyclerview as part of the task3api UI.
 *  Author: Peggy Pei
 *
 *  Features:
 *  - View all recorded trajectories
 *  - Swipe left to access "Delete", "Upload" and "Load" buttons
 */

public class swipeAdaptor extends RecyclerView.Adapter<swipeAdaptor.swipeViewHolder> {
    /***************** Initialisation *************************/

    //Define the interface for button click listener
    public interface OnBtnDeleteClickListener {
        void onDeleteClick( int position);
    }
    public interface OnBtnLoadClickListener {
        void onLoadClick( int position);
    }
    public interface OnBtnUploadClickListener {
        void onUploadClick( int position);
    }

    private OnBtnDeleteClickListener btnDeleteListener;
    private OnBtnLoadClickListener btnLoadListener;
    private OnBtnUploadClickListener btnUploadListener;

    private Context context;
    private ArrayList<String> mTrajectoryNum = new ArrayList<>();
    private ArrayList<String> mTrajectoryLocation = new ArrayList<>();
    private ArrayList<String> mTrajectoryTimestamp = new ArrayList<>();

    private final ViewBinderHelper viewBinderHelper= new ViewBinderHelper();

    /***************** Adaptor structure *************************/

    public swipeAdaptor(Context context,ArrayList<String> trajectoryNum,
                        ArrayList<String> trajectoryLocation,ArrayList<String> trajectoryTimestamp,
                        OnBtnDeleteClickListener btnDelete, OnBtnLoadClickListener btnLoad,
                        OnBtnUploadClickListener btnUpload){
        if(trajectoryNum != null) mTrajectoryNum = trajectoryNum;
        if(trajectoryLocation!= null) mTrajectoryLocation = trajectoryLocation;
        if(trajectoryTimestamp!= null) mTrajectoryTimestamp = trajectoryTimestamp;
        if(btnDelete != null) btnDeleteListener = btnDelete;
        if(btnDelete != null) btnLoadListener = btnLoad;
        if(btnUpload != null) btnUploadListener = btnUpload;
        this.context = context;
    }

    public void setTrajectory(){
        notifyDataSetChanged();
    }

    /***************** View holder methods *************************/

    @NonNull
    @Override
    public swipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_trajectoryview,
                parent, false);
        return new swipeViewHolder(view,btnDeleteListener,btnLoadListener,btnUploadListener);
    }

    @Override
    public void onBindViewHolder(@NonNull swipeViewHolder holder, int position) {
        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout,String.valueOf(mTrajectoryNum.
                get(position)));
        viewBinderHelper.closeLayout(String.valueOf(mTrajectoryNum.get(position)));

        holder.trajectoryNum.setText(mTrajectoryNum.get(position));
        holder.trajectoryLocation.setText(mTrajectoryLocation.get(position));
        holder.trajectoryTimestamp.setText(mTrajectoryTimestamp.get(position));

        holder.tvDelete.setTag(position);
        holder.tvLoad.setTag(position);
        holder.tvUpload.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mTrajectoryNum.size();
    }

    /***************** View holder Customisation *************************/

    class swipeViewHolder extends RecyclerView.ViewHolder{
        private TextView trajectoryNum;
        private TextView trajectoryLocation;
        private  TextView trajectoryTimestamp;
        private TextView tvLoad;
        private  TextView tvDelete;
        private  TextView tvUpload;

        private SwipeRevealLayout swipeRevealLayout;

        OnBtnLoadClickListener loadClickListener;
        OnBtnDeleteClickListener deleteClickListener;
        OnBtnUploadClickListener uploadClickListener;

        public swipeViewHolder(@NonNull View itemView,
                               OnBtnDeleteClickListener btnDeleteClickListener,
                               OnBtnLoadClickListener btnLoadClickListener,
                               OnBtnUploadClickListener btnUploadClickListener) {
            super(itemView);

            trajectoryNum = itemView.findViewById(R.id.tvTrajectoryNum);
            trajectoryLocation = itemView.findViewById(R.id.tvTrajectoryLocation);
            trajectoryTimestamp = itemView.findViewById(R.id.tvTrajectoryTime);
            tvLoad = itemView.findViewById(R.id.tvLoad);
            tvDelete = itemView.findViewById(R.id.tvDelete);
            tvUpload = itemView.findViewById(R.id.tvUpload);
            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);

            this.deleteClickListener=btnDeleteClickListener;
            this.loadClickListener=btnLoadClickListener;
            this.uploadClickListener = btnUploadClickListener;

            tvUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadClickListener.onUploadClick(getAdapterPosition());
                    Toast.makeText(context, "Upload Trajectory Started", Toast.LENGTH_SHORT).
                            show();
                }
            });
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
                    deleteClickListener.onDeleteClick(getAdapterPosition());
                    Toast.makeText(context, "Delete this trajectory", Toast.LENGTH_SHORT).
                            show();
                }
            });
        }
    }
}
