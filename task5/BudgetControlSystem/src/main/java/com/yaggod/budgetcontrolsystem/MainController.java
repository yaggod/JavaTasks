package com.yaggod.budgetcontrolsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    private DataAccessObject _dao;


    @FXML
    protected void onHelloButtonClick() {
        _dao = new DataAccessObject();
    }

    @FXML
    protected void Exit()
    {
        System.exit(0);
    }
}