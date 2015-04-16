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
    //Menge , Basismaß
    private HashMap<ArrayList<String>,Float> values;

    public Basismass(DataStruct data){
        this.dataStruct= data;
        this.merkmal=data.getName();
        this.values= new HashMap<ArrayList<String>,Float>();
        this.calculate();
    }

    private void calculate(){
        ArrayList<String> list= new ArrayList<String>();
        list.add("A");
        list.add("C");
        list.add("B");
        this.values.put(list, (float) 0.65);

    }
}
