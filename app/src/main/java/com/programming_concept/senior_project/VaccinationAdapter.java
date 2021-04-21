package com.programming_concept.senior_project;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class VaccinationAdapter extends RecyclerView.Adapter<VaccinationAdapter.ViewHolder> {


    ArrayList<VaccinationTimeline> recentRecords = new ArrayList<>();

    public VaccinationAdapter() {

    }

    public void updateRecords(ArrayList<VaccinationTimeline> recentRecords) {
        this.recentRecords = recentRecords;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public VaccinationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_vaccination_record,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VaccinationAdapter.ViewHolder holder, int position) {
        VaccinationTimeline recentRecord = recentRecords.get(position);
        holder.tvTimeline.setText(recentRecord.getmDate() + ":");
        holder.tvCount.setText(String.valueOf(recentRecord.getmCount()));
    }

    @Override
    public int getItemCount() {
//        return recentRecords.size();
        return recentRecords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTimeline;
        TextView tvCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTimeline = itemView.findViewById(R.id.tvTimeline);
            tvCount = itemView.findViewById(R.id.tvCount);
        }
    }
}
