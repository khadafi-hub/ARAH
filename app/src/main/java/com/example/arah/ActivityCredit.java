package com.example.arah;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arah.adapter.RecyclerViewCreditAdaptor;

import java.util.ArrayList;


public class ActivityCredit extends Activity {



    RecyclerView recycleviewCredit;
    ArrayList<SetterGetterCredit> dataCredit;

    GridLayoutManager gridLayoutManager;
    RecyclerViewCreditAdaptor RecyclerViewCreditAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


        recycleviewCredit = findViewById(R.id.recycleview_credit);

        addData();
        gridLayoutManager = new GridLayoutManager(this, 1);
        recycleviewCredit.setLayoutManager(gridLayoutManager);

        RecyclerViewCreditAdapter = new RecyclerViewCreditAdaptor(dataCredit);
        recycleviewCredit.setAdapter(RecyclerViewCreditAdapter);


    }

    public void addData() {
        dataCredit = new ArrayList<>();
        dataCredit.add(new SetterGetterCredit("Herika Hayurani S.Kom M.Kom", "Pembimbing Ilmu"));
        dataCredit.add(new SetterGetterCredit("Stasiun TV TVRI", "Lagu Asmaul Husna"));
        dataCredit.add(new SetterGetterCredit("Muhammad Ilham Mahdi", "Dubber SFX Asmaul Husna"));
        dataCredit.add(new SetterGetterCredit("T. Supartinah", "Sumber Informasi : Asmaul Husna 1001 Solusi Hidup Dunia (2015)"));
        dataCredit.add(new SetterGetterCredit("S. T. B. Al-Jerrahi", "Sumber Informasi : Asmaul Husna Makna dan Khasiat (2007)"));

    }


}