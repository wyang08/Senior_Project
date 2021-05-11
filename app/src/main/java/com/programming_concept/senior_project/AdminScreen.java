package com.programming_concept.senior_project;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminScreen extends AppCompatActivity {
    Button upload;
    EditText user_name, vaccine, date ;
    ImageView imgview;
    FirebaseAuth mAuth;

    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);
        upload = (Button) findViewById(R.id.btnadd);


        user_name = (EditText)findViewById(R.id.user_name);
        vaccine = (EditText)findViewById(R.id.user_vaccine);
        date = (EditText)findViewById(R.id.user_date);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mRef = database.getReference("Test");


        FirebaseUser user = mAuth.getCurrentUser();


        upload.setOnClickListener(v -> {
            VaccinationRecord vaccinationRecord = new VaccinationRecord();
            vaccinationRecord.setName(user_name.getText().toString());
            vaccinationRecord.setVaccine(vaccine.getText().toString());
            vaccinationRecord.setDate(date.getText().toString());
            mRef.setValue(vaccinationRecord);
        });

    }


}
