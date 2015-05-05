package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.*;

/**
 * Created by Eike on 16.04.2015.
 */
public class Basismass {

    private ArrayList<String> kategorie;
    //              Eigenschaft            Elemente/Menge   Basismaß
    //              <18                     E,D              0,5
    private ArrayList<BasismassEigenschaften> values;

    public Basismass(ArrayList<String> name,ArrayList<BasismassEigenschaften> sValues){
        this.kategorie= name;
        this.values=sValues;
    }

    public Basismass(DataStruct struct){
        this.kategorie= new ArrayList<String>();
        this.kategorie.add(struct.getName());
        this.values= this.calculate(struct.getDataTemp(),struct.getAmount());

    }

    private ArrayList<BasismassEigenschaften> calculate(HashMap<String,HashMap<String,Integer>> data ,int gesamtanzahl){
        ArrayList<BasismassEigenschaften> list =new ArrayList<BasismassEigenschaften>();


        for(Entry<String,HashMap<String,Integer>> eigenschaft: data.entrySet()){
            ArrayList<String> eigenschaften = new ArrayList<String>();
            int anzahl=0;
            eigenschaften.add((String) eigenschaft.getKey());

            ArrayList<String> menge =new ArrayList<String>();
            for(Entry<String,Integer> entry: eigenschaft.getValue().entrySet()){
                menge.add(entry.getKey());
                anzahl+= (int)entry.getValue();
            }

            BasismassEigenschaften bmeig= new BasismassEigenschaften(eigenschaften,menge, (float)anzahl/gesamtanzahl);
            list.add(bmeig);
        }



        return list;
    }

    public void print(){
        System.out.println("Kategorien:");
        for(String kat: kategorie){
            System.out.print(kat + " ");
        }
        System.out.println("\nMerkmale:");
        for(BasismassEigenschaften eig: values){
            for(String s: eig.getEigenschaft()){
                System.out.print(s+" ");
            }
            System.out.println("\nMenge: ");
            for(String element: eig.getMenge()){
                System.out.print(element+" ");
            }
            System.out.println("\nEvidenz:\n"+ eig.getFokaleMenge());
        }
    }

    public ArrayList<String> getKategorie() {
        return kategorie;
    }

    public ArrayList<BasismassEigenschaften> getValues() {
        return values;
    }
}
