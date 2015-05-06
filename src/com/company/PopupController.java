package com.company;

import com.sun.org.omg.CORBA.Initializer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.omg.CORBA.INITIALIZE;

import javax.print.DocFlavor;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by auler on 05.05.2015.
 */


public class PopupController implements Initializable {

    @FXML private javafx.scene.control.Label buchname;
    @FXML private javafx.scene.control.Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buchname.setText(ModelContext.getInstance().getCurrentBooks());
    }

    @FXML
    public void closePopup(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


}
