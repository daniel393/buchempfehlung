package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Parser pars = new Parser("E011.csv");


        //Alter
        DataStruct alter= new DataStruct(0);
        alter.assignData(pars.getsList());
        alter.printData();


        //Geschlecht
        DataStruct geschlecht= new DataStruct(1);
        geschlecht.assignData(pars.getsList());
        geschlecht.printData();

        //Verheiratet
        DataStruct verheiratet= new DataStruct(2);
        verheiratet.assignData(pars.getsList());
        verheiratet.printData();

        //Kinderzahl
        DataStruct kinder= new DataStruct(3);
        kinder.assignData(pars.getsList());
        kinder.printData();

        //Abschluss
        DataStruct abschluss= new DataStruct(4);
        abschluss.assignData(pars.getsList());
        abschluss.printData();

        //Beruf
        DataStruct beruf= new DataStruct(5);
        beruf.assignData(pars.getsList());
        beruf.printData();

        //Einkommen
        DataStruct einkommen= new DataStruct(6);
        einkommen.assignData(pars.getsList());
        einkommen.printData();


        /*
        //Ausgabe aller Items einzeln
        for(String[] s : pars.getsList()){
            for(int i=0;i<8;i++){
                System.out.println(s[i]);
            }
        }
        */



    }
}
