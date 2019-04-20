package com.geek.egcurrency.Presenter;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.geek.egcurrency.Converter;
import com.geek.egcurrency.View.IBankDetailsView;
import org.json.JSONException;
import org.json.JSONObject;

public class BankDetailsPresenter implements IBankDetailsPresenter {
    private IBankDetailsView bankDetailsView;
    private Context context;
    private String url = "https://currency-spidey.herokuapp.com/api/info/";
    public BankDetailsPresenter(IBankDetailsView bankDetailsView, Context context) {
        this.bankDetailsView = bankDetailsView;
        this.context = context;
    }

    @Override
    public void onBankDetailsFetch(String bank) {
        bankDetailsView.onDataFetchProgress();
        Volley.newRequestQueue(context)
                .add(new JsonObjectRequest(Request.Method.GET, url+bank, new JSONObject(),
                        response -> {
                            try {
                                bankDetailsView.onDataFetchSucceeded(Converter.fromJson(response));
                            } catch (JSONException e) {
                                bankDetailsView.onDataFetchFailed(e);
                            }
                        }, error -> bankDetailsView.onDataFetchFailed(error)
                ));
    }
}
