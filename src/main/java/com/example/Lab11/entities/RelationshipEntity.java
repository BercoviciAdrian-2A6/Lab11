package com.example.Lab11.entities;

import java.io.Serializable;

public class RelationshipEntity implements Serializable
{
    private int id;
    private PersonEntity personA, personB;

    public RelationshipEntity(int id, PersonEntity personA, PersonEntity personB) {
        this.id = id;
        this.personA = personA;
        this.personB = personB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonEntity getPersonA() {
        return personA;
    }

    public void setPersonA(PersonEntity personA) {
        this.personA = personA;
    }

    public PersonEntity getPersonB() {
        return personB;
    }

    public void setPersonB(PersonEntity personB) {
        this.personB = personB;
    }

    @Override
    public String toString() {
        return "RelationshipEntity{" +
                "id=" + id +
                ", personA=" + personA +
                ", personB=" + personB +
                '}';
    }
}
