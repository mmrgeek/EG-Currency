package com.geek.egcurrency.Model;


public class FullnameModel {
    private String en;
    private String ar;

    public FullnameModel(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }
}
