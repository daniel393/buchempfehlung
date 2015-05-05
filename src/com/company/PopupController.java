package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by auler on 05.05.2015.
 */


public class PopupController {

    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    public void closePopup(ActionEvent actionEvent) {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
    }
}
