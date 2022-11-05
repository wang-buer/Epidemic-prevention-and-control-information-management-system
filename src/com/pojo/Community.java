package com.pojo;

import java.io.Serializable;

public class Community implements Serializable {
    private int cId;
    private String cName;
    private String province;
    private String city;
    private String street;
    private String cTel;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public Community() {
    }

    public Community(int cId, String cName, String province, String city, String street, String cTel) {
        this.cId = cId;
        this.cName = cName;
        this.province = province;
        this.city = city;
        this.street = street;
        this.cTel = cTel;
    }

    @Override
    public String toString() {
        return "Community{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", cTel='" + cTel + '\'' +
                '}';
    }
}
