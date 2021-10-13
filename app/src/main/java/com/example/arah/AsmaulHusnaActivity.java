package com.example.arah;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arah.adapter.RecyclerViewAsmaulHusnaAdaptor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AsmaulHusnaActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RecyclerView recycleviewAsmaulHusna;
    ArrayList<SetterGetterAsmaulHusna> dataAsmaulHusna;

    GridLayoutManager gridLayoutManager;
    RecyclerViewAsmaulHusnaAdaptor recyclerAsmaulHusnaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmaul_husna);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycleviewAsmaulHusna = findViewById(R.id.recycleview_menu_asmaulhusna);

        addData();

        gridLayoutManager = new GridLayoutManager(this, 1);
        recycleviewAsmaulHusna.setLayoutManager(gridLayoutManager);

        recyclerAsmaulHusnaAdapter = new RecyclerViewAsmaulHusnaAdaptor(dataAsmaulHusna);
        recycleviewAsmaulHusna.setAdapter(recyclerAsmaulHusnaAdapter);



        mediaPlayer = MediaPlayer.create(AsmaulHusnaActivity.this, R.raw.asmaul_husna);

        FloatingActionButton fab = findViewById(R.id.fabAsmaulHusna);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    fab.setImageDrawable((getResources(). getDrawable(R.drawable.ic_play)));
                } else {
                    mediaPlayer.start();
                    Toast.makeText(AsmaulHusnaActivity.this, "Credit to Stasiun TV TVRI", Toast.LENGTH_SHORT).show();
                    fab.setImageDrawable((getResources(). getDrawable(R.drawable.ic_pause)));
                }
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }




    public void addData(){
        dataAsmaulHusna = new ArrayList<>();
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("","الله","Allah","Allah"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("1", "الرحمن", "Ar Rahman", "Yang Maha Pengasih"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("2", "الرحيم", "Ar Rahiim", "Yang Maha Penyayang"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("3", "الملك", "Al Malik", "Yang Maha Merajai / Memerintah"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("4", "القدوس", "Al Quddus", "Yang Maha Suci"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("5", "السلام", "As Salaam", "Yang Maha Memberi Kesejahteraan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("6", "المؤمن", "Al Mu`min", "Yang Maha Memberi Keamanan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("7", "المهيمن", "Al Muhaimin", "Yang Maha Pemelihara"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("8", "العزيز", "Al `Aziiz", "Yang Maha PerkasaYang Maha Perkasa"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("9", "الجبار", "Al Jabbar", "Yang Memiliki Mutlak Kegagahan"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("10", "المتكبر", "Al Mutakabbir", "Yang Maha Megah, Yang Memiliki Kebesaran"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("11", "الخالق", "Al Khaliq", "Yang Maha Pencipta"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("12", "البارئ", "Al Baari`", "Yang Maha Melepaskan (Membuat, Membentuk, Menyeimbangkan)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("13", "المصور", "Al Mushawwir", "Yang Maha Membentuk Rupa (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("14", "الغفار", "Al Ghaffaar", "Yang Maha Pengampun"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("15", "القهار", "Al Qahhaar", "Yang Maha Menundukan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("16", "الوهاب", "Al Wahhaab", "Yang Maha Pemberi Karunia"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("17", "الرزاق", "Ar Razzaaq", "Yang Maha Pemberi Rezeki"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("18", "الفتاح", "Al Fattaah", "Yang Maha Pembuka Rahmat"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("19", "العليم", "Al `Aliim", "Yang Maha Mengetahui (Memiliki Ilmu)"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("20", "القابض", "Al Qaabidh", "Yang Maha Menyempitkan (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("21", "الباسط", "Al Baasith", "Yang Maha Melapangkan (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("22", "الخافض", "Al Khaafidh", "Yang Maha Merendahkan (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("23", "الرافع", "Ar Raafi`", "Yang Maha Meninggikan (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("24", "المعز", "Al Mu`izz", "Yang Maha Memuliakan (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("25", "المذل", "Al Mudzil", "Yang Maha Menghinakan (makhluknya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("26", "السميع", "Al Samii`", "Yang Maha Mendengar"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("27", "البصير", "Al Bashiir", "Yang Maha Melihat"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("28", "الحكم,", "Al Hakam", "Yang Maha Menetapkan"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("29", "العدل", "Al `Adl", "Yang Maha Adil"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("30", "اللطيف", "Al Lathiif", "Yang Maha Lembut"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("31", "الخبير", "Al Khabiir", "Yang Maha Mengenal"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("32", "الحليم", "Al Haliim", "Yang Maha Penyantun"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("33", "العظيم", "Al `Azhiim", "Yang Maha Agung"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("34", "الغفور", "Al Ghafuur", "Yang Maha Memberi Pengampunan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("35", "الشكور", "As Syakuur", "Yang Maha Pembalas Budi (Menghargai)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("36", "العلى", "Al `Aliy", "Yang Maha Tinggi"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("37", "الكبير", "Al Kabiir", "Maha Besar"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("38", "الحفيظ", "Al Hafizh", "Yang Maha Memelihara"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("39", "المقيت", "Al Muqiit", "Yang Maha Pemberi Kecukupan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("40", "الحسيب", "Al Hasiib", "Yang Maha Membuat Perhitungan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("41", "الجليل", "Al Jaliil", "Yang Maha Luhur"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("42", "الكريم", "Al Kariim", "Yang Maha Pemurah"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("43", "الرقيب", "Ar Raqiib", "Yang Maha Mengawasi"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("44", "المجيب", "Al Mujiib", "Yang Maha Mengabulkan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("45", "الواسع", "Al Waasi`", "Yang Maha Luas"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("46", "الحكيم", "Al Hakim", "Yang Maha Bijaksana"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("47", "الودود", "Al Waduud", "Yang Maha Mengasihi"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("48", "المجيد", "Al Majiid", "Yang Maha Mulia"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("49", "الباعث", "Al Baa`its", "Yang Maha Membangkitkan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("50", "الشهيد", "As Syahiid", "Yang Maha Menyaksikan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("51", "الحق", "Al Haqq", "Yang Maha Benar"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("52", "الوكيل", "Al Wakiil", "Yang Maha Memelihara"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("53", "القوى", "Al Qawiyyu", "Yang Maha Kuat"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("54", "المتين", "Al Matiin", "Yang Maha Kokoh"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("55", "الولى", "Al Waliyy", "Yang Maha Melindungi"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("56", "الحميد", "Al Hamiid", "Yang Maha Terpuji"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("57", "المحصى", "Al Muhshii", "Yang Maha Mengalkulasi (Menghitung Segala Sesuatu)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("58", "المبدئ", "Al Mubdi`", "Yang Maha Memulai"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("59", "المعيد", "Al Mu`iid", "Yang Maha Mengembalikan Kehidupan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("60", "المحيى", "Al Muhyii", "Yang Maha Menghidupkan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("61", "المميت", "Al Mumiitu", "Yang Maha Mematikan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("62", "الحي", "Al Hayyu", "Yang Maha Hidup"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("63", "القيوم", "Al Qayyuum", "Yang Maha Mandiri"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("64", "الواجد", "Al Waajid", "Yang Maha Penemu"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("65", "الماجد", "Al Maajid", "Yang Maha Mulia"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("66", "الواحد", "Al Wahid", "Yang Maha Tunggal"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("67", "الاحد", "Al Ahad", "Yang Maha Esa"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("68", "الصمد", "As Shamad", "Yang Maha Dibutuhkan, Tempat Meminta"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("69", "القادر", "Al Qaadir", "Yang Maha Menentukan, Maha Menyeimbangkan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("70", "المقتدر", "Al Muqtadir", "Yang Maha Berkuasa"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("71", "المقدم", "Al Muqaddim", "Allah Yang Maha Mendahulukan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("72", "المؤخر", "Al Mu`akkhir", "Yang Maha Mengakhirkan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("73", "الأول", "Al Awwal", "Yang Maha Awal"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("74", "الأخر", "Al Aakhir", "Yang Maha Akhir"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("75", "الظاهر", "Az Zhaahir", "Yang Maha Nyata"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("76", "الباطن", "Al Baathin", "Yang Maha Ghaib"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("77", "الوالي", "Al Waali", "Yang Maha Memerintah"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("78", "المتعالي", "Al Muta`aalii", "Yang Maha Tinggi"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("79", "البر", "Al Barru", "Yang Maha Penderma (Maha Pemberi Kebajikan)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("80", "التواب", "At Tawwaab", "Yang Maha Penerima Tobat"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("81", "المنتقم", "Al Muntaqim", "Yang Maha Pemberi Balasan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("82", "العفو", "Al Afuww", "Yang Maha Pemaaf"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("83", "الرؤوف", "Ar Ra`uuf", "Yang Maha Pengasuh"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("84", "مالك الملك", "Malikul Mulk", "Yang Maha Penguasa Kerajaan (Semesta)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("85", "ذو الجلال و الإكرام", "Dzul Jalaali Wal Ikraam", "Yang Maha Pemilik Kebesaran dan Kemuliaan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("86", "المقسط", "Al Muqsith", "Yang Maha Pemberi Keadilan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("87", "الجامع", "Al Jamii`", "Yang Maha Mengumpulkan"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("88", "الغنى", "Al Ghaniyy", "Yang Maha Kaya"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("89", "المغنى", "Al Mughnii", "Yang Maha Pemberi Kekayaan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("90", "المانع", "Al Maani", "Yang Maha Mencegah"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("91", "الضار", "Ad Dhaar", "Yang Maha Penimpa Kemudharatan"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("92", "النافع", "An Nafii`", "Yang Maha Memberi Manfaat"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("93", "النور", "An Nuur", "Yang Maha Bercahaya (Menerangi, Memberi Cahaya)"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("94", "الهادئ", "Al Haadii", "Yang Maha Pemberi Petunjuk"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("95", "البديع", "Al Badii’", "Yang Maha Pencipta Yang Tiada Bandingannya"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("96", "الباقي", "Al Baaqii", "Yang Maha Kekal"));

        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("97", "الوارث", "Al Waarits", "Yang Maha Pewaris"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("98", "الرشيد", "Ar Rasyiid", "Yang Maha Pandai"));
        dataAsmaulHusna.add(new SetterGetterAsmaulHusna("99", "الصبور", "As Shabuur", "Yang Maha Sabar"));




    }



    //Tombol Kembali
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(myIntent, 0);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
