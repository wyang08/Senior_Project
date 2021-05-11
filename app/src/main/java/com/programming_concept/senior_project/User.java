package com.programming_concept.senior_project;

import android.text.format.Time;

import java.util.Calendar;
import java.util.Date;

public class User {
    private String studentName;
    private String studentID;
    private String pdfUrl;
    private String vaccineName;
    private String dateFullyVaccinated;
    private String vaccinationStatus;
    private String healthStatus;
    private String filename; //refers to filename of the pdf file uploaded by user. Used only by ViewPdf class





    public User() {
    }

    public User(String studentName, String studentID, String vaccineName, String dateFullyVaccinated, String vaccinationStatus, String pdfUrl, String healthStatus, String filename) {
        this.studentName = studentName; //student name
        this.studentID = studentID; //student school ID
        this.pdfUrl = pdfUrl; //pdf url in Firebase
        this.vaccineName = vaccineName; //name of vaccine received
        this.dateFullyVaccinated = dateFullyVaccinated; //calendar date when fully vaccinated. Used for notifying user when to get another shot
        this.vaccinationStatus = vaccinationStatus; //indicates if user is FullyVaccinated, NotVaccinated, or OnlyFirstDose
        this.healthStatus = healthStatus; //indicates if Healthy, Sick, or Unconfirmed
        this.filename = filename;

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }


    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDateFullyVaccinated() {
        return dateFullyVaccinated;
    }

    public void setDateFullyVaccinated(String dateFullyVaccinated) {
        this.dateFullyVaccinated = dateFullyVaccinated;
    }

    public String getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(String vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getFileName() {
        return filename;
    }
}

