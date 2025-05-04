package com.yaggod.budgetcontrolsystem;

import com.yaggod.budgetcontrolsystem.model.Person;
import com.yaggod.budgetcontrolsystem.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessObject
{
    private static DataAccessObject Instance;

    private Connection  connection;

    public static DataAccessObject GetInstance()
    {
        if(Instance == null)
            Instance = new DataAccessObject();

        return Instance;
    }


    private DataAccessObject()
    {
        Init();
    }



    void Init(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:budgetsystem.sqlite");

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE if not exists 'Persons' ( 'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  'FullName' TEXT NOT NULL);");
            statement.execute("CREATE TABLE if not exists 'Transactions' ( 'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  'PersonId' INTEGER NOT NULL, 'Difference' INTEGER NOT NULL, 'Date' INTEGER NOT NULL);");
            statement.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    void AddPerson(String name)
    {
        try
        {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO Persons (FullName) VALUES ('" +  name + "');");
        statement.close();
        }
        catch(Exception e) {}
    }

    public List<Person> GetPersons() throws SQLException
    {
        ArrayList<Person> result = new ArrayList<Person>();

        String sql = "SELECT *  FROM Persons";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("Id");
            String name = resultSet.getString("FullName");
            result.add(new Person(id, name));
        }

        return result;
    }


    public void AddTransaction(int personId, int difference, long date)
    {
        try
        {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Transactions (PersonId, Difference, Date) VALUES ('"+ personId + "', '" + difference + "', '" + date + "');");
            statement.close();
        }
        catch(Exception e) {}
    }

    public ArrayList<Transaction> GetTransactions() throws SQLException
    {
        ArrayList<Transaction> result = new ArrayList<Transaction>();

        String sql = "SELECT Persons.FullName, Transactions.Difference, Transactions.Date FROM Transactions Transactions JOIN Persons Persons ON Transactions.PersonId = Persons.Id;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String name = resultSet.getString("FullName");
            int difference = resultSet.getInt("Difference");
            long date = resultSet.getLong("Date");
            result.add(new Transaction(name, difference, new Date(date)));
        }

        return result;
    }
}
