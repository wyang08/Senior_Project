package com.programming_concept.senior_project;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class UpdateUserFragment extends Fragment {

    private EditText mStudentName_editTxt;
    private EditText mId_editTxt;
    private Spinner mVaccinationStatus_categories_spinner;
    private Spinner mVaccineName_categories_spinner;
    private Button mAdd_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View updateFragment = inflater.inflate(R.layout.fragment_update_user, container, false);

        mStudentName_editTxt = (EditText) updateFragment.findViewById(R.id.studentName_editTxt);
        mId_editTxt = updateFragment.findViewById(R.id.id_editTxt);
        mVaccinationStatus_categories_spinner = (Spinner) updateFragment.findViewById(R.id.vaccinationStatus_spinner);
        mVaccineName_categories_spinner = (Spinner) updateFragment.findViewById(R.id.vaccineName_spinner);

        mAdd_btn = (Button) updateFragment.findViewById(R.id.addInfo_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setStudentName(mStudentName_editTxt.getText().toString());
                user.setStudentID(mId_editTxt.getText().toString());
                user.setVaccinationStatus(mVaccinationStatus_categories_spinner.getSelectedItem().toString());
                user.setVaccineName(mVaccineName_categories_spinner.getSelectedItem().toString());

//                new FirebaseDatabaseHelper().addUser(user, new FirebaseDatabaseHelper.DataStatus() {
//                    @Override
//                    public void DataIsLoaded(List<User> users, List<String> Keys) {
//
//                    }
//
//                    @Override
//                    public void DataIsInserted() {
//                        Toast.makeText(NewUserActivity.this, "Your information has been uploaded successfully", Toast.LENGTH_LONG).show();
//
//                    }
//
//                    @Override
//                    public void DataIsUpdated() {
//
//                    }
//
//                    @Override
//                    public void DataIsDeleted() {
//
//                    }
//                });
            }
        });

        return updateFragment;

    }
}