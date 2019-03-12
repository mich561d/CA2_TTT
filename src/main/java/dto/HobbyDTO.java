/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Person;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HobbyDTO {
    private int id;
    private String name, description;
    private List<Person> persons;

    public HobbyDTO(int id, String name, String description, List<Person> persons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
    
}
