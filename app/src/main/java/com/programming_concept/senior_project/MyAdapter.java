package com.programming_concept.senior_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class MyAdapter extends FirebaseRecyclerAdapter<User, MyAdapter.myViewHolder> {
    //private Context mContext;

    public MyAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull User model) {
        holder.mStudentName.setText(model.getStudentName());
        holder.mId.setText(model.getId());
        holder.mVaccinationStatus.setText(model.getVaccinationStatus());
        holder.mVaccineName.setText(model.getVaccineName());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_list, parent, false);
        return new myViewHolder(view);
    }
    //private UsersAdapter mUsersAdapter;

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView mStudentName;
        TextView mId;
        TextView mVaccinationStatus;
        TextView mVaccineName;

        public myViewHolder(@NonNull View itemView){
            super (itemView);
            mStudentName = (TextView) itemView.findViewById(R.id.studentName_txtView);
            mId = (TextView) itemView.findViewById(R.id.id_txtView);
            mVaccinationStatus = (TextView) itemView.findViewById(R.id.vaccinationStatus_txtView);
            mVaccineName = (TextView) itemView.findViewById(R.id.vaccineName_txtView);
        }
    }


//    public void setConfig(RecyclerView recyclerView, Context context, List<User> users, List<String> keys){
//        mContext = context;
//        mUsersAdapter = new UsersAdapter(users, keys);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.setAdapter(mUsersAdapter);
//    }

//    public class StudentInfoView extends RecyclerView.ViewHolder{
//        private TextView mStudentName;
//        private TextView mId;
//        private TextView mVaccinationStatus;
//        private TextView mVaccineName;
//
//        private String key;
//
//        public studentViewHolder(View itemView){
//            super (itemView);
//
//
//            mStudentName = (TextView) itemView.findViewById(R.id.studentName_txtView);
//            mId = (TextView) itemView.findViewById(R.id.id_txtView);
//            mVaccinationStatus = (TextView) itemView.findViewById(R.id.vaccinationStatus_txtView);
//            mVaccineName = (TextView) itemView.findViewById(R.id.vaccineName_txtView);
//
//        }
//        public void bind(User user, String key){
//            mStudentName.setText(user.getStudentName());
//            mId.setText(user.getId());
//            mVaccinationStatus.setText(user.getVaccinationStatus());
//            mVaccineName.setText(user.getVaccineName());
//            this.key = key;
//        }
//    }
//    class UsersAdapter extends RecyclerView.Adapter<StudentInfoView>{
//        private List<User> mUserList;
//        private List<String> mKeys;
//
//        public UsersAdapter(List<User> mUserList, List<String> mKeys){
//            this.mUserList = mUserList;
//            this.mKeys = mKeys;
//        }
//
//        @NonNull
//        @Override
//        public StudentInfoView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_list, parent, false);
//            return new StudentInfoView((ViewGroup) itemView);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull StudentInfoView holder, int position) {
//            holder.bind(mUserList.get(position), mKeys.get(position));
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return mUserList.size();
//        }
//    }
}
