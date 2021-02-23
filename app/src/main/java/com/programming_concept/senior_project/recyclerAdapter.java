package com.programming_concept.senior_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewHolder> {
    private ArrayList<User> usersList;

    public recyclerAdapter(ArrayList<User> usersList){
        this.usersList = usersList;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;

        public myViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.textView4);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_alerts_list, parent, false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.myViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
        holder.nameTxt.setText(name);

    }

    @Override
    public int getItemCount() {
        return usersList.size();

    }
}
