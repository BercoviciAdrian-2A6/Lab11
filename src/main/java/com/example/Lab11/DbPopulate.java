package com.example.Lab11;

import com.example.Lab11.dao.PersonDAO;
import com.example.Lab11.dao.RelationshipDAO;

import java.sql.SQLException;

public class DbPopulate
{
    public static void populate() throws SQLException
    {
        PersonDAO.empty();

        PersonDAO.addPerson("adi", "berco", "AdiBerco97");
        PersonDAO.addPerson("antonio", "fechita", "fechitaaa01");
        PersonDAO.addPerson("john", "smith", "johnsmith");
        PersonDAO.addPerson("andrei", "popa", "AndreiPopa");
        PersonDAO.addPerson("stefan", "celmare", "StefanCelMare");
        PersonDAO.addPerson("gigel", "stefanescu", "capitanu");
        PersonDAO.addPerson("marioara", "popescu", "Marioara123");
        PersonDAO.addPerson("ultimu", "ultimescu", "Ulimescu");

        RelationshipDAO.empty();

        RelationshipDAO.addRelationship("AdiBerco97", "johnsmith");
        RelationshipDAO.addRelationship("AdiBerco97", "fechitaaa01");
        RelationshipDAO.addRelationship("AdiBerco97", "StefanCelMare");
        RelationshipDAO.addRelationship("AdiBerco97", "capitanu");
        RelationshipDAO.addRelationship("AdiBerco97", "Ulimescu");
        RelationshipDAO.addRelationship("AdiBerco97", "Marioara123");
        RelationshipDAO.addRelationship("AdiBerco97", "AndreiPopa");

        RelationshipDAO.addRelationship("fechitaaa01", "johnsmith");
        RelationshipDAO.addRelationship("fechitaaa01", "Marioara123");
        RelationshipDAO.addRelationship("fechitaaa01", "StefanCelMare");


        RelationshipDAO.addRelationship("Marioara123", "Ulimescu");
        RelationshipDAO.addRelationship("Marioara123", "capitanu");
    }
}
