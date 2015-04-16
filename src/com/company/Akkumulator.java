package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eike on 16.04.2015.
 */
public class Akkumulator {

    public Akkumulator(){}

    public Basismass akkumulation(Basismass m1, Basismass m2){
        //      Name            Elemente        Basismaß
        //      <18             E,D             0,5
        HashMap<String,HashMap<ArrayList<String>,Float>> map = new HashMap<String,HashMap<ArrayList<String>,Float>>();
        for(Map.Entry<String,HashMap<ArrayList<String>,Float>> m1NameEntry: m1.getValues().entrySet()){
            for(Map.Entry<ArrayList<String>,Float> m1ValueEntry: m1NameEntry.getValue().entrySet()){
                //alle Teile aus m1 sind verfügbar
                for(Map.Entry<String,HashMap<ArrayList<String>,Float>> m2NameEntry: m2.getValues().entrySet()){
                    for(Map.Entry<ArrayList<String>,Float> m2ValueEntry: m2NameEntry.getValue().entrySet()){
                        //alle Teile aus m2 sind verfügbar
                        HashMap<ArrayList<String>,Float> elementeUndMass = new HashMap<ArrayList<String>,Float>();
                        elementeUndMass.put(schnittmenge(m1ValueEntry.getKey(),m2ValueEntry.getKey()),m1ValueEntry.getValue()*m2ValueEntry.getValue());
                        map.put( m1NameEntry.getKey()+ "+"+ m1NameEntry.getKey(),elementeUndMass);
                    }
                }
            }
        }
        return new Basismass(m1.getMerkmal()+ "+" + m2.getMerkmal(),map);
    }

    private ArrayList<String> schnittmenge(ArrayList<String> l1, ArrayList<String> l2){
        ArrayList<String> list= new ArrayList<String>();

        for (String s1 : l1){
            for(String s2: l2){
                if(s1.equals(s2)){
                    list.add(s1);
                }
            }
        }

        return list;
    }
}
