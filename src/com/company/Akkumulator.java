package com.company;

import java.util.ArrayList;

/**
 * Created by Eike on 16.04.2015.
 */
public class Akkumulator {

    public Akkumulator(){}

    public Basismass akkumulation(Basismass m1, Basismass m2){
        //      Name            Elemente        Basismaß
        //      <18             E,D             0,5

        return new Basismass(new ArrayList<String[]>());
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
