package com.company;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.beans.EventHandler;
import java.time.Duration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by auler on 05.05.2015.
 */
public class GuiController {

    public void buchempfehlung(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Ihre Empfehlung");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void newInstance(ActionEvent actionEvent) {

    }
}


