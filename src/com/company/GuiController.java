package com.company;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.beans.EventHandler;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

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


    public void buchempfehlung(ActionEvent actionEvent) throws IOException {


        //Add Values
        auswahl.put(1, (String) cb1.getValue());
        auswahl.put(2, (String) cb2.getValue());
        auswahl.put(3, (String) cb3.getValue());
        auswahl.put(4, (String) cb4.getValue());
        auswahl.put(5, (String) cb5.getValue());
        auswahl.put(6, (String) cb6.getValue());
        auswahl.put(7, (String) cb7.getValue());

        //Parameter f�r Berechnungen
        ArrayList<DataStruct> listOfStructs = new ArrayList<>();
        ArrayList<Basismass> listOfBasismass = new ArrayList<>();

        //ArrayList<String> Kategorien = new ArrayList<>();
        ArrayList<String> merkmale = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : auswahl.entrySet()) {
            if (entry.getValue() != null) {
                merkmale.add(entry.getValue());
                listOfStructs.add(new DataStruct((entry.getKey() - 1)));
            }
        }
        for (DataStruct struct : listOfStructs) {
            struct.assignData(pars.getsList());
            //struct.printData();
            listOfBasismass.add(new Basismass(struct));
        }
        //Akkumulation
        Akkumulator akku = new Akkumulator();
        akku.akkumulation(listOfBasismass);

        BasismassStruct bms = listOfBasismass.get(0).getDataOfAttributes(merkmale);

        if (bms != null) {
            bms.print();
        } else {
            System.out.println("Aufgrund der vorhandenen Daten kann keine Buchempfehlung ausgesprochen werden");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Ihre Empfehlung");
        stage.setScene(new Scene(root1));
        stage.show();
        //System.out.print("Klick");
    }

    public void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void newInstance(ActionEvent actionEvent) {

    }

    
}


