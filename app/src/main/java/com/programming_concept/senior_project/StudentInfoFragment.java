package com.programming_concept.senior_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoFragment extends Fragment {
    RecyclerView mRecyclerView;
    //private ArrayList<User> dataholder;
    MyAdapter adapter;



    public StudentInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View StudentFragment = inflater.inflate(R.layout.fragment_student_info, container, false);

        mRecyclerView = (RecyclerView) StudentFragment.findViewById(R.id.recyclerview_studentInfo);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("MXj67_202HdcvvXrwYb"), User.class)
                        .build();

        adapter = new MyAdapter(options);
        mRecyclerView.setAdapter(adapter);

//        new FirebaseDatabaseHelper().readUserInfo(new FirebaseDatabaseHelper.DataStatus() {
//            @Override
//            public void DataIsLoaded(List<User> users, List<String> keys) {
//                new MyAdapter().setConfig(mRecyclerView, getActivity(), users, keys);
//            }
//
//            @Override
//            public void DataIsInserted() {
//
//            }
//
//            @Override
//            public void DataIsUpdated() {
//
//            }
//
//            @Override
//            public void DataIsDeleted() {
//
//            }
//        });

        return inflater.inflate(R.layout.fragment_student_info, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    

//    private void setOnClickListener() {
//        listener = new recyclerAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//                Intent intent = new Intent(getActivity().getApplicationContext(), HealthAlertActivity.class);
//                intent.putExtra("username", usersList.get(position).getStudentName());
//                startActivity(intent);
//            }
//        };
//    }
//
//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        ge
//        super.onCreateOptionsMenu(menu, inflater);
//    }
}