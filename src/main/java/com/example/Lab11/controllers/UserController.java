package com.example.Lab11.controllers;


import com.example.Lab11.dao.PersonDAO;
import com.example.Lab11.entities.NameChangeEntity;
import com.example.Lab11.entities.PersonEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    //localhost:8081/api/users
    @GetMapping
    public List<PersonEntity> getAllUsers() throws SQLException {

        return PersonDAO.getPersons();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postUser(@RequestBody PersonEntity person) throws SQLException {
        PersonDAO.addPerson(person.getFamilyName(),person.getPersonalName(), person.getCnp());

    }

    //localhost:8081/api/users?cnp=AndreiPopa
    @DeleteMapping
    public void deleteByCnp(@RequestParam(value = "cnp") String cnp) throws SQLException {
        PersonDAO.deletePerson(cnp);
    }

    //localhost:8081/api/users?cnp=AndreiPopa
    @PutMapping
    public void updateNameByCnp(@RequestBody NameChangeEntity nameChangeEntity) throws SQLException {
        PersonDAO.updatePerson(nameChangeEntity.getCnp(), nameChangeEntity.getNewFamilyName(), nameChangeEntity.getNewPersonalName());
    }
}
