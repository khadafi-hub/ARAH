package com.example.arah.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.arah.R;
import com.example.arah.SetterGetterCredit;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class RecyclerViewCreditAdaptor extends RecyclerView.Adapter<RecyclerViewCreditAdaptor.RecyclerViewCreditHolder>{

    private ArrayList<SetterGetterCredit> listdata;

    public RecyclerViewCreditAdaptor(ArrayList<SetterGetterCredit> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public RecyclerViewCreditHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_credit,parent, false);
        RecyclerViewCreditAdaptor.RecyclerViewCreditHolder holder = new RecyclerViewCreditAdaptor.RecyclerViewCreditHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCreditHolder holder, int position) {

        final SetterGetterCredit getData = listdata.get(position);
        String nama_Credit = getData.getNamaCredit();
        String contribusi_Credit = getData.getContribusiCredit();

        holder.nama_credit.setText(nama_Credit);
        holder.kontribusi_credit.setText(contribusi_Credit);


    }

    @Override
    public int getItemCount() {

        return listdata.size();
    }

    public class RecyclerViewCreditHolder extends RecyclerView.ViewHolder {

        TextView nama_credit;
        TextView kontribusi_credit;

        ConstraintLayout constraintLayout;

        public RecyclerViewCreditHolder(@NonNull View itemView) {
            super(itemView);

            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.credit_item_layout);

            nama_credit = itemView.findViewById(R.id.tv_nama_credit);
            kontribusi_credit = itemView.findViewById(R.id.tv_kontribusi_credit);
        }
    }

}
