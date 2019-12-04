package com.example.comp7082.comp7082photogallery;

public class School {
    private int phone;
    private String districtNumber;
    private String SchoolEmail;
    private int SchoolNumber;
    private String Address;
    private String City;
    private String Province;
    private String PostalCode;

    private static final School INSTANCE = new School();

    private School() {}

    public static School getInstance() {
        return INSTANCE;
    }

    public void setPhone(int p){
        phone = p;
    }

    public void setDistrictNumber(String d){
        districtNumber = d;
    }

    public void setSchoolEmail(String em){
        SchoolEmail = em;
    }

    public void setSchoolNumber(int sn){
        SchoolNumber = sn;
    }

    public void setAddress(String a){
        Address = a;
    }

    public void setCity(String c){
        City = c;
    }

    public void setProvince(String e){
        Province = e;
    }

    public void setPostalCode(String p){
        PostalCode = p;
    }
}
