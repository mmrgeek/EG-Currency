package com.geek.egcurrency.Model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BankModel implements Parcelable {

    private String BankCode;

    private ArrayList<CurrencyModel> currencies;

    public BankModel() { }

    public BankModel(String BankCode, ArrayList< CurrencyModel> currencies) {
        this.BankCode = BankCode;
        this.currencies = currencies;
    }

    protected BankModel(Parcel in) {
        BankCode = in.readString();
    }

    public static final Creator<BankModel> CREATOR = new Creator<BankModel>() {
        @Override
        public BankModel createFromParcel(Parcel in) {
            return new BankModel(in);
        }

        @Override
        public BankModel[] newArray(int size) {
            return new BankModel[size];
        }
    };

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        this.BankCode = bankCode;
    }

    public ArrayList<CurrencyModel> getCurruncies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<CurrencyModel> currencies) {
        this.currencies = currencies;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(BankCode);
    }
}
