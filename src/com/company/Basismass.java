package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Map.*;

/**
 * Created by Eike on 16.04.2015.
 * Enthält Basismaß und zugehörige Datenstrukturen um diese zu vereinigen
 */
public class Basismass {

    //Enthält die verwendeten Kategorien
    private ArrayList<String> kategorie;
    //Enthält die Daten für die Einzelnen Eigenschaften/Mengen/Evidenzen
    private ArrayList<BasismassStruct> values;

    /**
     * Erzeugt Basismaß mit Kategorie und den gegebenen Werten
     * @param kategorien
     * @param sValues
     */
    public Basismass(ArrayList<String> kategorien,ArrayList<BasismassStruct> sValues){
        this.kategorie= kategorien;
        this.values=sValues;
    }

    /**
     * Erzeugt Basismaß Struktur aus gegebener Datenstruktur
     * @param struct
     */
    public Basismass(DataStruct struct){
        this.kategorie= new ArrayList<String>();
        this.kategorie.add(struct.getName());
        this.values= this.calculate(struct.getData(),struct.getAmount());

    }

    /**
     * Errechnet die Werte aus den gegebenen Daten aus dem DataStruct
     * @param data
     * @param gesamtanzahl
     * @return
     */
    private ArrayList<BasismassStruct> calculate(HashMap<String,HashMap<String,Integer>> data ,int gesamtanzahl){
        ArrayList<BasismassStruct> list =new ArrayList<BasismassStruct>();

        for(Entry<String,HashMap<String,Integer>> eigenschaft: data.entrySet()){
            ArrayList<String> eigenschaften = new ArrayList<String>();
            int anzahl=0;
            eigenschaften.add((String) eigenschaft.getKey());

            ArrayList<String> menge =new ArrayList<String>();
            for(Entry<String,Integer> entry: eigenschaft.getValue().entrySet()){
                menge.add(entry.getKey());
                anzahl+= (int)entry.getValue();
            }

            BasismassStruct bmeig= new BasismassStruct(eigenschaften,menge, (float)anzahl/gesamtanzahl);
            list.add(bmeig);
        }
        return list;
    }

    /**
     * Gibt Kategorien Merkmale Mengen und Evidenzen aus
     */
    public void print(){
        System.out.println("Kategorien:");
        for(String kat: kategorie){
            System.out.print(kat + " ");
        }
        for(BasismassStruct eig: values){
            System.out.println("\nMerkmale:");
            for(String s: eig.getEigenschaft()){
                System.out.print(s+" ");
            }
            System.out.println("\nMenge: ");
            for(String element: eig.getMenge()){
                System.out.print(element+" ");
            }
            System.out.println("\nEvidenz:\n"+ eig.getEvidenz());
        }
    }

    public ArrayList<String> getKategorie() {
        return kategorie;
    }

    public ArrayList<BasismassStruct> getValues() {
        return values;
    }
}
