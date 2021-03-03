package com.programming_concept.senior_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class ProfileFragment extends Fragment {
    private TextView name;
    private TextView email;

//    private ImageView qr_image;
//    private GoogleApiClient googleApiClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View profile_fragement_view = inflater.inflate(R.layout.fragmnet_profile, container, false);

        name = profile_fragement_view.findViewById(R.id.username);
        email = profile_fragement_view.findViewById(R.id.email);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (signInAccount != null) {
            name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());
        }

        return profile_fragement_view;
    }



}