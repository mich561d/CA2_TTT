package junit;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import dto.PhoneDTO;
import entity.Address;
import entity.Company;
import entity.Person;
import entity.Phone;
import static entity.db.Hobby_.persons;
import static entity.db.InfoEntity_.email;
import facade.FCityInfo;
import facade.FCompany;
import facade.FPerson;
import generateData.Generator2;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Christian
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
        Person person = facade.getPersonByID(1);
        assertNotNull(person);

    }

    @Test
    public void getPersonByEmail() {
        Person p = facade.getPersonByID(5);
        PersonDTO person = facade.getPersonByEmail(p.getEmail());
        assertNotNull(email);

    }

    @Test
    public void getPersonByPhone() {
        Person p = facade.getPersonByID(7);
        PersonDTO phone = facade.getPersonByPhone((PhoneDTO) p.getPhones());
        assertNotNull(phone);
    }

    @Test
    public void getAllPersons() {
        List<PersonDTO> persons = facade.getAllPersons();
        assertEquals(100, persons.size());
    }

    @Test
    public void getAllPersonsByHobby() {
        List<PersonDTO> person = facade.getAllPersonsByHobbyName("progamming");
        assertEquals(9, person.size());
    }

    @Test
    public void getAllPersonsByCity() {
        List<PersonDTO> person = facade.getAllPersonsByCity(new CityInfoDTO(14, "2600", "Glostrup"));
        assertEquals(10, person.size());

    }

    @Test
    public void getAllPersonsByAddress() {
        List<PersonDTO> person = facade.getAllPersonsByAddress(new AddressDTO(1, "Personstreet", "Number: 0"));
        assertEquals(1, person.size());
    }

    @Test
    public void createPerson() {
        List<HobbyDTO> hobby = new ArrayList();
        //Person p = new Person("Test", "Testsen", hobby, "test@test.dk", "12345678", "Testervej 1");
    }

    @Test
    public void updatePerson() {
    }

    @Test
    public void deletePerson() {
    }
}
