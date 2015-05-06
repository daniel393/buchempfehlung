package com.company;

import java.util.ArrayList;

/**
 * Created by holle on 04.05.2015.
 * Hilfsklasse für Basismaße
 */
public class BasismassStruct {

    private ArrayList<String> merkmal;
    private ArrayList<String> menge;
    private float evidenz;
    private ArrayList buecher = new ArrayList<>();

    /**
     * Datenstruktur für die Struktur des Basismaßes. Enthält die Eigenschaft die Verwendet wird, die Menge der empfohlenen Bücher dafür
     * und die zugehörigen fokalen Mengen bzw. Evidenzen
     * @param merkmal
     * @param menge
     * @param evidenz
     */
    public BasismassStruct(ArrayList<String> merkmal, ArrayList<String> menge, float evidenz) {
        this.merkmal = merkmal;
        this.menge = menge;
        this.evidenz = evidenz;
    }

    public void print(){
        System.out.println("\nMerkmale:");
        for(String s: this.merkmal){
            System.out.print(s+" ");
        }
        System.out.println("\nMenge: ");
        for(String element: this.menge){
            buecher.add(element);
            System.out.print(element+" ");
        }
        ModelContext.getInstance().setBooks(buecher.toString().replace("[", "").replace("]", ""));
        System.out.println("\nEvidenz:\n"+ this.evidenz);
    }

    public ArrayList<String> getMerkmal() {
        return merkmal;
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
