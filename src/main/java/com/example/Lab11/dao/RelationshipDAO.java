package com.example.Lab11.dao;

import com.example.Lab11.DataBase.Singleton;
import com.example.Lab11.PersonPopularityIndexer;
import com.example.Lab11.entities.PersonEntity;
import com.example.Lab11.entities.RelationshipEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class RelationshipDAO
{
    public static int getNewRelationshipId() throws SQLException {
        Connection db_connection = Singleton.getInstance().getConnection();
        Statement statement = db_connection.createStatement();

        int maxId = 0;

        ResultSet resultSet = statement.executeQuery("select max(id) as \"max\" from relationships");
        if(resultSet.next()){
            maxId = resultSet.getInt("max");
        }
        return maxId + 1;
    }

    public static void addRelationship(String cnpA, String cnpB) throws SQLException
    {
        PersonEntity personA = PersonDAO.getPersonByCnp(cnpA);
        PersonEntity personB = PersonDAO.getPersonByCnp(cnpB);

        Connection db_connection = Singleton.getInstance().getConnection();
        Statement statement = db_connection.createStatement();
        statement.execute("insert into relationships (id, person_a_id, person_b_id) values (" + getNewRelationshipId() +  ", " + personA.getId() + ", " + personB.getId() +  ")");
    }

    public static ArrayList<RelationshipEntity> getPersonRelationships(String targetPersonCnp) throws SQLException
    {
        PersonEntity targetPerson = PersonDAO.getPersonByCnp(targetPersonCnp);

        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        ResultSet queryResult = statement.executeQuery("select * from relationships where person_a_id = " + targetPerson.getId() + " or person_b_id = " + targetPerson.getId());

        ArrayList<RelationshipEntity> relationships = new ArrayList<>();

        while (queryResult.next())
        {
            int id = queryResult.getInt("id");
            int idA = queryResult.getInt("person_a_id");
            int idB = queryResult.getInt("person_b_id");

            PersonEntity personA = PersonDAO.getPersonById(idA);
            PersonEntity personB = PersonDAO.getPersonById(idB);

            relationships.add( new RelationshipEntity( id, personA, personB ) );
        }

        return relationships;
    }

    public static ArrayList<PersonEntity> getMostPopular( int k ) throws SQLException
    {
        ArrayList<RelationshipEntity> relationships = getAllRelationships();

        HashMap<String, PersonPopularityIndexer> personPopularityMap = new HashMap<>();

        for (RelationshipEntity relationship: relationships)
        {
            String cnpA = relationship.getPersonA().getCnp();

            String cnpB = relationship.getPersonB().getCnp();

            if (personPopularityMap.containsKey( cnpA ))
            {
                personPopularityMap.get( cnpA ).incrementPopularity();
            }
            else
            {
                personPopularityMap.put( cnpA, new PersonPopularityIndexer( relationship.getPersonA() ) );
            }

            if (personPopularityMap.containsKey( cnpB ))
            {
                personPopularityMap.get( cnpB ).incrementPopularity();
            }
            else
            {
                personPopularityMap.put( cnpB, new PersonPopularityIndexer( relationship.getPersonB() ) );
            }
        }

        ArrayList<PersonPopularityIndexer> popularityIndex = new ArrayList<>();

        for (String cnp: personPopularityMap.keySet())
        {
            popularityIndex.add( personPopularityMap.get(cnp) );
        }

        popularityIndex.sort(Comparator.naturalOrder());

        ArrayList<PersonEntity> mostPopular = new ArrayList<>();

        int min = Math.min(k,popularityIndex.size());
        for (int popIndex = 0; popIndex < min; popIndex++)
        {
            mostPopular.add( popularityIndex.get(popIndex).getPerson() );
        }

        return mostPopular;
    }

    public static ArrayList<RelationshipEntity> getAllRelationships() throws SQLException {
        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        ResultSet queryResult = statement.executeQuery("select * from relationships");

        ArrayList<RelationshipEntity> relationships = new ArrayList<>();

        while (queryResult.next())
        {
            int id = queryResult.getInt("id");
            int idA = queryResult.getInt("person_a_id");
            int idB = queryResult.getInt("person_b_id");

            PersonEntity personA = PersonDAO.getPersonById(idA);
            PersonEntity personB = PersonDAO.getPersonById(idB);

            relationships.add( new RelationshipEntity( id, personA, personB ) );
        }

        return relationships;
    }

    public static void empty() throws SQLException
    {
        Connection db_connection = Singleton.getInstance().getConnection();

        Statement statement = db_connection.createStatement();

        statement.execute("truncate table relationships cascade");
    }
}
