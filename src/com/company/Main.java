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

        //Akkumulation
        Akkumulator akku = new Akkumulator();

        //1. Basismaﬂ
        ArrayList<String> kategorie1 = new ArrayList<String>();
        kategorie1.add("Haarfarbe");
        //eigenschaften.add("Groesse");
        ArrayList<BasismassEigenschaften> basis1 = new ArrayList<BasismassEigenschaften>();
        //Blonde
        ArrayList<String> eigenschaft1A = new ArrayList<String>();
        eigenschaft1A.add("blond");
        ArrayList<String> buchliste1A = new ArrayList<String>();
        buchliste1A.add("A");
        buchliste1A.add("B");
        BasismassEigenschaften e1A = new BasismassEigenschaften(eigenschaft1A,buchliste1A,(float)0.5);
        basis1.add(e1A);

        //Braune
        ArrayList<String> eigenschaft1B = new ArrayList<String>();
        eigenschaft1B.add("braun");
        ArrayList<String> buchliste1B = new ArrayList<String>();
        buchliste1B.add("C");
        buchliste1B.add("D");
        BasismassEigenschaften e1B = new BasismassEigenschaften(eigenschaft1B,buchliste1B,(float)0.7);
        basis1.add(e1B);
        
        
        Basismass mass1 = new Basismass(kategorie1,basis1);
        System.out.println();
        mass1.print();

        //2. Basismaﬂ
        ArrayList<String> kategorie2 = new ArrayList<String>();
        kategorie2.add("Augenfarbe");
        //eigenschaften.add("Groesse");
        ArrayList<BasismassEigenschaften> basis2 = new ArrayList<BasismassEigenschaften>();
        ArrayList<String> eigenschaft2 = new ArrayList<String>();
        eigenschaft2.add("blau");
        ArrayList<String> buchliste2 = new ArrayList<String>();
        buchliste2.add("C");
        buchliste2.add("B");
        BasismassEigenschaften e2 = new BasismassEigenschaften(eigenschaft2,buchliste2,(float)0.25);
        basis2.add(e2);
        Basismass mass2 = new Basismass(kategorie2,basis2);
        System.out.println();
        mass2.print();

        //akkumuliert
        System.out.println();
        akku.akkumulation(mass1,mass2).print();

    }
}
