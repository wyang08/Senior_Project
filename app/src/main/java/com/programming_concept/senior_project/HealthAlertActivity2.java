package com.programming_concept.senior_project;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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

//        for (int i= 1; i<=6; i++){
//            arrayListGroup.add("Group " + i);
//        }


        ArrayList<String> arrayListGroup = new ArrayList<>();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String UID = user.getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Course-ID-Section");


//         Get User for Course_ID_Section Collection
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String UID = user.getUid();
//
//                Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                Log.e("LOG_TAG", "Value:" + map);
//
//                assert map != null;
//                for (Map.Entry<String, Object> entry : map.entrySet()) {
//                    Log.e("The Result", entry.getKey());
//
//                    arrayListGroup.add(entry.getKey());
//
//                }
//                adapterGroup.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.e("LOG_TAG", "Failed to read value.", error.toException());
//            }
//        });


        // Get User for Course-ID-Section Collection

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String UID = user.getUid();

                for (DataSnapshot userlist: snapshot.getChildren()) {

//                    Debug

//                    Log.e("LOG_TAG", "UID: " + userlist.getKey());
//                    Log.e("LOG_TAG","Courses: " + userlist.getValue());
//

//                    for (DataSnapshot courseSnapshot: userlist.getChildren()) {
//                        Log.e("LOG_TAG","Courses: " + courseSnapshot.getValue());
//
//                        arrayListGroup.add(courseSnapshot.getValue(String.class));
//                    }

                    if (UID.equals(userlist.getKey())) {
                        for (DataSnapshot courseSnapshot: userlist.getChildren()) {
                            arrayListGroup.add(courseSnapshot.getValue(String.class));
                        }
                    }

                    adapterGroup.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("LOG_TAG", "Failed to read value.", error.toException());
            }
        });



        //Initialize group adapter
        adapterGroup = new GroupAdp(getActivity(), arrayListGroup);

        //Initialize layout manager
        layoutManagerGroup = new LinearLayoutManager(getActivity());

        //Set layout manager
        rvGroup.setLayoutManager(layoutManagerGroup);

        //Set adapter
        rvGroup.setAdapter(adapterGroup);
        return healthAlertFragment;
    }
}