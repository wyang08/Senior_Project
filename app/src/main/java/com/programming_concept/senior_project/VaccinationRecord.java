package com.programming_concept.senior_project;

public class VaccinationRecord {
    private String user_name, vaccine, date;

    public VaccinationRecord() {

    }

    public VaccinationRecord(String name, String vaccine, String date)
    {
        this.user_name = name;
        this.vaccine = vaccine;
        this.date = date;
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

}
