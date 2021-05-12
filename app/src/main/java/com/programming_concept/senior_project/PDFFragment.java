package com.programming_concept.senior_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.type.Date;

import static android.app.Activity.RESULT_OK;

public class PDFFragment extends Fragment {

    EditText image_url, user_name, studentID, vaccineDate;
    Spinner healthStatus_spinner, vaccinationStatus_spinner, vaccineName_spinner;
    ImageView file_logo, cancel_file, file_search;
    Button UploadButton;

//    private FirebaseAuth mAuth;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View pdfFragment = inflater.inflate(R.layout.fragmnet_pdf, container, false);

        image_url = pdfFragment.findViewById(R.id.image_url);


        //user_name = pdfFragment.findViewById(R.id.user_name); name.getCurrentUser() from Firebase Auth will be used to retrieve user name and set it as such in Firebase
        studentID = pdfFragment.findViewById(R.id.user_ID);
        vaccineDate = pdfFragment.findViewById(R.id.vaccineDate);
        healthStatus_spinner = (Spinner) pdfFragment.findViewById(R.id.healthStatus_spinner);
        vaccinationStatus_spinner = (Spinner) pdfFragment.findViewById(R.id.vaccinationStatus_spinner);
        vaccineName_spinner = (Spinner) pdfFragment.findViewById(R.id.vaccineName_spinner);

        UploadButton = pdfFragment.findViewById(R.id.submit_pdf);

        file_logo= pdfFragment.findViewById(R.id.file_logo);
        file_search= pdfFragment.findViewById(R.id.file_search);
        cancel_file= pdfFragment.findViewById(R.id.cancel_file);

        file_logo.setVisibility(View.INVISIBLE);
        cancel_file.setVisibility(View.INVISIBLE);

        cancel_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                file_logo.setVisibility(View.INVISIBLE);
                cancel_file.setVisibility(View.INVISIBLE);
                file_search.setVisibility(View.VISIBLE);
                image_url.setText("");
            }
        });

        storageReference = FirebaseStorage.getInstance().getReference();
        //        databaseReference = FirebaseDatabase.getInstance().getReference("Vaccination Record");

        UploadButton.setEnabled(false);

        file_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPDF();
            }
        });

        return pdfFragment;
    }

    private void selectPDF() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "PDF File Select"), 101);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101 && resultCode == RESULT_OK && data != null && data.getData() != null){
            UploadButton.setEnabled(true);
            file_logo.setVisibility(View.VISIBLE);
            cancel_file.setVisibility(View.VISIBLE);
            file_search.setVisibility(View.INVISIBLE);
            image_url.setText("File ready to upload");

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("Vaccination Record");

            DatabaseReference userRef = ref.child("Student ID");

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String name = user.getDisplayName();
            String UID = user.getUid();

            UploadButton.setOnClickListener(v -> {

                User vaccinationRecord = new User();
                Date date = Date.getDefaultInstance();
//
//                    vaccinationRecord.setStudentName(user.getDisplayName());
//                    vaccinationRecord.setStudentID(studentID.getText().toString());
//                    vaccinationRecord.setHealthStatus(healthStatus_spinner.getSelectedItem().toString());
//                    vaccinationRecord.setVaccinationStatus(vaccinationStatus_spinner.getSelectedItem().toString());
//                    vaccinationRecord.setVaccineName(vaccineName_spinner.getSelectedItem().toString());
//                    vaccinationRecord.setDateFullyVaccinated(vaccineDate.getText().toString());
//
                userRef.child(UID).setValue(vaccinationRecord);
//
                uploadPDFFileFirebase(data.getData());

            });

        }

    }
    private void uploadPDFFileFirebase(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("File is uploading...");
        progressDialog.show();

        StorageReference reference = storageReference.child("upload" + System.currentTimeMillis() + ".pdf");

        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                User vaccinationRecord = new User();
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference ref = database.getReference("Vaccination Record");
                                DatabaseReference userRef = ref.child("Student ID");
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                String UID = user.getUid();

                                //uploadPDFFileFirebase(vaccinationRecord.setPdfUrl(uri.toString()));

                                vaccinationRecord.setPdfUrl(uri.toString());
                                vaccinationRecord.setStudentName(user.getDisplayName());
                                vaccinationRecord.setStudentID(studentID.getText().toString());
                                vaccinationRecord.setCovidStatus(healthStatus_spinner.getSelectedItem().toString());
                                vaccinationRecord.setVaccinationStatus(vaccinationStatus_spinner.getSelectedItem().toString());
                                vaccinationRecord.setVaccineName(vaccineName_spinner.getSelectedItem().toString());
                                vaccinationRecord.setDateFullyVaccinated(vaccineDate.getText().toString());
//                                putPDF putpdf = new putPDF(image_url.getText().toString(), uri.toString());
                                userRef.child(UID).setValue(vaccinationRecord);

                                image_url.setText("Information Uploaded!");


                                Toast.makeText(getActivity(), "File Upload", Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }
                        });

                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        float percent=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        progressDialog.setMessage("File Uploaded..." + (int) percent + "%");

                    }
                });

    }
}
