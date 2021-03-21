package com.programming_concept.senior_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HealthAlertActivity extends AppCompatActivity {

    //@Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthalert_activity);
        TextView nameTxt = findViewById(R.id.healthAlerttextView);

        String username = "Username not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }

        nameTxt.setText(username);

    }
}

