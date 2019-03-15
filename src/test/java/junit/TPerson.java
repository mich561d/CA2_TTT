package junit;

import entity.Company;
import entity.Person;
import facade.FCompany;
import facade.FPerson;
import generateData.Generator2;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Michael
 */
public class TPerson {

    FPerson facade;

    @Before
    public void setup() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test");
        facade = new FPerson(emf);
        Generator2 generator = new Generator2(emf);
        List<Person> persons = generator.generateExactTestPersonData();
        List<Company> companies = generator.generateExactTestCompanyData();
        for (int i = 0; i < persons.size(); i++) {
            facade.createPerson(persons.get(i));
        }
        FCompany fCompany = new FCompany(emf);
        for (int i = 0; i < companies.size(); i++) {
            fCompany.createCompany(companies.get(i));
        }
    }

    @Test
    public void getPersonByID() {
    }

    @Test
    public void getPersonByEmail() {
    }

    @Test
    public void getPersonByPhone() {
    }

    @Test
    public void getAllPersons() {
    }

    @Test
    public void getAllPersonsByHobby() {
    }

    @Test
    public void getAllPersonsByCity() {
    }

    @Test
    public void getAllPersonsByAddress() {
    }

    @Test
    public void createPerson() {
    }

    @Test
    public void updatePerson() {
    }

    @Test
    public void deletePerson() {
    }
}
