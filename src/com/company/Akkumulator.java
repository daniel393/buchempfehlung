package com.company;

import java.util.ArrayList;

/**
 * Created by Eike on 16.04.2015.
 */
public class Akkumulator {

    public Akkumulator(){}

    public Basismass akkumulation(Basismass m1, Basismass m2){
        //      Eigenschaft           Elemente        Basismaß
        //      <18                     E,D             0,5
        ArrayList<BasismassEigenschaften> values = new ArrayList<BasismassEigenschaften>();

        for(BasismassEigenschaften eigenschaftenM1 : m1.getValues()){
            for(BasismassEigenschaften eigenschaftenM2 : m2.getValues()){
                values.add(new BasismassEigenschaften(listFusion(eigenschaftenM1.getEigenschaft(),eigenschaftenM2.getEigenschaft()), //Name
                        schnittmenge(eigenschaftenM1.getMenge(),eigenschaftenM2.getMenge()),    //Schnittmenge
                        eigenschaftenM1.getFokaleMenge()* eigenschaftenM2.getFokaleMenge()));   //Multiplikation
            }
        }

        return new Basismass(listFusion(m1.getKategorie(),m2.getKategorie()),values);
    }

    public ArrayList<Basismass> akkumulation(ArrayList<Basismass> list){
        if(list.size()==1){
            return list;
        }
        else {
            list.add(akkumulation(list.get(0), list.get(1)));
            list.remove(1);
            list.remove(0);
            return akkumulation(list);
        }
    }

    private ArrayList<BasismassEigenschaften> merge(ArrayList<BasismassEigenschaften> list){
        ArrayList<BasismassEigenschaften> returnlist= new ArrayList<BasismassEigenschaften>();



        return returnlist;
    }

    private ArrayList<BasismassEigenschaften> konfliktBerechnung(ArrayList<BasismassEigenschaften> list){
        ArrayList<BasismassEigenschaften> returnlist= new ArrayList<BasismassEigenschaften>();



        return returnlist;
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

    private ArrayList<String> listFusion(ArrayList<String> l1, ArrayList<String> l2){
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(l1);
        list.addAll(l2);
        return list;
    }
}
