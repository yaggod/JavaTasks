package com.yaggod.budgetcontrolsystem;

import java.sql.*;

public class DataAccessObject
{
    Connection  connection;

    public DataAccessObject()
    {
        Init();
    }

    void Init(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:budgetsystem.sqlite");

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE if not exists 'Persons' ( 'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  'FullName' TEXT NOT NULL);");
            statement.execute("CREATE TABLE if not exists 'Transactions' ( 'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  'PersonId' INTEGER NOT NULL, 'Difference' INTEGER NOT NULL, 'Date' INTEGER NOT NULL);");

        }catch (Exception e){
            System.out.println(e);
        }
    }






}
