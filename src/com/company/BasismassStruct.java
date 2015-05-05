package com.company;

import java.util.ArrayList;

/**
 * Created by holle on 04.05.2015.
 * Hilfsklasse f�r Basisma�e
 */
public class BasismassStruct {

    private ArrayList<String> eigenschaft;
    private ArrayList<String> menge;
    private float evidenz;

    /**
     * Datenstruktur f�r die Struktur des Basisma�es. Enth�lt die Eigenschaft die Verwendet wird, die Menge der empfohlenen B�cher daf�r
     * und die zugeh�rigen fokalen Mengen bzw. Evidenzen
     * @param eigenschaft
     * @param menge
     * @param evidenz
     */
    public BasismassStruct(ArrayList<String> eigenschaft, ArrayList<String> menge, float evidenz) {
        this.eigenschaft = eigenschaft;
        this.menge = menge;
        this.evidenz = evidenz;
    }


    public ArrayList<String> getEigenschaft() {
        return eigenschaft;
    }

    public ArrayList<String> getMenge() {
        return menge;
    }

    public float getEvidenz() {
        return evidenz;
    }

    public void setEvidenz(float evidenz) {
        this.evidenz = evidenz;
    }
}
