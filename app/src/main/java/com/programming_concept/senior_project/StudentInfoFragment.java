package com.programming_concept.senior_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class StudentInfoFragment extends Fragment {
    RecyclerView mRecyclerView;

    private ArrayList<User> dataholder;
    StudentInfoAdapter adapter;
    //MenuItem menuItem;
    Button updateBtn;



    public StudentInfoFragment() {
        // Required empty public constructor
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        //inflate menu
//       inflater.inflate(R.menu.student_info_menu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        //handles menu item clicks
//
//        switch (item.getItemId()) {
//            case R.id.activity_update_data:
//                Intent intent = new Intent(getActivity(), UpdateUserFragment.class);
//                startActivity(intent);
////                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View StudentFragment = inflater.inflate(R.layout.fragment_student_info, container, false);

        mRecyclerView = (RecyclerView) StudentFragment.findViewById(R.id.recyclerview_studentInfo);
        //Button updateBtn = StudentFragment.findViewById(R.id.updateBtn);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference ref = database.getReference("Vaccination Record");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = database.getReference("/Vaccination Record");
        DatabaseReference userRef = ref.child("Student ID");
        String name = user.getDisplayName();
        String UID = user.getUid();

        Query keyQuery = FirebaseDatabase.getInstance().getReference("/Course_ID_Section/CSCI-110-M01");
//        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("/Vaccination Record/Student ID");


        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setIndexedQuery(keyQuery, userRef, User.class)
                        .build();

        adapter = new StudentInfoAdapter(options);
        mRecyclerView.setAdapter(adapter);


        return StudentFragment;
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
//

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