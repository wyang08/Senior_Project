package com.programming_concept.senior_project;

public class VaccinationRecord {
    private String user_name, vaccine, date, user_image_url;

    public VaccinationRecord() {

    }

    public VaccinationRecord(String name, String vaccine, String date, String user_image_url)
    {
        this.user_name = name;
        this.vaccine = vaccine;
        this.date = date;
        this.user_image_url = user_image_url;
    }

    public String getName() {
        return user_name;
    }
    public void setName(String name) {
        this.user_name = name;
    }
    public String getVaccine() {
        return vaccine;
    }
    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }
}
