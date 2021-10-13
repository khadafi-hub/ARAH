package com.example.arah;

import android.util.Log;

public class SetterGetterCredit {

    private static final String TAG = "pemeriksaan sg";
    String namaCredit;
    String contribusiCredit;

    public SetterGetterCredit(String namaCredit, String contribusiCredit) {
        this.namaCredit = namaCredit;
        this.contribusiCredit = contribusiCredit;
    }

    public String getNamaCredit() { return namaCredit;
    }

    public void setNamaCredit(String namaCredit) {
        this.namaCredit = namaCredit;
    }

    public String getContribusiCredit() {
        return contribusiCredit;
    }

    public void setContribusiCredit(String contribusiCredit) {
        this.contribusiCredit = contribusiCredit;
    }
}
