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

    //write setters
}
