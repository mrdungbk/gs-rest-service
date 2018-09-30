package com.management.devices.database.entity;

import java.io.Serializable;

public class LoginResult implements Serializable {

    private static final long serialVersionUID = 6378573093342373254L;
    private String code;
    private String description;
    private String token;


    public LoginResult(String code, String description, String token) {
        super();
        this.code = code;
        this.description = description;
        this.token = token;
    }

    public LoginResult() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("code = ").append(code).append(" - ");
        sb.append("description = ").append(description).append(" - ");
        sb.append("token = ").append(token).append(" - ");
        return sb.toString();
    }

}