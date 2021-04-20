package com.programming_concept.senior_project;

import java.util.Date;

public class User {
    private String studentName;
    private String id;
    //private String fileName;
    private String vaccineName;
   //private Date dateReceived;
    private String vaccinationStatus;




    public User() {
    }

    public User(String studentName, String id, String vaccineName) {
        this.studentName = studentName;
        this.id = id;
        //this.fileName = fileName;
        this.vaccineName = vaccineName;
        //this.dateReceived = dateReceived;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

//    public Date getDateReceived() {
//        return dateReceived;
//    }
//
//    public void setDateReceived(Date dateReceived) {
//        this.dateReceived = dateReceived;
//    }

    public String getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(String vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }
}

