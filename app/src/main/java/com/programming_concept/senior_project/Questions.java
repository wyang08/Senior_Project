package com.programming_concept.senior_project;

public class Questions {

    public String aQuestions [] = {

            "Are you awaiting the results of a COVID-19 Test?",
            "Have you taken one of the vaccines for COVID-19?(Moderna, Pfizer, Johnson and Johnson Jassen)",

    };

    public String aResponses[] [] = {
            {"Yes","No"},
            {"Yes","No"},
    };

    public String getQuestions(int a) {
       String question = aQuestions[a];
       return question;
    }

    public String getResponse1(int a) {
        String response1 = aResponses[a][0];
        return response1;
    }

    public String getResponse2(int a) {
        String response2 = aResponses[a][0];
        return response2;
    }

    public String getResponse3(int a) {
        String response3 = aResponses[a][0];
        return response3;
    }

    public String getResponse4(int a) {
        String response3 = aResponses[a][0];
        return response3;
    }
}
