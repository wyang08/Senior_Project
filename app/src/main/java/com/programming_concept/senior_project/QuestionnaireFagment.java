package com.programming_concept.senior_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionnaireFagment extends Fragment {
    @Nullable

    RadioButton response1, response2, response3, response4;
    TextView header1, question1, question2;
    Button submitButton;

    private Questions aQuestions = new Questions();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmnet_questionnair, container, false);
        }

    }
