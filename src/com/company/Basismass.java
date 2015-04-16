package com.company;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Eike on 16.04.2015.
 */
public class Basismass {

    private DataStruct dataStruct;
    private String merkmal;
    //              Name            Elemente/Menge   Basismaß
    //              <18             E,D              0,5
    private HashMap<String,HashMap<ArrayList<String>,Float>> values;

    public Basismass(String sMerkmal, HashMap<String,HashMap<ArrayList<String>,Float>> sValues){
        this.merkmal=sMerkmal;
        this.values=sValues;
        this.dataStruct=null;
    }

    public Basismass(DataStruct data){
        this.dataStruct= data;
        this.merkmal=data.getName();
        this.values= new HashMap<String,HashMap<ArrayList<String>,Float>>();
        this.calculate();
    }

    private void calculate(){

    }


    public String getMerkmal() {
        return merkmal;
    }

    public HashMap<String,HashMap<ArrayList<String>,Float>> getValues() {
        return values;
    }
}
