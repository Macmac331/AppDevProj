package com.example.finalappdevproj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MissionVisionAdapter extends RecyclerView.Adapter<MissionVisionAdapter.MyViewHolder> {
    private final List<MissionVisionData> missionVisionList;

    public MissionVisionAdapter(List<MissionVisionData> missionVisionList) {
        this.missionVisionList = missionVisionList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.missionvisiondata, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        MissionVisionData missionVisionData = missionVisionList.get(position);
        viewHolder.titleTextView.setText(missionVisionData.getTitle());
        viewHolder.descriptionTextView.setText(missionVisionData.getDescription());
    }

    @Override
    public int getItemCount() {
        return missionVisionList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }

}