package com.yaggod.budgetcontrolsystem;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserAdderController
{
    @FXML
    TextField NameInput;

    @FXML
    protected void Submit()
    {
        String text = NameInput.getText();
        DataAccessObject.GetInstance().AddPerson(text);

        ((Stage)NameInput.getScene().getWindow()).close();
    }
}
