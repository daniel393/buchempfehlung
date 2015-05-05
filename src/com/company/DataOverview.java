package com.company;

/**
 * Created by holle on 04.05.2015.
 */
public class DataOverview {

    private String merkmal;
    private String buch;
    private int anzahl;

    public DataOverview(String merkmal, String buch, int anzahl) {
        this.merkmal = merkmal;
        this.buch = buch;
        this.anzahl = anzahl;
    }

    public String getMerkmal() {
        return merkmal;
    }

    public String getBuch() {
        return buch;
    }

    public int getAnzahl() {
        return anzahl;
    }
}
