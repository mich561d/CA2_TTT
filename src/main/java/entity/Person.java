package entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@DiscriminatorValue("PERSON")
public class Person extends InfoEntity {

    private static final long serialVersionUID = 1L;
    private String firstName, lastName;
    @ManyToMany(mappedBy = "persons")
    private List<Hobby> hobbies;

    public Person() {
    }

    public Person(String firstName, String lastName, List<Hobby> hobbies, String email, List<Phone> phones, Address address) {
        super(email, phones, address);
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

}
