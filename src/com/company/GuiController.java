package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by auler on 05.05.2015.
 */
public class GuiController {

    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    private String fileToRead="E011.csv";

    private Parser pars;
    private ArrayList<ChoiceBox> listCb;
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
    }


    public void buchempfehlung(ActionEvent actionEvent) throws IOException {
        pars = new Parser(fileToRead);
        ArrayList<ChoiceBox> listCb = new ArrayList<ChoiceBox>();
        listCb.add(cb1);
        listCb.add(cb2);
        listCb.add(cb3);
        listCb.add(cb4);
        listCb.add(cb5);
        listCb.add(cb6);
        listCb.add(cb7);

        BasismassStruct bms = null;

        for(int a=0;a<listCb.size();a++){
            if(listCb.get(a).getValue()==null) {
                auswahl.put(a, null);
            }else if(listCb.get(a).getValue().toString().equals("-")){
                auswahl.put(a, null);
            }else{
                auswahl.put(a, (String) (listCb.get(a).getValue()));
            }

        }

        //Parameter f�r Berechnungen
        ArrayList<DataStruct> listOfStructs = new ArrayList<>();
        ArrayList<Basismass> listOfBasismass = new ArrayList<>();

        //ArrayList<String> Kategorien = new ArrayList<>();
        ArrayList<String> merkmale = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : auswahl.entrySet()) {
            if (entry.getValue() != null) {
                merkmale.add(entry.getValue());
                listOfStructs.add(new DataStruct((entry.getKey())));
            }
        }

        if(merkmale.size()>0){
            for (DataStruct struct : listOfStructs) {
                struct.assignData(pars.getsList());
                //struct.printData();
                listOfBasismass.add(new Basismass(struct));
            }
            //Akkumulation
            Akkumulator akku = new Akkumulator();
            akku.akkumulation(listOfBasismass);

            bms = listOfBasismass.get(0).getDataOfAttributes(merkmale);
        }

        if (bms != null) {
            bms.print();
        } else {
            ModelContext.getInstance().setBooks("Keine Empfehlung.");
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

        File file = fileChooser.showOpenDialog(Main.stage);
        if (file != null) {
            this.fileToRead=file.toString();
            //openFile(file);
        }
    }

    private void openFile(File file) {
        try {
            desktop.open(file);

        } catch (IOException ex) {

        }
    }
}


