package com.company;

import java.util.ArrayList;

/**
 * Created by Eike on 16.04.2015.
 */
public class Basismass {

    private String name;
    //              Name            Elemente/Menge   Basismaß
    //              <18             E,D              0,5
    private ArrayList<String[]> values;

    public Basismass(ArrayList<String[]> sValues){
        this.values=sValues;
    }

    public Basismass(String sName, ArrayList<DataOverview> overview){
        this.name =sName;
        this.values= new ArrayList<String[]>();
        this.calculate(overview);
    }

    private ArrayList<String[]> calculate(ArrayList<DataOverview> overview){
        return new ArrayList<String[]>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<String[]> getValues() {
        return values;
    }
}
