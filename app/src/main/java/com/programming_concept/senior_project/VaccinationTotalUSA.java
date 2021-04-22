package com.programming_concept.senior_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class VaccinationTotalUSA extends Fragment {

    RecyclerView rvRecentRecord;
    ProgressBar progressBar;

    VaccinationAdapter vaccinationAdapter;

    private static final String TAG = VaccinationTotalUSA.class.getSimpleName();

    ArrayList<VaccinationTimeline> recentRecords;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);

        // call view
        rvRecentRecord = view.findViewById(R.id.vaccinationRecord);
        progressBar = view.findViewById(R.id.progress_circular_vaccination);

        rvRecentRecord.setLayoutManager(new LinearLayoutManager(getActivity()));

        vaccinationAdapter = new VaccinationAdapter();
        rvRecentRecord.setAdapter(vaccinationAdapter);

        // Volley Fetch
        getDataFromServer();

        return view;
    }

    private void getDataFromServer() {
        String url = "https://disease.sh/v3/covid-19/vaccine/coverage/countries/USA";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                progressBar.setVisibility(View.GONE);

                if (response != null) {
                    Log.i(TAG, "onResponse:" + response);
                    try {

                        JSONObject jsonObject = new JSONObject(response);
                        JSONObject subObject = jsonObject.getJSONObject("timeline");

                        JSONArray keys = subObject.names();

                        ArrayList<VaccinationTimeline> recentRecords = new ArrayList<>();

                        for (int i = 0; i < keys.length(); i++) {

                            String key = keys.getString(i);
                            int value = subObject.getInt(key);

                            recentRecords.add(new VaccinationTimeline(key, value));

                            Log.d("LOG_TAG", key + ":" + value);

                        }
                        vaccinationAdapter.updateRecords(recentRecords);
//                        showRecyclerView();
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onResponse" + error);
                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }
}
