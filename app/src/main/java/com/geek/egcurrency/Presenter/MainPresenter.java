package com.geek.egcurrency.Presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.geek.egcurrency.Converter;
import com.geek.egcurrency.View.IMainView;

import org.json.JSONArray;
import org.json.JSONException;

public class MainPresenter implements IMainPresenter{

    private IMainView mainView;
    private Context context;

    private static final String url = "https://currency-spidey.herokuapp.com/api/fetch";

    public MainPresenter(Context context,IMainView mainView) {
        this.mainView = mainView;
        this.context = context;
    }


    @Override
    public void onDataFetch() {
        mainView.onDataFetchProgress();
        Volley.newRequestQueue(context)
                .add(new JsonArrayRequest(Request.Method.GET, url, new JSONArray(),
                        response -> {
                            try {
                                mainView.onDataFetchSucceeded(Converter.fromJson(response));
                            } catch (JSONException e) {
                                mainView.onDataFetchFailed(e);
                            }
                        }, error -> mainView.onDataFetchFailed(error)
                ));
    }

}
