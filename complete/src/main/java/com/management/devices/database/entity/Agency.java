package com.management.devices.database.entity;

import java.io.Serializable;

public class Agency implements Serializable {

    private static final long serialVersionUID = 6378573093342373254L;
    private int id;
    private int userId;
    private String name;
    private String phone;
    private String address;


    public Agency(int id, int userId, String name, String phone, String address) {
        super();
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Agency() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id).append(" - ");
        sb.append("Name = ").append(name).append(" - ");
        sb.append("Phone = ").append(phone).append(" - ");
        sb.append("Address = ").append(address).append(" - ");
        sb.append("UserId = ").append(userId);
        return sb.toString();
    }

}