package com.geek.egcurrency.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.geek.egcurrency.Model.BankModel;
import com.geek.egcurrency.Model.CurrencyModel;
import com.geek.egcurrency.Model.InfoModel;
import com.geek.egcurrency.Presenter.BankDetailsPresenter;
import com.geek.egcurrency.R;
import com.geek.egcurrency.View.Adapters.CurrenciesAdapter;

import java.util.ArrayList;

public class BankDetailsActivity extends AppCompatActivity implements IBankDetailsView , View.OnClickListener {

    private BankModel model;
    private ArrayList<CurrencyModel> currencies;
    private BankDetailsPresenter presnter;
    private CurrenciesAdapter adapter;
    private RecyclerView rv_currencies;
    private TextView tv_enFullname;
    private TextView tv_arFullname;
    private TextView tv_url;
    private String url = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        tv_enFullname = findViewById(R.id.tv_enFullname);
        tv_arFullname = findViewById(R.id.tv_arFullname);
        tv_url = findViewById(R.id.tv_url);
        rv_currencies = findViewById(R.id.rv_currencies);


        model = getIntent().getParcelableExtra("bank");
        currencies = getIntent().getParcelableArrayListExtra("currencies");

        presnter = new BankDetailsPresenter(this,this);

        adapter = new CurrenciesAdapter(currencies,this);
        rv_currencies.setLayoutManager(new LinearLayoutManager(this));
        rv_currencies.setAdapter(adapter);
        tv_url.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presnter.onBankDetailsFetch(model.getBankCode());
    }

    @Override
    public void onDataFetchProgress() {
        tv_enFullname.setText("...");
        tv_arFullname.setText("...");
        tv_url.setText("...");
    }

    @Override
    public void onDataFetchSucceeded(InfoModel infoModel) {
        tv_arFullname.setText(infoModel.getFullName().getAr());
        tv_enFullname.setText(infoModel.getFullName().getEn());
        tv_url.setText(Html.fromHtml("<p><u>"+infoModel.getUrl()+"</u></p>"));
        url = infoModel.getUrl();
    }

    @Override
    public void onDataFetchFailed(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_url:
                if (url!=null){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                break;
        }
    }
}
