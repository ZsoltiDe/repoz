package hu.unideb.inf.model;

import javafx.beans.property.*;

public class EmployeePropertyClass {
    private StringProperty name= new SimpleStringProperty();
    private IntegerProperty credits= new SimpleIntegerProperty();





    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public int getCredits() {
        return credits.getValue();
    }

    public void setCredits(int credits) {
        this.credits.setValue(credits);
    }
    public StringProperty NameProperty() {
        return name;
    }
    public IntegerProperty CreditsProperty(){
        return credits;
    }
}


