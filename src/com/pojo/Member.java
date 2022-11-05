package com.pojo;

import java.io.Serializable;

public class Member implements Serializable {
    private int mId;
    private String mName;
    private String mTel;
    private String mSex;
    private int mAge;
    private String mHouseNum;
    private String mWorkUnit;
    private String mCarNum;
    private String mIsHousehold;
    private int mcId;
    private String cName;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTel() {
        return mTel;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmHouseNum() {
        return mHouseNum;
    }

    public void setmHouseNum(String mHouseNum) {
        this.mHouseNum = mHouseNum;
    }

    public String getmWorkUnit() {
        return mWorkUnit;
    }

    public void setmWorkUnit(String mWorkUnit) {
        this.mWorkUnit = mWorkUnit;
    }

    public String getmCarNum() {
        return mCarNum;
    }

    public void setmCarNum(String mCarNum) {
        this.mCarNum = mCarNum;
    }

    public String getmIsHousehold() {
        return mIsHousehold;
    }

    public void setmIsHousehold(String mIsHousehold) {
        this.mIsHousehold = mIsHousehold;
    }

    public int getMcId() {
        return mcId;
    }

    public void setMcId(int mcId) {
        this.mcId = mcId;
    }

    public Member() {
    }

    public Member(int mId, String mName, String mTel, String mSex, int mAge, String mHouseNum, String mWorkUnit, String mCarNum, String mIsHousehold, int mcId) {
        this.mId = mId;
        this.mName = mName;
        this.mTel = mTel;
        this.mSex = mSex;
        this.mAge = mAge;
        this.mHouseNum = mHouseNum;
        this.mWorkUnit = mWorkUnit;
        this.mCarNum = mCarNum;
        this.mIsHousehold = mIsHousehold;
        this.mcId = mcId;
    }

    public Member(int mId, String mName, String mTel, String mSex, int mAge, String mHouseNum, String mWorkUnit, String mCarNum, String mIsHousehold, int mcId, String cName) {
        this.mId = mId;
        this.mName = mName;
        this.mTel = mTel;
        this.mSex = mSex;
        this.mAge = mAge;
        this.mHouseNum = mHouseNum;
        this.mWorkUnit = mWorkUnit;
        this.mCarNum = mCarNum;
        this.mIsHousehold = mIsHousehold;
        this.mcId = mcId;
        this.cName = cName;
    }


    @Override
    public String toString() {
        return "Member{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mTel='" + mTel + '\'' +
                ", mSex='" + mSex + '\'' +
                ", mAge=" + mAge +
                ", mHouseNum='" + mHouseNum + '\'' +
                ", mWorkUnit='" + mWorkUnit + '\'' +
                ", mCarNum='" + mCarNum + '\'' +
                ", mIsHousehold='" + mIsHousehold + '\'' +
                ", mcId=" + mcId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
