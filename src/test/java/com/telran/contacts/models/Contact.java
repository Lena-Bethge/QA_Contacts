package com.telran.contacts.models;

public class Contact {
    private  String name;
    private  String sureName;
    private  String phone;
    private  String email;
    private  String address;
    private  String discription;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setSureName(String sureName) {
        this.sureName = sureName;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setDiscription(String discription) {
        this.discription = discription;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDiscription() {
        return discription;
    }
}
