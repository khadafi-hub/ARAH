package com.example.arah;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class ActivityQuizSession extends AppCompatActivity {

    CardView cvScore;
    Button button_Selesai_Quiz;


    ArrayList<String> soal = new ArrayList<>();
    ArrayList<ArrayList<String>> jawaban = new ArrayList<>(4);
    ArrayList<String> cloneJawaban = new ArrayList<>();
    HashMap<ArrayList<String>, String> mapSoalJawaban = new HashMap<ArrayList<String>, String>();


    ArrayList<String> courseNames = new ArrayList<>();
    ArrayList<String> newCourseNames = new ArrayList<>();
    HashMap<String, String> map = new HashMap<String, String>();






    int index;

    Random random;
    String[] answer = new String[5];


    CardView cvSoal, pilihan1, pilihan2, pilihan3, pilihan4, cvNomorSoal;
    TextView tvPilihan1, tvPilihan2, tvPilihan3, tvPilihan4;

    TextView tvNomor, tvSoal, tvScore, tvJumlahSoal, tvJumlahBenar, tvJumlahSalah, tvNoSoal, tvNoJumlahSoal;

    int score;
    int jumlahSoal;
    int jumlahBenar;
    int jumlahSalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_session);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cvScore = findViewById(R.id.cv_score);
        button_Selesai_Quiz = findViewById(R.id.button_selesai_quiz);
        cvSoal = findViewById(R.id.cv_soal);
        cvNomorSoal = findViewById(R.id.cv_nomor_soal);
        pilihan1 = findViewById(R.id.cv_pilihan_1);
        pilihan2 = findViewById(R.id.cv_pilihan_2);
        pilihan3 = findViewById(R.id.cv_pilihan_3);
        pilihan4 = findViewById(R.id.cv_pilihan_4);
        tvPilihan1 = findViewById(R.id.tv_pilihan_1);
        tvPilihan2 = findViewById(R.id.tv_pilihan_2);
        tvPilihan3 = findViewById(R.id.tv_pilihan_3);
        tvPilihan4 = findViewById(R.id.tv_pilihan_4);
        tvNomor = findViewById(R.id.tv_nomor);
        tvSoal = findViewById(R.id.tv_soal);
        tvNoSoal = findViewById(R.id.textView2);
        tvNoJumlahSoal = findViewById(R.id.textView4);
        tvScore = findViewById(R.id.tv_score);
        tvJumlahSoal = findViewById(R.id.tv_jumlah_soal);
        tvJumlahBenar = findViewById(R.id.tv_jumlah_benar);
        tvJumlahSalah = findViewById(R.id.tv_jumlah_salah);

        button_Selesai_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = null;
                myIntent = new Intent(ActivityQuizSession.this, ActivityQuiz.class);
                startActivity(myIntent);

            }
        });

        soal.add("Berapa jumlah Asmaul Husna yang diajarkan dalam Islam ?");
        soal.add("Apa itu Asmaul Husna ?");
        soal.add("Allah SWT adalah zat yang paling kekal. tidak ada sesuatu pun setelah-Nya. Tatkala semua makhluk, bumi seisinya hancur lebur, Allah SWT tetap ada dan kekal. Hal ini merupakan gambaran dari salah satu Asmaul Husna yaitu?");
        soal.add("Yang mana kah di bawah ini yang merupakan Asmaul Husna yang ada di urutan terakhir?");
        soal.add("Berikut di bawah ini yang merupakan sifat yang mencerminkan seorang muslim meneladani Asmaul Husna \"Ar-Rahman\" di kehidupan sehari-harinya? ");

        for(int i = 0; i < 5; i++) {
            jawaban.add(new ArrayList());
        }
        jawaban.get(0).add("99");
        jawaban.get(0).add("88");
        jawaban.get(0).add("77");
        jawaban.get(0).add("66");

        jawaban.get(1).add("Nama dan sifat baik Allah SWT");
        jawaban.get(1).add("Kumpulan nama nabi dan rasul");
        jawaban.get(1).add("Nama malaikat beserta tugasnya");
        jawaban.get(1).add("Perintah dan larangan");

        jawaban.get(2).add("Al-Baaqii");
        jawaban.get(2).add("Ar-Razzaaq");
        jawaban.get(2).add("Al-Samii'");
        jawaban.get(2).add("Al-Kabiir");

        jawaban.get(3).add("As-Shabuur");
        jawaban.get(3).add("Ar-Rahman");
        jawaban.get(3).add("Az-Zhaahir");
        jawaban.get(3).add("At-Tawwaab");

        jawaban.get(4).add("Menjadi orang yang selalu mengasihi antar sesama mahkluk hidup");
        jawaban.get(4).add("Memiliki sifat toleransi yang tinggi");
        jawaban.get(4).add("Tidak menyombongkan diri");
        jawaban.get(4).add("Tidak membuat kerusakan di muka bumi");



        mapSoalJawaban.put(jawaban.get(0), soal.get(0));
        mapSoalJawaban.put(jawaban.get(1), soal.get(1));
        mapSoalJawaban.put(jawaban.get(2), soal.get(2));
        mapSoalJawaban.put(jawaban.get(3), soal.get(3));
        mapSoalJawaban.put(jawaban.get(4), soal.get(4));


        Log.d("map test", String.valueOf(mapSoalJawaban));

