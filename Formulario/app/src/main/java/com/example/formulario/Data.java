package com.example.formulario;

import java.util.ArrayList;

public class Data {
    private String nickname;
    private String name;
    private String locality;
    private String address;
    private String course;
    private ArrayList<String> extraServices;

    public Data() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public ArrayList<String> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(ArrayList<String> extraServices) {
        this.extraServices = extraServices;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
