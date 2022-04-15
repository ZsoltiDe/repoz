package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController implements Initializable {
    Stage stage=new Stage();
    public void setStage(Stage stage){
        this.stage= stage;

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void handleErrorButtonPudhed(ActionEvent event) {
            stage.close();
    }
}
