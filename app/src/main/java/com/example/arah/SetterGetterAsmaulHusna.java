package com.example.arah;

public class SetterGetterAsmaulHusna {

    String no;
    String ayat;
    String bacaan;
    String arti;

    public SetterGetterAsmaulHusna(String no, String ayat, String bacaan, String arti) {
        this.no = no;
        this.ayat = ayat;
        this.bacaan = bacaan;
        this.arti = arti;
    }

    public String getNo() {

        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getBacaan() {
        return bacaan;
    }

    public void setBacaan(String bacaan) {
        this.bacaan = bacaan;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }
}
