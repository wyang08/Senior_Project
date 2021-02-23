package com.programming_concept.senior_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HealthAlertFragment extends Fragment {

    private ArrayList<User> usersList;
    private RecyclerView recyclerView;

//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View inflate = inflater.inflate(R.layout.fragmnet_health_alert, container, false);
//        return inflate;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View health_frag_view = inflater.inflate(R.layout.fragmnet_health_alert, container, false);
        
        recyclerView = health_frag_view.findViewById(R.id.recyclerView);

        usersList = new ArrayList<>();
        setUserInfo();
        setAdapter();
        return health_frag_view;
    }
    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo(){

        usersList.add(new User("Francis"));
        usersList.add(new User("Wentao"));
        usersList.add(new User("David"));
        usersList.add(new User("Shane"));
        usersList.add(new User("Robert"));
    }
}