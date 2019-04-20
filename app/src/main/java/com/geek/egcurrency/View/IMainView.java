package com.geek.egcurrency.View;

import com.geek.egcurrency.Model.BankModel;
import java.util.ArrayList;

public interface IMainView {
    void onDataFetchProgress();
    void onDataFetchSucceeded(ArrayList<BankModel> banks);
    void onDataFetchFailed(Throwable t);
}
