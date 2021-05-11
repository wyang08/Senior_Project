package com.programming_concept.senior_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class CasesFragment extends Fragment {

    private TextView TotalConfirmed, TotalDeath, TotalRecovered, TodayCases, TodayDeaths;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View case_fragment= inflater.inflate(R.layout.fragment_cases, container, false);

        TotalConfirmed = case_fragment.findViewById(R.id.TotalConfirmed);
        TotalDeath = case_fragment.findViewById(R.id.TotalDeath);
        TotalRecovered = case_fragment.findViewById(R.id.TotalRecovered);
        TodayCases = case_fragment.findViewById(R.id.TodayCases);
        TodayDeaths = case_fragment.findViewById(R.id.TodayDeath);

        getData();

        return case_fragment;
    }

    //Volley Fetch REST API

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/v3/covid-19/states/New York";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);

                try {

                    JSONObject jsonObject = new JSONObject(response.toString());
                    TotalConfirmed.setText(jsonObject.getString("cases"));
                    TotalDeath.setText(jsonObject.getString("deaths"));
                    TotalRecovered.setText(jsonObject.getString("recovered"));
                    TodayCases.setText(jsonObject.getString("todayCases"));
                    TodayDeaths.setText(jsonObject.getString("todayDeaths"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response", error.toString());
            }
        });

        queue.add(stringRequest);
    }

}
