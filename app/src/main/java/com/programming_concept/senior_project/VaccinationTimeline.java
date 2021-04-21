package com.programming_concept.senior_project;


public class VaccinationTimeline {
    Integer mCount;
    String mDate;

    public VaccinationTimeline(String mDate, Integer mCount) {
        this.mDate = mDate;
        this.mCount = mCount;
    }

    public String getmDate() {
        return mDate;
    }

    public Integer getmCount() {
        return mCount;
    }
}
