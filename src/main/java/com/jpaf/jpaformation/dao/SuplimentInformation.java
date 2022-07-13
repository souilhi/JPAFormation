package com.jpaf.jpaformation.dao;



import java.io.Serializable;



public class SuplimentInformation implements Serializable {

    private String images;
    private String phoneNumber;

    public SuplimentInformation(String images, String phoneNumber) {
        this.images = images;
        this.phoneNumber = phoneNumber;
    }
}
