package com.senior.businesscard.model.models;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    15.11.2021  21:47     │
//  └──────────────────────────┘

import java.util.Date;

public class BusinessCardModel {

    private String url;
    private String date;
    private String name;
    private String phone_number;
    private String mail;
    private String company;
    private String job;

    public BusinessCardModel(String url, String date, String name, String phone_number, String mail, String company, String job) {
        this.url = url;
        this.date = date;
        this.name = name;
        this.phone_number = phone_number;
        this.mail = mail;
        this.company = company;
        this.job = job;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}