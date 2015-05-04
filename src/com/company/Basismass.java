package com.company;

import java.util.ArrayList;

/**
 * Created by Eike on 16.04.2015.
 */
public class Basismass {

    private String kategorie;
    //              Eigenschaft            Elemente/Menge   Basismaß
    //              <18             E,D              0,5
    private ArrayList<BasismassEigenschaften> values;

    public Basismass(String name,ArrayList<BasismassEigenschaften> sValues){
        this.values=sValues;
    }

    public Basismass(String name){
        this.kategorie=name;
        this.values= new ArrayList<BasismassEigenschaften>();
    }

    private ArrayList<BasismassEigenschaften> calculate(ArrayList<DataOverview> overview){
        return new ArrayList<BasismassEigenschaften>();
    }

    public String getKategorie() {
        return kategorie;
    }

    public ArrayList<BasismassEigenschaften> getValues() {
        return values;
    }
}
