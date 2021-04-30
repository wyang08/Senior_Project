package com.programming_concept.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class NewUserActivity extends AppCompatActivity {

    private EditText mStudentName_editTxt;
    private EditText mId_editTxt;
    private Spinner mVaccinationStatus_categories_spinner;
    private Spinner mVaccineName_categories_spinner;
    private Button mAdd_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        mStudentName_editTxt = (EditText) findViewById(R.id.studentName_editTxt);
        mId_editTxt = findViewById(R.id.id_editTxt);
        mVaccinationStatus_categories_spinner = (Spinner) findViewById(R.id.vaccinationStatus_spinner);
        mVaccineName_categories_spinner = (Spinner) findViewById(R.id.vaccineName_spinner);

        mAdd_btn = (Button) findViewById(R.id.addInfo_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setStudentName(mStudentName_editTxt.getText().toString());
                user.setId(mId_editTxt.getText().toString());
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

    }
}