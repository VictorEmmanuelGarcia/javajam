package com.example.tri_os;
public class Driver {
    public String nickname, fullName, address, contactNum, licenseNum, expirationDate;
    public Driver(){}
    public Driver(String nn, String fn, String ha, String cn, String ln, String ed){
        setNickname(nn);
        setFullName(fn);
        setAddress(ha);
        setContactNum(cn);
        setLicenseNum(ln);
        setExpirationDate(ed);
    }

    public String getNickname() {
        return nickname;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNum() {
        return contactNum;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setNickname(String nn) {
        this.nickname = nn;
    }

    public void setFullName(String fn) {
        this.fullName = fn;
    }

    public void setAddress(String ha) {
        this.address = ha;
    }

    public void setContactNum(String cn) {
        this.contactNum = cn;
    }

    public void setLicenseNum(String ln) {
        this.licenseNum = ln;
    }

    public void setExpirationDate(String ed) {
        this.expirationDate = ed;
    }
}