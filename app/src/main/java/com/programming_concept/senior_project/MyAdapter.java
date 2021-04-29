package com.programming_concept.senior_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.time.chrono.MinguoChronology;
import java.util.List;

public class MyAdapter extends FirebaseRecyclerAdapter<User, MyAdapter.MyViewHolder> {

    public MyAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final User user) {
        holder.mStudentName.setText(user.getStudentName());
        holder.mId.setText(user.getId());
        holder.mVaccinationStatus.setText(user.getVaccinationStatus());
        holder.mVaccineName.setText(user.getVaccineName());
        //Glide.with(holder.img1.getContext()).load(model.getPurl()).into(holder.img1);

//        holder.img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity=(AppCompatActivity)view.getContext();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new descfragment(model.getName(),model.getCourse(),model.getEmail(),model.getPurl())).addToBackStack(null).commit();
//            }
//        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_list,parent,false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView mStudentName;
        TextView mId;
        TextView mVaccinationStatus;
        TextView mVaccineName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mStudentName = (TextView) itemView.findViewById(R.id.studentName_txtView);
            mId = (TextView) itemView.findViewById(R.id.id_txtView);
            mVaccinationStatus = (TextView) itemView.findViewById(R.id.vaccinationStatus_txtView);
            mVaccineName = (TextView) itemView.findViewById(R.id.vaccineName_txtView);
        }
    }

//    public MyAdapter(){
//
//    }
//
//    public MyAdapter(List<User> mUserList, List<String> mKeys){
//        this.mUserList = mUserList;
//        this.mKeys = mKeys;
//    }
//
//    @NonNull
//    @Override
//    public MyAdapter.StudentInfoView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_list, parent, false);
//        return new StudentInfoView(parent);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapter.StudentInfoView holder, int position) {
//        holder.bind(mUserList.get(position), mKeys.get(position));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mUserList.size();
//    }



    //ArrayList<User> model = new ArrayList<>();

//    public MyAdapter() {
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
//        User user = model.get(position);
//        holder.mStudentName.setText(user.getStudentName());
//        holder.mId.setText(user.getId());
//        holder.mVaccinationStatus.setText(user.getVaccinationStatus());
//        holder.mVaccineName.setText(user.getVaccineName());
//    }
//
//    @NonNull
//    @Override
//    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_list, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public int getItemCount() {
//        return model.size();
//    }
//    //private UsersAdapter mUsersAdapter;
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView mStudentName;
//        TextView mId;
//        TextView mVaccinationStatus;
//        TextView mVaccineName;
//
//        public ViewHolder(View view) {
//            super(view);
//            mStudentName = (TextView) itemView.findViewById(R.id.studentName_txtView);
//            mId = (TextView) itemView.findViewById(R.id.id_txtView);
//            mVaccinationStatus = (TextView) itemView.findViewById(R.id.vaccinationStatus_txtView);
//            mVaccineName = (TextView) itemView.findViewById(R.id.vaccineName_txtView);
//        }
//    }

//
//    public class StudentInfoView extends RecyclerView.ViewHolder{
//        private TextView mStudentName;
//        private TextView mId;
//        private TextView mVaccinationStatus;
//        private TextView mVaccineName;
//
//        private String key;
//
//        public StudentInfoView(View itemView){
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


