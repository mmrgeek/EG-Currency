package com.geek.egcurrency.Model;


import android.os.Parcel;
import android.os.Parcelable;

public class CurrencyModel implements Parcelable {

    private String currencyID;
    private String sellRate;
    private String buyRate;

    public CurrencyModel(String currencyID, String sellRate, String buyRate) {
        this.sellRate = sellRate;
        this.buyRate = buyRate;
        this.currencyID = currencyID;
    }

    public CurrencyModel() {
    }

    protected CurrencyModel(Parcel in) {
        currencyID = in.readString();
        sellRate = in.readString();
        buyRate = in.readString();
    }

    public static final Creator<CurrencyModel> CREATOR = new Creator<CurrencyModel>() {
        @Override
        public CurrencyModel createFromParcel(Parcel in) {
            return new CurrencyModel(in);
        }

        @Override
        public CurrencyModel[] newArray(int size) {
            return new CurrencyModel[size];
        }
    };

    public String getSellRate() {
        return sellRate;
    }

    public void setSellRate(String sellRate) {
        this.sellRate = sellRate;
    }

    public String getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(String buyRate) {
        this.buyRate = buyRate;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currencyID);
        dest.writeString(sellRate);
        dest.writeString(buyRate);
    }
}
