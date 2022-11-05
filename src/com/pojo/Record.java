package com.pojo;

import java.io.Serializable;

public class Record implements Serializable {
    private int rId;
    private int rmId;
    private int rcId;
    private String risOutCity;
    private String risFromHB;
    private String risHousehold;
    private String rNowTime;
    private String cName;
    private String mName;

    public Record() {
    }

    public Record(int rId, int rmId, int rcId, String risOutCity, String risFromHB, String risHousehold, String rNowTime, String cName, String mName) {
        this.rId = rId;
        this.rmId = rmId;
        this.rcId = rcId;
        this.risOutCity = risOutCity;
        this.risFromHB = risFromHB;
        this.risHousehold = risHousehold;
        this.rNowTime = rNowTime;
        this.cName = cName;
        this.mName = mName;
    }

    public Record(int rId, int rmId, int rcId, String risOutCity, String risFromHB, String risHousehold, String rNowTime) {
        this.rId = rId;
        this.rmId = rmId;
        this.rcId = rcId;
        this.risOutCity = risOutCity;
        this.risFromHB = risFromHB;
        this.risHousehold = risHousehold;
        this.rNowTime = rNowTime;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getRmId() {
        return rmId;
    }

    public void setRmId(int rmId) {
        this.rmId = rmId;
    }

    public int getRcId() {
        return rcId;
    }

    public void setRcId(int rcId) {
        this.rcId = rcId;
    }

    public String getRisOutCity() {
        return risOutCity;
    }

    public void setRisOutCity(String risOutCity) {
        this.risOutCity = risOutCity;
    }

    public String getRisFromHB() {
        return risFromHB;
    }

    public void setRisFromHB(String risFromHB) {
        this.risFromHB = risFromHB;
    }

    public String getRisHousehold() {
        return risHousehold;
    }

    public void setRisHousehold(String risHousehold) {
        this.risHousehold = risHousehold;
    }

    public String getrNowTime() {
        return rNowTime;
    }

    public void setrNowTime(String rNowTime) {
        this.rNowTime = rNowTime;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "Record{" +
                "rId=" + rId +
                ", rmId=" + rmId +
                ", rcId=" + rcId +
                ", risOutCity='" + risOutCity + '\'' +
                ", risFromHB='" + risFromHB + '\'' +
                ", risHousehold='" + risHousehold + '\'' +
                ", rNowTime='" + rNowTime + '\'' +
                ", cName='" + cName + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }
}
