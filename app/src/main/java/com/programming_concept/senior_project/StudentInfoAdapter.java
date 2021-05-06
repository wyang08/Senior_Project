package com.programming_concept.senior_project;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentInfoAdapter extends FirebaseRecyclerAdapter<User, StudentInfoAdapter.MyViewHolder> {

    public StudentInfoAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MyViewHolder holder, int position, @NonNull final User user) {


        holder.mStudentName.setText(user.getStudentName());
        holder.mId.setText("ID:" + user.getStudentID());
        holder.mHealthStatus.setText(user.getHealthStatus());
        holder.mVaccinationStatus.setText("Status:" + user.getVaccinationStatus());
        holder.mVaccineName.setText(user.getVaccineName());
        holder.mDateFullyVaccinated.setText(user.getDateFullyVaccinated());
        //Glide.with(holder.img1.getContext()).load(user.getPdfUrl()).into(holder.img1);
        //holder.updateBtn.setEnabled(false);

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.img1.getContext(),ViewPdf.class);
                intent.putExtra("filename",user.getFileName());
                intent.putExtra("fileurl",user.getPdfUrl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.img1.getContext().startActivity(intent);
            }
        });

//        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (position == 1) {
//                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                    UpdateUserFragment updateUserFragment = new UpdateUserFragment();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_update_user, updateUserFragment).
//                            addToBackStack(null).commit();
//                }
//                }
//
//
////            public void replaceFragment(Fragment someFragment) {
////
////
////                Fragment updateFragment = new UpdateUserFragment();
////                FragmentTransaction transaction = getFragmentManager().beginTransaction();
////                transaction.replace(R.id.fragment_update_user, updateFragment); // give your fragment container id in first parameter
////                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
////                transaction.commit();
////
////            }
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
        ImageView img1;
        TextView mStudentName;
        TextView mId;
        TextView mHealthStatus;
        TextView mVaccinationStatus;
        TextView mVaccineName;
        TextView mDateFullyVaccinated;
        Button updateBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            img1=itemView.findViewById(R.id.img1);
            updateBtn = itemView.findViewById(R.id.updateBtn);
            mStudentName = (TextView) itemView.findViewById(R.id.studentName_txtView);
            mHealthStatus = (TextView) itemView.findViewById(R.id.healthStatus_txtView);
            mId = (TextView) itemView.findViewById(R.id.id_txtView);
            mVaccinationStatus = (TextView) itemView.findViewById(R.id.vaccinationStatus_txtView);
            mVaccineName = (TextView) itemView.findViewById(R.id.vaccineName_txtView);
            mDateFullyVaccinated = (TextView) itemView.findViewById(R.id.dateFullyVaccinated_txtView);



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


