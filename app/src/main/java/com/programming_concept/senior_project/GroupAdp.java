package com.programming_concept.senior_project;

import android.app.Activity;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

import javax.xml.transform.Result;

public class GroupAdp extends RecyclerView.Adapter<GroupAdp.ViewHolder> {
    //Initialize activities and array list
    private Activity activity;
    ArrayList<String> arrayListGroup;
    MemberAdp adapterMember;
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

//        Log.e("LOG_TAG", arrayListGroup.get(position));
//        Result:
//        E/LOG_TAG: CSCI-500-MO1
//        E/LOG_TAG: CSCI-110-MO1
//        E/LOG_TAG: CSCI-400-MO1
//        E/LOG_TAG: CSCI-200-MO1
//        E/LOG_TAG: CSCI-600-MO1
//        E/LOG_TAG: CSCI-300-MO1

//        if (arrayListGroup.get(position).equals())
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Course-Info");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//                Log.e("LOG_TAG", snapshot.getKey());
//                Result:
//                E/LOG_TAG: Course-Info

                for (DataSnapshot Courselist: snapshot.getChildren()) {

//                    Log.e("LOG_TAG", Courselist.getKey());

                    if (arrayListGroup.get(position).equals(Courselist.getKey())) {
//                        Log.e("LOG_TAG", "True");
                        for (DataSnapshot HealthStatus: Courselist.getChildren()) {
//                            Log.e("LOG_TAG", HealthStatus.getValue(String.class));
                            String condition = "Covid Positive";
                            if(condition.equals(HealthStatus.getValue())) {
                                Log.e("LOG_TAG", "True");
                                holder.tvName.setTextColor(Color.parseColor("#e60000"));
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //Initialize member ArrayList
        ArrayList<String> arrayListMember = new ArrayList<>();


        //Using for loop to add multiple members
//        for (int i=1; i<=6; i++){
//            arrayListMember.add("Member " + i);
//        }

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Course_ID_Section");
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String UID = user.getUid();
//
//                for (DataSnapshot courseSnapshot: snapshot.getChildren()) {
//                    for (DataSnapshot userSnapshot: courseSnapshot.getChildren()) {
//                        arrayListMember.add(userSnapshot.getValue(String.class));
////                        if(UID.equals(userSnapshot.getKey())) {
////                            arrayListMember.add(userSnapshot.getValue(String.class));
//                        }
//
////                    }
//
////                    for (DataSnapshot userSnapshot : courseSnapshot.getChildren()) {
////                        arrayListMember.add(userSnapshot.getValue(String.class));
////
////                        Log.e("LOG_TAG", userSnapshot.getValue(String.class));
////
////                        ArrayList<String> tempList = new ArrayList<>();
////                        tempList.add(userSnapshot.getValue(String.class));
////
////                        if (userSnapshot.getKey().contains(UID)) {
////                            for (int i = 0; i < tempList.size(); i++) {
////                                arrayListMember.add(tempList.get(i));
////                            }
////                        }
////                    }
//
//                }
//                adapterMember.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        //Initialize member adapter
        adapterMember = new MemberAdp(arrayListMember);

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


