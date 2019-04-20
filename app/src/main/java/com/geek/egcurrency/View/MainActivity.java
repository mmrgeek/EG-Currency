package com.geek.egcurrency.View;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.geek.egcurrency.Model.BankModel;
import com.geek.egcurrency.Presenter.MainPresenter;
import com.geek.egcurrency.R;
import com.geek.egcurrency.View.Adapters.BanksAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainView , SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout srf;
    private RecyclerView rv_banks;
    private MainPresenter presenter;
    private BanksAdapter adapter;
    private ArrayList<BankModel> banks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srf = findViewById(R.id.srl);
        rv_banks = findViewById(R.id.rv_banks);
        presenter = new MainPresenter(this,this);
        rv_banks.setLayoutManager(new LinearLayoutManager(this));
        banks = new ArrayList<>();
        presenter.onDataFetch();
        adapter = new BanksAdapter( this, banks);
        rv_banks.setAdapter(adapter);

        srf.setOnRefreshListener(this);
    }

    @Override
    public void onDataFetchProgress() {
        srf.setRefreshing(true);
    }

    @Override
    public void onDataFetchSucceeded(ArrayList<BankModel> banks) {

        srf.setRefreshing(false);
        this.banks.clear();
        this.banks.addAll(banks);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDataFetchFailed(Throwable t) {
        srf.setRefreshing(false);
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        presenter.onDataFetch();
    }
}
