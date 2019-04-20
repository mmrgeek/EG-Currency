package com.geek.egcurrency.View;

import com.geek.egcurrency.Model.InfoModel;


public interface IBankDetailsView {
    void onDataFetchProgress();
    void onDataFetchSucceeded(InfoModel infoModel);
    void onDataFetchFailed(Throwable t);
}
