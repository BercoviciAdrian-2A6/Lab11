package com.example.Lab11.entities;

import java.io.Serializable;

public class PersonEntity implements Serializable
{
    private int id;
    private String familyName, personalName, cnp;// CNP can be better seen as a username - an unique identifier that the user knows

    public PersonEntity(int id, String familyName, String personalName, String cnp)
    {
        this.id = id;
        this.familyName = familyName;
        this.personalName = personalName;
        this.cnp = cnp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", personalName='" + personalName + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
