package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.beans.EventHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


    public class Main  extends Application   {

        public static Stage stage;

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
            primaryStage.setTitle("Buchempfehlung");
            primaryStage.setScene(new Scene(root, 361, 433));
            primaryStage.show();
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("icon.png"));
            root.setStyle("-fx-background-image: url('bg.jpg')");
            //root.setStyle("-fx-background-color: #B8B8B8");
            stage = primaryStage;
        }

    public static void main(String[] args) throws IOException {
        // write your code here
        /*
        Parser pars = new Parser("E011.csv");

        ArrayList<DataStruct> listOfStructs = new ArrayList<>();
        ArrayList<Basismass> listOfBasismass = new ArrayList<>();

        //Zuweisen der Daten zu mehreren Basismaﬂen
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
        */
        // starting GUI
        launch(args);
    }




}
