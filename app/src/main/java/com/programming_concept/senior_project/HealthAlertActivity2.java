package com.programming_concept.senior_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HealthAlertActivity2 extends Fragment {

    //Initialize variable
    RecyclerView rvGroup;
    ArrayList<String> arrayListGroup;
    LinearLayoutManager layoutManagerGroup;
    GroupAdp adapterGroup;

    //@Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View healthAlertFragment = inflater.inflate(R.layout.healthalert_activity2, container, false);


        //Assign variable
        rvGroup = healthAlertFragment.findViewById(R.id.rv_group);

        //Using for loop to add multiple group
        //Used for dummy display for now
        arrayListGroup = new ArrayList<>();
        for (int i= 1; i<=6; i++){
            arrayListGroup.add("Group " + i);
        }

        //Initialize group adapter
        adapterGroup = new GroupAdp(getActivity(),arrayListGroup);

        //Initialize layout manager
        layoutManagerGroup = new LinearLayoutManager(getActivity());

        //Set layout manager
        rvGroup.setLayoutManager(layoutManagerGroup);

        //Set adapter
        rvGroup.setAdapter(adapterGroup);
        return healthAlertFragment;
    }
}