package com.geek.egcurrency;

import com.geek.egcurrency.Model.BankModel;
import com.geek.egcurrency.Model.CurrencyModel;
import com.geek.egcurrency.Model.FullnameModel;
import com.geek.egcurrency.Model.InfoModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Converter {

    public static ArrayList<BankModel> fromJson(JSONArray jsonArray) throws JSONException {
        BankModel model;
        ArrayList<BankModel> banks = new ArrayList<>();
        ArrayList<CurrencyModel> currencies;


        for (int i = 0;i<jsonArray.length();i++){
            model = new BankModel();
            currencies = new ArrayList<>();
            JSONObject obj = jsonArray.getJSONObject(i);
            JSONArray array = obj.getJSONArray("currencies");


            model.setBankCode(obj.getString("BankCode"));


            for (int j=0 ; j< array.length();j++){
                JSONObject currentObj = array.getJSONObject(j);
                currencies.add(new CurrencyModel(
                        currentObj.getString("CurrencyID"),
                        currentObj.getString("SellRate"),
                        currentObj.getString("BuyRate"))
                );
            }


            model.setCurrencies(currencies);
            //currencies.clear();
            banks.add(model);

        }
        return banks;
    }
    public static InfoModel fromJson(JSONObject jsonObject) throws JSONException{
        InfoModel model = new InfoModel();
        model.setUrl(jsonObject.getString("url"));
        JSONObject name = jsonObject.getJSONObject("fullName");
        model.setFullName(new FullnameModel(name.getString("en"),name.getString("ar")));
        return model;
    }
}
