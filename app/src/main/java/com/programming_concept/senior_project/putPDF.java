package com.programming_concept.senior_project;



public class putPDF{
    public String url;
    public String fileName;

    public putPDF(){

    }

    public putPDF(String name, String url) {
        this.fileName = name;
        this.url = url;
    }

    public String getName() {

        return fileName;
    }

    public void setName(String name) {

        this.fileName = name;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }
}

