package com.management.devices.database.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 6378573093342373254L;
    private int id;
    private String userName;
    private int status;
    private int agencyId;


    public User(int id, String userName, int status, int agencyId) {
        super();
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.agencyId = agencyId;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id).append(" - ");
        sb.append("userName = ").append(userName).append(" - ");
        sb.append("status = ").append(status).append(" - ");
        sb.append("agencyId = ").append(agencyId).append(" - ");
        return sb.toString();
    }

}