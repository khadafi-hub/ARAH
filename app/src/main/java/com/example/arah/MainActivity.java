package com.example.arah;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.example.arah.adapter.RecyclerViewDashboardAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RecyclerView menuDashboard;
    ArrayList<SetterGetterMenuDashboard> dataMenuDashboard;

    GridLayoutManager gridLayoutManager;
    RecyclerViewDashboardAdapter recyclerViewDashboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuDashboard = findViewById(R.id.recycleview_menu_dashboard);

        addData();
        gridLayoutManager = new GridLayoutManager(this, 1);
        menuDashboard.setLayoutManager(gridLayoutManager);

        recyclerViewDashboardAdapter = new RecyclerViewDashboardAdapter(dataMenuDashboard);
        menuDashboard.setAdapter(recyclerViewDashboardAdapter);



        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.asmaul_husna);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    fab.setImageDrawable((getResources(). getDrawable(R.drawable.ic_play)));
                } else {
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this, "Credit to Stasiun TV TVRI", Toast.LENGTH_SHORT).show();
                    fab.setImageDrawable((getResources(). getDrawable(R.drawable.ic_pause)));
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent i = new Intent(getApplicationContext(), ActivityAbout.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_credit) {
            Intent i = new Intent(getApplicationContext(), ActivityCredit.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_emailme) {
            Intent i = new Intent(getApplicationContext(), ActivityEmailMe.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addData(){
        dataMenuDashboard = new ArrayList<>();
        dataMenuDashboard.add(new SetterGetterMenuDashboard("AUGMENTED REALITY", "ic_allah"));
        dataMenuDashboard.add(new SetterGetterMenuDashboard("ASMAUL HUSNA", "ic_alquran"));
        //dataMenuDashboard.add(new SetterGetterMenuDashboard("KAIDAH ASMAUL HUSNA", "ic_namaallah"));
        dataMenuDashboard.add(new SetterGetterMenuDashboard("QUIZ", "ic_quiz"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // return to the App's Home Activity
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(MainActivity.this);
            alBuilder.setMessage("Apa kamu ingin menutup aplikasi ini ?");
            alBuilder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent keluar = new Intent(Intent.ACTION_MAIN);
                    keluar.addCategory(Intent.CATEGORY_HOME);
                    keluar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(keluar);
                }
            }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            final AlertDialog dialog;

            dialog = alBuilder.create();
            dialog.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}