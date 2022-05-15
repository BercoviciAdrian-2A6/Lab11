package com.example.Lab11;

import com.example.Lab11.dao.PersonDAO;
import com.example.Lab11.dao.RelationshipDAO;

import java.sql.SQLException;

public class Main
{
    public static void main( String[] args ) throws SQLException {
        DbPopulate.populate();

        System.out.println(PersonDAO.getPersons());

        System.out.println(RelationshipDAO.getAllRelationships());

        System.out.println( RelationshipDAO.getMostPopular(2) );
    }
}
