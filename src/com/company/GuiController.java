package com.company;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by auler on 05.05.2015.
 */
public class GuiController {

    private final Parser pars;
    public ChoiceBox cb1;
    public ChoiceBox cb2;
    public ChoiceBox cb3;
    public ChoiceBox cb4;
    public ChoiceBox cb5;
    public ChoiceBox cb6;
    public ChoiceBox cb7;

    private HashMap<Integer,String> auswahl;

    public GuiController() throws IOException {
        auswahl= new HashMap<Integer,String>();

        pars = new Parser("E011.csv");
    }


    public void buchempfehlung(ActionEvent actionEvent) {

        //Add Values
        auswahl.put(1, (String) cb1.getValue());
        auswahl.put(2, (String) cb2.getValue());
        auswahl.put(3, (String) cb3.getValue());
        auswahl.put(4, (String) cb4.getValue());
        auswahl.put(5, (String) cb5.getValue());
        auswahl.put(6, (String) cb6.getValue());
        auswahl.put(7, (String) cb7.getValue());

        //Parameter für Berechnungen
        ArrayList<DataStruct> listOfStructs = new ArrayList<>();
        ArrayList<Basismass> listOfBasismass = new ArrayList<>();

        //ArrayList<String> Kategorien = new ArrayList<>();
        ArrayList<String> merkmale = new ArrayList<>();
        for(Map.Entry<Integer,String> entry: auswahl.entrySet()){
            if(entry.getValue()!=null){
                merkmale.add(entry.getValue());
                listOfStructs.add(new DataStruct((entry.getKey()-1)));
            }
        }
        for(DataStruct struct: listOfStructs){
            struct.assignData(pars.getsList());
            //struct.printData();
            listOfBasismass.add(new Basismass(struct));
        }
        //Akkumulation
        Akkumulator akku = new Akkumulator();
        akku.akkumulation(listOfBasismass);

        BasismassStruct bms = listOfBasismass.get(0).getDataOfAttributes(merkmale);

        if(bms!=null){
            bms.print();
        }
        else{
            System.out.println("Aufgrund der vorhandenen Daten kann keine Buchempfehlung ausgesprochen werden");
        }

        //System.out.print("Klick");
    }

    
}
