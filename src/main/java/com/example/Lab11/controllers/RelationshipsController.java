package com.example.Lab11.controllers;

import com.example.Lab11.dao.RelationshipDAO;
import com.example.Lab11.entities.PersonEntity;
import com.example.Lab11.entities.RelationshipEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipsController {

    @GetMapping
    public List<RelationshipEntity> getAllRelationships() throws SQLException {
        return RelationshipDAO.getAllRelationships();
    }

    @PostMapping
    public void insertRelationship(@RequestParam("cnp1") String cnp1, @RequestParam("cnp2") String cnp2) throws SQLException {
        RelationshipDAO.addRelationship(cnp1,cnp2);
    }

    @GetMapping("/popular")
    public List<PersonEntity> getMostPopularUsers(@RequestParam("numberOfUsers") int numberOfUsers) throws SQLException {
        return RelationshipDAO.getMostPopular(numberOfUsers);
    }

}
