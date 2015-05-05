package com.company;

import java.util.ArrayList;

/**
 * Created by Eike on 16.04.2015.
 * Akkumuliert die gegebenen Basismaße
 */
public class Akkumulator {

    public Akkumulator(){}

    /**
     * Akkumulation der Basismaße m1 und m2
     * @param m1
     * @param m2
     * @return
     */
    public Basismass akkumulation(Basismass m1, Basismass m2){

        ArrayList<BasismassStruct> values = new ArrayList<BasismassStruct>();

        for(BasismassStruct eigenschaftenM1 : m1.getValues()){
            for(BasismassStruct eigenschaftenM2 : m2.getValues()){
                values.add(new BasismassStruct(listFusion(eigenschaftenM1.getEigenschaft(),eigenschaftenM2.getEigenschaft()), //Name
                        schnittmenge(eigenschaftenM1.getMenge(),eigenschaftenM2.getMenge()),    //Schnittmenge
                        eigenschaftenM1.getEvidenz()* eigenschaftenM2.getEvidenz()));   //Multiplikation
            }
        }

        //values = merge(values); //merged list of values
        values = korrekturBerechnung(values);
        //Gibt akkumuliertes Basismaß zurück
        return new Basismass(listFusion(m1.getKategorie(),m2.getKategorie()),values);
    }

    /**
     * Akkumulation mehrere Basismaße (rekursiv)
     * @param list
     * @return
     */
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


    // Evtl. nicht nötig

    /**
     * merged Evidenzen gleicher Mengen
     * @param list
     * @return
     */
    private ArrayList<BasismassStruct> merge(ArrayList<BasismassStruct> list){

        ArrayList<BasismassStruct> returnList = new ArrayList<BasismassStruct>(list);
        for(int i=list.size()-1;i>=0;i--){
            if(i==0)continue;
            if(list.get(i).getMenge().containsAll(list.get(i-1).getMenge()) && //i Enthält alle Elemente aus Menge i-1
                    list.get(i).getMenge().size()==list.get(i-1).getMenge().size()){  //i hat die größe von i-1
                returnList.get(i - 1).setEvidenz(returnList.get(i - 1).getEvidenz() + returnList.get(i).getEvidenz()); // fokale Menge = fm(i) + fm(i-1)
                returnList.remove(i);
            }

        }

        return returnList;
    }

    /**
     *Berechnet den Konflikt der Auftritt und korregiert die anderen Werte
     * @param list
     * @return
     */
    private ArrayList<BasismassStruct> korrekturBerechnung(ArrayList<BasismassStruct> list){
        float konflikt=0;
        ArrayList<BasismassStruct> returnList = new ArrayList<BasismassStruct>(list);
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i).getMenge().isEmpty()){
                konflikt+= list.get(i).getEvidenz();
                returnList.remove(i);
            }
        }
        float korrektur= (1/1-konflikt);

        for(BasismassStruct bme: returnList){
            bme.setEvidenz(bme.getEvidenz() * korrektur);
        }

        return returnList;
    }

    /**
     * Bildet Schnettmenge der beiden Listen
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * Fusioniert beide listen zu neuer
     * @param l1
     * @param l2
     * @return
     */
    private ArrayList<String> listFusion(ArrayList<String> l1, ArrayList<String> l2){
        ArrayList<String> list = new ArrayList<String>(l1);
        list.addAll(l2);
        return list;
    }
}
