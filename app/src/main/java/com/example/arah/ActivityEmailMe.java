package com.example.arah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arah.adapter.RecyclerViewCreditAdaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityEmailMe extends Activity {

    Button kirim,hapus;
    EditText nama,email,subjek,pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_me);

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
        nama = (EditText) this.findViewById(R.id.et_nama);
        email = (EditText) this.findViewById(R.id.et_email);
        subjek = (EditText) this.findViewById(R.id.et_subjek);
        pesan = (EditText) this.findViewById(R.id.et_pesan);

        kirim = (Button) this.findViewById(R.id.button_kirim);
        kirim.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(nama.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ActivityEmailMe.this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

                } else if(subjek.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ActivityEmailMe.this, "Subjek Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

                } else if(pesan.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(ActivityEmailMe.this, "Pesan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

                } else {
                    kirimEmail();
                    Toast.makeText(ActivityEmailMe.this, "Pesan Terkirim", Toast.LENGTH_SHORT).show();
                }

            }
        });

        hapus = (Button) this.findViewById(R.id.button_hapus);
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clear();
                Toast.makeText(ActivityEmailMe.this, "Menghapus Semua", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void kirimEmail() {
        String fromEmail = "botemailapk@gmail.com";
        String fromPassword = "Dafi99@@";
        String toEmails = "ddafi272@gmail.com";
        List<String> toEmailList = Arrays.asList(toEmails
                .split("\\s*,\\s*"));
        Log.i("SendMailActivity", "To List: " + toEmailList);
        String emailSubject = subjek.getText().toString();

        String split[] = pesan.getText().toString().split("\\r?\\n");
        String body = "";
        for (String value: split){
            body += value+"<br>";
        }
        String emailBody = "Nama : "+ nama.getText().toString()+ "Email : "+ email.getText().toString()+ "<br> Pesan : <br>" + body;
        new SendMail(ActivityEmailMe.this).execute(fromEmail,fromPassword, toEmailList, emailSubject, emailBody);
    }

    public void clear(){
        nama.setText("");
        email.setText("");
        subjek.setText("");
        pesan.setText("");
    }
}