//        courseNames.add("99");
//        courseNames.add("Nama dan sifat baik Allah SWT");
//        courseNames.add("Al-Akhir");
//        courseNames.add("As-Shabuur");
//        courseNames.add("Menjadi orang yang selalu mengasihi antar sesama mahkluk hidup");
        index = 0;

//        map.put(courseNames.get(0), "Berapa jumlah Asmaul Husna yang diajarkan dalam Islam ?");
//        map.put(courseNames.get(1), "Apa itu Asmaul Husna ?");
//        map.put(courseNames.get(2), "Allah SWT adalah zat yang paling kekal. tidak ada sesuatu pun setelah-Nya. Tatkala semua makhluk, bumi seisinya hancur lebur, Allah SWT tetap ada dan kekal. Hal ini merupakan gambaran dari salah satu Asmaul Husna yaitu?");
//        map.put(courseNames.get(3), "Yang mana kah di bawah ini yang merupakan Asmaul Husna yang ada di urutan terakhir?");
//        map.put(courseNames.get(4), "Berikut di bawah ini yang merupakan sifat yang mencerminkan seorang muslim meneladani Asmaul Husna \"Ar-Rahman\" di kehidupan sehari-harinya? ");
        Collections.shuffle(jawaban);
        random = new Random();
        generateQuestions(index);



    }

    private void generateQuestions(int index) {
        String soalText = mapSoalJawaban.get(jawaban.get(index)); // get soal
        //String soal = map.get(courseNames.get(index)); // get soal
        cvScore.setVisibility(View.GONE);
        button_Selesai_Quiz.setVisibility(View.GONE);
        tvNomor.setText(Integer.toString(index+1));
        tvNoSoal.setText(Integer.toString(index+1));
        tvNoJumlahSoal.setText(Integer.toString(soal.size()));
        tvSoal.setText(soalText);

        cloneJawaban = (ArrayList<String>) jawaban.get(index).clone();
        cloneJawaban.remove(0);
        Collections.shuffle(cloneJawaban);

//        newCourseNames = (ArrayList<String>) courseNames.clone(); // clone jawaban
//        newCourseNames.remove(index); // remove the corect answer
//        Collections.shuffle(newCourseNames); // to get the incorect answer and reshuffle it

        int correctAnswerPosition = random.nextInt(3); //2
        int j =0;
        for (int i = 0; i < 4 ; i++){
            if(i == correctAnswerPosition){
                answer[i] = jawaban.get(index).get(0);
            } else {
                if(j < cloneJawaban.size()){
                    answer[i] = cloneJawaban.get(j);
                    j++;
                }



            }

        }
        tvPilihan1.setText(answer[0]);
        tvPilihan2.setText(answer[1]);
        tvPilihan3.setText(answer[2]);
        tvPilihan4.setText(answer[3]);

        newCourseNames.clear();


    }

    public void answerSelected(View view){

        CardView card = (CardView) view;
        String answer = ((TextView)card.getChildAt(0)).getText().toString();

        jumlahSoal = soal.size();
        tvJumlahSoal.setText(Integer.toString(jumlahSoal));
        if(answer.equalsIgnoreCase(jawaban.get(index).get(0))){
            jumlahBenar++;
            score += 20;

        }else {
            jumlahSalah++;

        }
        index++;

        tvJumlahBenar.setText(Integer.toString(jumlahBenar));
        tvScore.setText(Integer.toString(score));
        tvJumlahSalah.setText(Integer.toString(jumlahSalah));

        if(index > soal.size()-1){
            cvSoal.setVisibility(View.GONE);
            pilihan1.setVisibility(View.GONE);
            pilihan2.setVisibility(View.GONE);
            pilihan3.setVisibility(View.GONE);
            pilihan4.setVisibility(View.GONE);
            cvNomorSoal.setVisibility(View.GONE);

            cvScore.setVisibility(View.VISIBLE);
            button_Selesai_Quiz.setVisibility(View.VISIBLE);

        } else {
            generateQuestions(index);
        }
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