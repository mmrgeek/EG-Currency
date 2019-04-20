package com.geek.egcurrency.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geek.egcurrency.Model.BankModel;
import com.geek.egcurrency.R;
import com.geek.egcurrency.View.BankDetailsActivity;

import java.util.ArrayList;

public class BanksAdapter extends RecyclerView.Adapter<BanksAdapter.BankViewHolder> {

    private ArrayList<BankModel> banks;
    private Context context;

    public BanksAdapter(Context context, ArrayList<BankModel> banks) {
        this.banks = banks;
        this.context = context;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bank_item,viewGroup,false);
        return new BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder bankViewHolder, int i) {
        bankViewHolder.setBank(banks.get(i).getBankCode());
        bankViewHolder.setClick(banks.get(i));
    }

    @Override
    public int getItemCount() {
        return banks == null ? 0 : banks.size();
    }

    class BankViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_bankName;

        public BankViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bankName = itemView.findViewById(R.id.tv_bankName);

        }
        public void setBank(String bankName){
            tv_bankName.setText(bankName);
        }

        public void setClick(BankModel bank){

            itemView.setOnClickListener(v->{
                Intent i = new Intent(context, BankDetailsActivity.class);
                i.putExtra("bank",bank);
                i.putParcelableArrayListExtra("currencies",bank.getCurruncies());
                context.startActivity(i);
            });

        }
    }
}
