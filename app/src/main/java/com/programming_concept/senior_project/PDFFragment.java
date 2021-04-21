package com.programming_concept.senior_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;

public class PDFFragment extends Fragment {

    EditText image_url, user_name, vaccine, date;
    Button UploadButton;

//    private FirebaseAuth mAuth;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View pdfFragment = inflater.inflate(R.layout.fragmnet_pdf, container, false);

        image_url = pdfFragment.findViewById(R.id.image_url);
        user_name = pdfFragment.findViewById(R.id.user_name);
        vaccine = pdfFragment.findViewById(R.id.user_vaccine);
        date = pdfFragment.findViewById(R.id.user_date);
        UploadButton = pdfFragment.findViewById(R.id.submit_pdf);

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("Vaccination Record");

        UploadButton.setEnabled(false);

        image_url.setOnClickListener(new View.OnClickListener() {
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
            startActivityForResult(Intent.createChooser(intent, "PDF File Select"), 12);

        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode==12 && resultCode == RESULT_OK && data != null && data.getData() != null){
                UploadButton.setEnabled(true);

                image_url.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Vaccination Record");

                DatabaseReference userRef = ref.child("Student ID");

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String UID = user.getUid();

                UploadButton.setOnClickListener(v -> {

                    VaccinationRecord vaccinationRecord = new VaccinationRecord();
                    vaccinationRecord.setUser_image_url(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
                    vaccinationRecord.setName(user_name.getText().toString());
                    vaccinationRecord.setVaccine(vaccine.getText().toString());
                    vaccinationRecord.setDate(date.getText().toString());

                    userRef.child(UID).setValue(vaccinationRecord);

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
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri = uriTask.getResult();

                        putPDF putPDF = new putPDF(image_url.getText().toString(), uri.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(putPDF);
                        Toast.makeText(getActivity(), "File Upload", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                        double progress = (100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        progressDialog.setMessage("File Uploaded..." + (int) progress+ "%");

            }
        });

    }

}
