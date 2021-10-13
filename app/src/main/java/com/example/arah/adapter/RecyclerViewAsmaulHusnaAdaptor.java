package com.example.arah.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arah.ActivityAsmaulHusnaDetail;
import com.example.arah.R;
import com.example.arah.SetterGetterAsmaulHusna;
import com.example.arah.SetterGetterMenuDashboard;

import java.util.ArrayList;

public class RecyclerViewAsmaulHusnaAdaptor extends RecyclerView.Adapter<RecyclerViewAsmaulHusnaAdaptor.RecyclerViewAsmaulHusnaHolder> {

    private ArrayList<SetterGetterAsmaulHusna> listdata;

    public RecyclerViewAsmaulHusnaAdaptor(ArrayList<SetterGetterAsmaulHusna> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public RecyclerViewAsmaulHusnaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asmaulhusna,parent, false);
        RecyclerViewAsmaulHusnaAdaptor.RecyclerViewAsmaulHusnaHolder holder = new RecyclerViewAsmaulHusnaAdaptor.RecyclerViewAsmaulHusnaHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAsmaulHusnaHolder holder, int position) {


        Context con = holder.itemView.getContext();
        String pac = con.getPackageName();
        Resources res = con.getResources();

        final SetterGetterAsmaulHusna getData = listdata.get(position);
        String noAsmaulHusna = getData.getNo();
        String bacaanAsmaulHusna = getData.getBacaan();
        String artiAsmaulHusna = getData.getArti();
        String ayatAsmaulHusna = getData.getAyat();

        holder.no.setText(noAsmaulHusna);
        holder.bacaan.setText(bacaanAsmaulHusna);
        holder.arti.setText(artiAsmaulHusna);
        holder.ayat.setText(ayatAsmaulHusna);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = null;

                myIntent = new Intent(con, ActivityAsmaulHusnaDetail.class);

                myIntent.putExtra("position", position);
                myIntent.putExtra("ayat", listdata.get(position).getAyat());
                myIntent.putExtra("bacaan", listdata.get(position).getBacaan());
                myIntent.putExtra("arti", listdata.get(position).getArti());
                view.getContext().startActivity(myIntent);

            }
        });

        holder.selengkanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = null;

                myIntent = new Intent(con, ActivityAsmaulHusnaDetail.class);

                myIntent.putExtra("position", position);
                myIntent.putExtra("ayat", listdata.get(position).getAyat());
                myIntent.putExtra("bacaan", listdata.get(position).getBacaan());
                myIntent.putExtra("arti", listdata.get(position).getArti());
                view.getContext().startActivity(myIntent);
            }
        });



    }

    @Override
    public int getItemCount() {

        return listdata.size();
    }

    public class RecyclerViewAsmaulHusnaHolder extends RecyclerView.ViewHolder {

        TextView no;
        TextView bacaan;
        TextView arti;
        TextView ayat;

        CardView cardView;
        ConstraintLayout constraintLayout;

        Button selengkanya;


        public RecyclerViewAsmaulHusnaHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view_asmaulhusna);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.asmaulhusna_item_layout);

            no = itemView.findViewById(R.id.tv_no);
            bacaan = itemView.findViewById(R.id.tv_tittle_besar_item_asmaul_husna);
            arti = itemView.findViewById(R.id.tv_tittle_kecil_item_asmaul_husna);
            ayat = itemView.findViewById(R.id.tv_lafaz_asmaul_husna);

            selengkanya = itemView.findViewById(R.id.button_selengkanya);

        }
    }
}
