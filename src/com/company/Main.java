package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Parser pars = new Parser("E011.csv");

        ArrayList<DataStruct> listOfStructs = new ArrayList<>();
        ArrayList<Basismass> listOfBasismass = new ArrayList<>();

        //Zuweisen der Daten zu mehreren Basisma�en
        for(int i=0;i<2;i++){
            listOfStructs.add(new DataStruct(i));
        }
        for(DataStruct struct: listOfStructs){
            struct.assignData(pars.getsList());
            //struct.printData();
            listOfBasismass.add(new Basismass(struct));
        }

        //Akkumulation
        Akkumulator akku = new Akkumulator();
        akku.akkumulation(listOfBasismass);
        listOfBasismass.get(0).print();

        ArrayList<String> list = new ArrayList<>();
        list.add(">65");
        list.add("w");

        System.out.println("Tetst bla");
        listOfBasismass.get(0).getDataOfAttributes(list).print();
    }
}
