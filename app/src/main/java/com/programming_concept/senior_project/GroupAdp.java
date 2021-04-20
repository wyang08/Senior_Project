package com.programming_concept.senior_project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupAdp extends RecyclerView.Adapter<GroupAdp.ViewHolder> {
    //Initialize activities and array list
    private Activity activity;
    ArrayList<String> arrayListGroup;

    //Create constructor
    GroupAdp(Activity activity,ArrayList<String> arrayListGroup){
        this.activity = activity;
        this.arrayListGroup = arrayListGroup;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_group,parent,false);
        return new GroupAdp.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Set group name on TextView
        holder.tvName.setText(arrayListGroup.get(position));

        //Initialize member ArrayList
        ArrayList<String> arrayListMember = new ArrayList<>();

        //Using for loop to add multiple members
        for (int i=1; i<=6; i++){
            arrayListMember.add("Member " + i);
        }

        //Initialize member adapter
        MemberAdp adapterMember = new MemberAdp(arrayListMember);

        //Initialize layout manager
        LinearLayoutManager layoutManagerMember = new LinearLayoutManager(activity);

        //Set layout manager
        holder.rvMember.setLayoutManager(layoutManagerMember);

        //Set adapter
        holder.rvMember.setAdapter(adapterMember);
    }

    @Override
    public int getItemCount() {
        return arrayListGroup.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize variable
        TextView tvName;
        RecyclerView rvMember;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            tvName = itemView.findViewById(R.id.tv_name);
            rvMember = itemView.findViewById(R.id.rv_member);
        }
    }
}
