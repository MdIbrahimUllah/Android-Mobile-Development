package com.example.tutor_hiring_app;

public class Child {
    private String childFirstName;
    private String childLastName;
    private int childAge;

    //parameterized constructor
    public Child(String childFirstName, String childLastName, int childAge) {
        this.childFirstName = childFirstName;
        this.childLastName = childLastName;
        this.childAge = childAge;
    }

    //getters
    public String getChildFirstName() {
        return childFirstName;
    }

    public String getChildLastName() {
        return childLastName;
    }

    public int getChildAge() {
        return childAge;
    }

    //setters
    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    //toString method
    @Override
    public String toString() {
        return "Child{" +
                "childFirstName='" + childFirstName + '\'' +
                ", childLastName='" + childLastName + '\'' +
                ", childAge=" + childAge +
                '}';
    }
}
