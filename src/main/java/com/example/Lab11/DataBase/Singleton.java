package com.example.Lab11.DataBase;


import com.example.Lab11.DataBase.DataBase;

import java.sql.SQLException;

public class Singleton
{
    static private DataBase dataBase;

    static public DataBase getInstance() throws SQLException {
        if(dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }


}
