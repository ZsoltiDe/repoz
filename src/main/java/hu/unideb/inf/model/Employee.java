/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import javafx.beans.property.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

/**
 *
 * @author admin
 */
@Entity
public class  Employee{
    @Id
    @GeneratedValue
    private int id;
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName= new SimpleStringProperty();
    private ObjectProperty dateOfBirth= new SimpleObjectProperty();
    private StringProperty adress= new SimpleStringProperty();
    private StringProperty emailAdress= new SimpleStringProperty();
    private IntegerProperty phoneNumber= new SimpleIntegerProperty();
    private StringProperty education = new SimpleStringProperty();

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }


    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getAdress() {
        return adress.get();
    }

    public StringProperty adressProperty() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public String getDateOfBirth() {
        return dateOfBirth.get().toString();
    }

    public ObjectProperty dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalTime dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getEmailAdress() {
        return emailAdress.get();
    }

    public StringProperty emailAdressProperty() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress.set(emailAdress);
    }

    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public IntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEducation() {
        return education.get();
    }

    public StringProperty educationProperty() {
        return education;
    }

    public void setEducation(String education) {
        this.education.set(education);
    }
    /*private int credits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }*/

    
    
}
