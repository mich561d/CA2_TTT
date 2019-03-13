package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h")
    ,@NamedQuery(name = "Hobby.FindByID", query = "SELECT h FROM Hobby h WHERE h.id = :id")
    , @NamedQuery(name = "HobbyDTO.findByName", query = "SELECT NEW dto.HobbyDTO(h.id, h.name, h.description) FROM Hobby h WHERE h.name = :name")})
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name, description;
    @ManyToMany
    private List<Person> persons;

    public Hobby() {
    }

    public Hobby(String name, String description, List<Person> persons) {
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    
    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String toSql() {
        return "INSERT INTO HOBBY (NAME,DESCRIPTION) VALUES ('" + this.name + "','" + this.description + "');\n";
    }
}
