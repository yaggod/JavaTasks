package com.yaggod.budgetcontrolsystem.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Transaction {
    public SimpleStringProperty personName;
    public SimpleIntegerProperty difference;
    public SimpleStringProperty date;

    public Transaction(SimpleStringProperty personName, SimpleIntegerProperty difference, SimpleStringProperty date) {
        this.personName = personName;
        this.difference = difference;
        this.date = date;
    }

    public Transaction(String personName, int difference, Date date) {
        this(new SimpleStringProperty(personName), new SimpleIntegerProperty(difference), new SimpleStringProperty(date.toString()));
    }

    public String getPersonName() {
        return personName.get();
    }

    public int getDifference() {
        return difference.get();
    }

    public String getDate() {
        return date.get();
    }
}
