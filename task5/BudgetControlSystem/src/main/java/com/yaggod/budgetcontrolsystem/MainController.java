package com.yaggod.budgetcontrolsystem;

import com.yaggod.budgetcontrolsystem.model.Person;
import com.yaggod.budgetcontrolsystem.model.Transaction;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class MainController
{
    @FXML
    TextField DifferenceField;

    @FXML
    TableView<Transaction> TransactionsTable;

    @FXML
    ComboBox<Person> PersonsComboBox;

    public void initialize()
    {
        UpdateTable();
    }


    @FXML
    protected void Exit()
    {
        System.exit(0);
    }

    @FXML
    protected void OpenPersonCreationWindow() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("useradder-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Main Window");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void UpdatePersons()
    {
        try
        {
            PersonsComboBox.setItems(FXCollections.observableArrayList(DataAccessObject.GetInstance().GetPersons()));
        }
        catch(Exception e) {}
    }

    @FXML
    protected void Submit(ActionEvent actionEvent)
    {
        try {
            Person person = PersonsComboBox.getSelectionModel().getSelectedItem();
            int difference = Integer.parseInt(DifferenceField.getText());
            long date = System.currentTimeMillis();
            DataAccessObject.GetInstance().AddTransaction(person.id(), difference, date);
            UpdateTable();
        }
        catch(Exception e) {}
    }

    protected void UpdateTable()
    {
        try {
            TransactionsTable.getColumns().clear();
            ArrayList<Transaction> transactions = DataAccessObject.GetInstance().GetTransactions();

            TableColumn<Transaction, String> nameColumn = new TableColumn<>("Имя");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("personName"));
            TableColumn<Transaction, Integer> diffrerenceColumn = new TableColumn<>("Изменения баланса");
            diffrerenceColumn.setCellValueFactory(new PropertyValueFactory<>("difference"));
            TableColumn<Transaction, Date> dateColumn = new TableColumn<>("Дата");
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

            TransactionsTable.getColumns().addAll(nameColumn, diffrerenceColumn, dateColumn);
            TransactionsTable.setItems(FXCollections.observableArrayList(transactions));
        }
        catch(Exception e) {}
    }
}