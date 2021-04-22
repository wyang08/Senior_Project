package com.programming_concept.senior_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {

    EditText first_class, second_class, third_class, fourth_class, fifth_class, sixth_class;
    Button UploadButton;

    
    private ArrayList<String> class_schedule = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View schedule = inflater.inflate(R.layout.fragment_schedule, container, false);

        first_class = schedule.findViewById(R.id.first_class);
        second_class = schedule.findViewById(R.id.second_class);
        third_class = schedule.findViewById(R.id.third_class);
        fourth_class = schedule.findViewById(R.id.fourth_class);
        fifth_class = schedule.findViewById(R.id.fifth_class);
        sixth_class = schedule.findViewById(R.id.sixth_class);

        UploadButton = schedule.findViewById(R.id.schedule_upload);



        UploadButton.setOnClickListener(v -> {

            StoreInArray();


            for (int i = 0; i < class_schedule.size(); i++) {

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference("Course_ID_Section");

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String name = user.getDisplayName();
                    String UID = user.getUid();

                    DatabaseReference userRef = ref.child(class_schedule.get(i));

                    userRef.child(UID).setValue(name);

            }

        });


        return schedule;
    }

    private void StoreInArray() {

        class_schedule.add(first_class.getText().toString());
        class_schedule.add(second_class.getText().toString());
        class_schedule.add(third_class.getText().toString());
        class_schedule.add(fourth_class.getText().toString());
        class_schedule.add(fifth_class.getText().toString());
        class_schedule.add(sixth_class.getText().toString());
    }

}
