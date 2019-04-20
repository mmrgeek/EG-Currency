package com.geek.egcurrency.Model;


public class InfoModel {
    private FullnameModel fullName;
    private String url;

    public InfoModel(FullnameModel fullName, String url) {
        this.fullName = fullName;
        this.url = url;
    }

    public InfoModel() {
    }

    public FullnameModel getFullName() {
        return fullName;
    }

    public void setFullName(FullnameModel fullName) {
        this.fullName = fullName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
