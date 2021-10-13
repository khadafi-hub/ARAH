package com.example.arah.adapter;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arah.ActivityQuiz;
import com.example.arah.AsmaulHusnaActivity;
import com.example.arah.R;
import com.example.arah.SetterGetterMenuDashboard;
import com.example.arah.UnityHoldedActivity;

import java.util.ArrayList;

public class RecyclerViewDashboardAdapter extends RecyclerView.Adapter<RecyclerViewDashboardAdapter.RecyclerViewDashboardHolder> {

    private ArrayList<SetterGetterMenuDashboard> listdata;

    public RecyclerViewDashboardAdapter(ArrayList<SetterGetterMenuDashboard> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public RecyclerViewDashboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard,parent, false);
        RecyclerViewDashboardHolder holder = new RecyclerViewDashboardHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDashboardHolder holder, int position) {

        Context con = holder.itemView.getContext();
        String pac = con.getPackageName();
        Resources res = con.getResources();

        final SetterGetterMenuDashboard getData = listdata.get(position);
        String tittleMenuDashboard = getData.getTittleMenuDashboard();
        String imgMenuDashboard = getData.getImgMenuDashboard();

        holder.tittle_item_dashboard.setText(tittleMenuDashboard);
        holder.image_item_dashboard.setImageResource(res.getIdentifier(imgMenuDashboard, "drawable", pac));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = null;
                if( holder.tittle_item_dashboard.getText().equals("ASMAUL HUSNA")){
                    myIntent = new Intent(con, AsmaulHusnaActivity.class);
                }
                if( holder.tittle_item_dashboard.getText().equals("QUIZ")){
                    myIntent = new Intent(con, ActivityQuiz.class);
                }
                if( holder.tittle_item_dashboard.getText().equals("AUGMENTED REALITY")){
                    myIntent = new Intent(con, UnityHoldedActivity.class);
                }
//                myIntent.putExtra("position", position);
//                myIntent.putExtra("ayat", values.get(position).getAyat());
//                myIntent.putExtra("bacaan", values.get(position).getBacaan());
//                myIntent.putExtra("arti", values.get(position).getArti());
                view.getContext().startActivity(myIntent);

            }
        });


    }

    @Override
    public int getItemCount() {

        return listdata.size();
    }

    public class RecyclerViewDashboardHolder extends RecyclerView.ViewHolder {

        TextView tittle_item_dashboard;
        ImageView image_item_dashboard;

        CardView cardView;
        ConstraintLayout constraintLayout;


        public RecyclerViewDashboardHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view_dashboard);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.dashboard_item_layout);

            tittle_item_dashboard = itemView.findViewById(R.id.tv_tittle_item_dashboard);
            image_item_dashboard = itemView.findViewById(R.id.iv_item_dashboard);
        }
    }
}