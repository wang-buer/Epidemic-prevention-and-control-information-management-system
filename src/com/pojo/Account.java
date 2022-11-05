package com.pojo;

import java.io.Serializable;

public class Account implements Serializable {
    private int accountID;
    private String accountName;
    private String accountPassword;
    private String accountIsStop;
    private String accountRole;

    public Account() {
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountIsStop() {
        return accountIsStop;
    }

    public void setAccountIsStop(String accountIsStop) {
        this.accountIsStop = accountIsStop;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }

    public Account(int accountID, String accountName, String accountPassword, String accountIsStop, String accountRole) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountIsStop = accountIsStop;
        this.accountRole = accountRole;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountIsStop='" + accountIsStop + '\'' +
                ", accountRole='" + accountRole + '\'' +
                '}';
    }
}
