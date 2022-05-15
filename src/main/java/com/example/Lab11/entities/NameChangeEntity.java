package com.example.Lab11.entities;

public class NameChangeEntity {
    private String newFamilyName, newPersonalName, cnp;

    public String getNewFamilyName() {
        return newFamilyName;
    }

    public void setNewFamilyName(String newFamilyName) {
        this.newFamilyName = newFamilyName;
    }

    public String getNewPersonalName() {
        return newPersonalName;
    }

    public void setNewPersonalName(String newPersonalName) {
        this.newPersonalName = newPersonalName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public NameChangeEntity(String newFamilyName, String newPersonalName, String cnp) {
        this.newFamilyName = newFamilyName;
        this.newPersonalName = newPersonalName;
        this.cnp = cnp;
    }
}
