package com.example.Lab11.dao;

import com.example.Lab11.DataBase.Singleton;
import com.example.Lab11.entities.PersonEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO
{
    public static List<PersonEntity> getPersons() throws SQLException
    {
        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        ResultSet queryResult = statement.executeQuery("select * from persons");

        ArrayList<PersonEntity> persons = new ArrayList<>();

        while (queryResult.next())
        {
            persons.add( new PersonEntity(
                    queryResult.getInt("id"),
                    queryResult.getString("family_name"),
                    queryResult.getString("personal_name"),
                    queryResult.getString("cnp")) );
        }

        return persons;
    }

    public static int getNewPersonId() throws SQLException {
        Connection db_connection = Singleton.getInstance().getConnection();
        Statement statement = db_connection.createStatement();

        int maxId = 0;

        ResultSet resultSet = statement.executeQuery("select max(id) as \"max\" from persons");
        if(resultSet.next()){
            maxId = resultSet.getInt("max");
        }
        return maxId + 1;
    }

    public static void addPerson(String familyName, String personalName, String cnp) throws SQLException
    {
        Connection db_connection = Singleton.getInstance().getConnection();
        Statement statement = db_connection.createStatement();
        statement.execute("insert into persons (id, family_name, personal_name, cnp) values (" + getNewPersonId() + ", \'" + familyName + "\', \'" + personalName + "\', \'" + cnp + "\')");
    }

    public static void updatePerson(String targetPersonCnp, String newFamilyName, String newPersonalName)
    {
        //todo
    }

    public static void deletePerson(String targetPersonCnp)
    {

    }

    public static PersonEntity getPersonByCnp(String cnp) throws SQLException
    {
        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        ResultSet queryResult = statement.executeQuery("select * from persons where cnp = \'" + cnp + "\'");

        if (queryResult.next())
        return new PersonEntity(
                queryResult.getInt("id"),
                queryResult.getString("family_name"),
                queryResult.getString("personal_name"),
                queryResult.getString("cnp"));

        return null;
    }

    public static PersonEntity getPersonById(int id) throws SQLException {
        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        ResultSet queryResult = statement.executeQuery("select * from persons where id = " + id + "");

        if (queryResult.next())
        return new PersonEntity(
                queryResult.getInt("id"),
                queryResult.getString("family_name"),
                queryResult.getString("personal_name"),
                queryResult.getString("cnp"));

        return null;
    }

    public static void empty() throws SQLException
    {
        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        statement.execute("truncate table persons cascade");
    }
}
