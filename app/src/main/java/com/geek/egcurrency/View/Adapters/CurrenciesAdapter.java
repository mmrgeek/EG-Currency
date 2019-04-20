package com.geek.egcurrency.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.geek.egcurrency.Model.CurrencyModel;
import com.geek.egcurrency.R;
import java.util.ArrayList;


public class CurrenciesAdapter extends RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder> {
    private ArrayList<CurrencyModel> currencies;
    private Context context;

    public CurrenciesAdapter(ArrayList<CurrencyModel> currencies,Context context) {
        this.currencies = currencies;
        this.context = context;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.currency_itm,viewGroup,false);
        return new CurrencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder currencyViewHolder, int i) {
        currencyViewHolder.setBuyRate(currencies.get(i).getBuyRate());
        currencyViewHolder.setSellRate(currencies.get(i).getSellRate());
        currencyViewHolder.setCurrency(currencies.get(i).getCurrencyID());
    }

    @Override
    public int getItemCount() {
        return currencies == null ? 0: currencies.size();
    }

    class CurrencyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_sellRate;
        private TextView tv_buyRate;
        private TextView tv_currency;

        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_currency = itemView.findViewById(R.id.tv_currency);
            tv_buyRate = itemView.findViewById(R.id.tv_buyRate);
            tv_sellRate = itemView.findViewById(R.id.tv_sellRate);
        }
        public void setBuyRate(String buyRate){
            tv_buyRate.setText("Buy Rate: "+buyRate);
        }
        public void setSellRate(String sellRate){
            tv_sellRate.setText("Sell Rate: "+sellRate);
        }
        public void setCurrency(String currency){
            tv_currency.setText(currency);
        }
    }
}
