package com.example.tutor_hiring_app;

public class Tutor {
    //fields
    private String f_name;
    private String l_name;
    private String civic_number;
    private String street_name;
    private String app_number;
    private String city_name;
    private String province_name;
    private String postal_code;
    private String country_name;
    private long tel_number;
    private String subj_name;
    private double hour_fees;
    private int experience;


    //default constructor
    public Tutor() {
        this.f_name = "";
        this.l_name = "";
        this.civic_number = "";
        this.street_name = "";
        this.app_number = "";
        this.city_name = "";
        this.province_name = "";
        this.postal_code = "";
        this.country_name = "";
        this.tel_number = 0;
        this.subj_name = "";
        this.hour_fees = 0.0;
        this.experience = 0;
    }

        //parameterized constructor
        public Tutor(String f_name, String l_name, String civic_number, String street_name, String app_number, String city_name, String province_name,
                String postal_code, String country_name, long tel_number, String subj_name, double hour_fees, int experience) {
            this.f_name = f_name;
            this.l_name = l_name;
            this.civic_number = civic_number;
            this.street_name = street_name;
            this.app_number = app_number;
            this.city_name = city_name;
            this.province_name = province_name;
            this.postal_code = postal_code;
            this.country_name = country_name;
            this.tel_number = tel_number;
            this.subj_name = subj_name;
            this.hour_fees = hour_fees;
            this.experience = experience;
    }

    //getter methods
    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getCivic_number() {
        return civic_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public String getApp_number() {
        return app_number;
    }

    public String getCity_name() {
        return city_name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public long getTel_number() {
        return tel_number;
    }

    public String getSubj_name() {
        return subj_name;
    }

    public double getHour_fees() {
        return hour_fees;
    }

    public int getExperience() {
        return experience;
    }

    //setter methods
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setCivic_number(String civic_number) {
        this.civic_number = civic_number;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public void setApp_number(String app_number) {
        this.app_number = app_number;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setTel_number(long tel_number) {
        this.tel_number = tel_number;
    }

    public void setSubj_name(String subj_name) {
        this.subj_name = subj_name;
    }

    public void setHour_fees(double hour_fees) {
        this.hour_fees = hour_fees;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    //toString methods
    @Override
    public String toString() {
        return "Tutor{" +
                "f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", civic_number='" + civic_number + '\'' +
                ", street_name='" + street_name + '\'' +
                ", app_number='" + app_number + '\'' +
                ", city_name='" + city_name + '\'' +
                ", province_name='" + province_name + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country_name='" + country_name + '\'' +
                ", tel_number=" + tel_number +
                ", subj_name='" + subj_name + '\'' +
                ", hour_fees=" + hour_fees +
                ", experience=" + experience +
                '}';
    }
}
