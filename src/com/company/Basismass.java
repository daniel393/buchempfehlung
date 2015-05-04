package com.company;

import java.util.ArrayList;

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

    public Basismass(ArrayList<String> name){
        this.kategorie=name;
        this.values= new ArrayList<BasismassEigenschaften>();
    }

    private ArrayList<BasismassEigenschaften> calculate(ArrayList<DataOverview> overview){
        return new ArrayList<BasismassEigenschaften>();
    }

    public void print(){
        for(String kat: kategorie){
            System.out.print(kat + " ");
        }
        System.out.println();
        for(BasismassEigenschaften eig: values){
            for(String s: eig.getEigenschaft()){
                System.out.print(s+" ");
            }
            System.out.println();
            for(String element: eig.getMenge()){
                System.out.print(element+" ");
            }
            System.out.println("\n"+ eig.getFokaleMenge());
        }
    }

    public ArrayList<String> getKategorie() {
        return kategorie;
    }

    public ArrayList<BasismassEigenschaften> getValues() {
        return values;
    }
}
