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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //String name = user.getDisplayName();
        String UID = user.getUid();


        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Vaccination Record").child("Student ID"), User.class)
                        .build();

        adapter = new StudentInfoAdapter(options);
        mRecyclerView.setAdapter(adapter);

//        updateBtn.setOnClickListener((View.OnClickListener) this);


//        new FirebaseDatabaseHelper().readUserInfo(new FirebaseDatabaseHelper.DataStatus() {
//            @Override
//            public void DataIsLoaded(List<User> users, List<String> keys) {
//                new MyAdapter(users);
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

        return StudentFragment;
    }

//    public void onClick(View view) {
//        Fragment fragment = null;
//        switch (view.getId()) {
//            case R.id.fragment_update_user:
//                fragment = new UpdateUserFragment();
//                replaceFragment(fragment);
//                break;
//
//        }
//    }
//    public void replaceFragment(Fragment someFragment) {
//
//        Fragment updateFragment = new UpdateUserFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_update_user, updateFragment); // give your fragment container id in first parameter
//        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//        transaction.commit();
//
//    }

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