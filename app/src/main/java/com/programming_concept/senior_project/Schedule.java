package com.programming_concept.senior_project;

public class Schedule {
    String first_class, second_class, third_class, fourth_class, fifth_class, sixth_class;


    public Schedule(String first_class, String second_class, String third_class, String fourth_class, String fifth_class, String sixth_class) {
        this.first_class = first_class;
        this.second_class = second_class;
        this.third_class = third_class;
        this.fourth_class = fourth_class;
        this.fifth_class = fifth_class;
        this.sixth_class = sixth_class;
    }

    public Schedule() {

    }

    public String getFirst_class() {
        return first_class;
    }

    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }

    public String getSecond_class() {
        return second_class;
    }

    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }

    public String getThird_class() {
        return third_class;
    }

    public void setThird_class(String third_class) {
        this.third_class = third_class;
    }

    public String getFourth_class() {
        return fourth_class;
    }

    public void setFourth_class(String fourth_class) {
        this.fourth_class = fourth_class;
    }

    public String getFifth_class() {
        return fifth_class;
    }

    public void setFifth_class(String fifth_class) {
        this.fifth_class = fifth_class;
    }

    public String getSixth_class() {
        return sixth_class;
    }

    public void setSixth_class(String sixth_class) {
        this.sixth_class = sixth_class;
    }
}
