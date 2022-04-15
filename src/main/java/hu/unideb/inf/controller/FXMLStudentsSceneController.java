/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Employee;
import hu.unideb.inf.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.model.Employee;
import hu.unideb.inf.model.EmployeePropertyClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class FXMLStudentsSceneController implements Initializable {
    Stage PrimaryStage;
    Model model= new Model();
    Stage SecondaryStage= new Stage();
    MainApp main= new MainApp();
    public void setStage(Stage stage){
        this.PrimaryStage= stage;

    }

    public void setMain(MainApp main) {
        this.main = main;
    }




    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private TableColumn<Employee, String> firstNameField;

    @FXML
    private TableColumn<Employee, String> lastNameField;

    @FXML
    private TableView<Employee> TableView;

    @FXML
    private TextField address;

    @FXML
    private TextField dateOfBirdth;

    @FXML
    private TextField education;

    @FXML
    private TextField emailAddress;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    void handleSaveButtonPushed(ActionEvent event) throws Exception {
        if(IsValide()){
            model.setEmployee(new Employee());
            model.getEmployee().setFirstName(firstName.getText());
            model.getEmployee().setLastName(lastName.getText());
            model.getEmployee().setAdress(address.getText());
            model.getEmployee().setDateOfBirth(dateOfBirdth.getText());
            model.getEmployee().setEducation(education.getText());
            model.getEmployee().setEmailAdress(emailAddress.getText());
            model.getEmployee().setPhoneNumber(Integer.parseInt(phoneNumber.getText()));



            model.getJpaDao().Save(model.getEmployee());
            /*model.setPropertyClass(new EmployeePropertyClass());
            model.getPropertyClass().setCredits(Integer.parseInt(Credits.getText()));
            model.getPropertyClass().setName(Name.getText());*/
            model.getObservableList().add(model.getEmployee());
            TableView.refresh();


        }else{
            main.ErrorDialog();
        }

    }
    public boolean IsValide(){
        if(!(firstName.getText().isEmpty())&&!(firstName.getText().isEmpty())){
            return true;
        }else{
            return false;
        }
        
    }
    @FXML
    void handleQuitButtonPushed(ActionEvent event) {
        main.stopDatabase();
        PrimaryStage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        model.loadData();
        firstNameField.setCellValueFactory(CellData-> CellData.getValue().firstNameProperty());//.asObject());
        lastNameField.setCellValueFactory(CellData-> CellData.getValue().lastNameProperty());
        TableView.setItems(model.getObservableList());

    }

}
