package com.application.test.models;

public class LoginDetails {
    String phone;
    String password;
    String firebaseToken;

    public LoginDetails() {
    }

    public LoginDetails(String phone, String password, String firebaseToken) {
        this.phone = phone;
        this.password = password;
        this.firebaseToken = firebaseToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }
}
