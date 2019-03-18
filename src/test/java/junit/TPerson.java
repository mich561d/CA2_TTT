package junit;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import dto.PhoneDTO;
import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.FCityInfo;
import facade.FPerson;
import facade.FPhone;
import generateData.Generator2;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Michael, Christian
 */
public class TPerson {

    private static EntityManagerFactory emf;
    private static FPerson facade;
    private static List<Person> persons;

    @BeforeClass
    public static void setupClass() {
        emf = Persistence.createEntityManagerFactory("pu-test");
        Generator2 generator = new Generator2(emf);
        persons = generator.generateExactTestPersonData();
        facade = new FPerson(emf);
        for (int i = 0; i < persons.size(); i++) {
            facade.createPerson(persons.get(i));
        }
    }

    @Test
    public void getPersonByID() {
        Person person = facade.getPersonByIDRaw(1);
        assertNotNull(person);

    }

    @Test
    public void getPersonByEmail() {
        Person p = facade.getPersonByIDRaw(5);
        PersonDTO person = facade.getPersonByEmail(p.getEmail());
        assertNotNull(person.getEmail());

    }

    @Test
    public void getPersonByPhone() {
        String number = "12435687";
        PhoneDTO phone = new PhoneDTO(number, "Mobile");
        PersonDTO person = facade.getPersonByPhone(phone);
        assertNotNull(person);
    }

    @Test
    public void getAllPersons() {
        List<PersonDTO> personas = facade.getAllPersons();
        assertEquals(20, personas.size());
    }

    @Test
    public void getAllPersonsByHobby() {
        List<PersonDTO> person = facade.getAllPersonsByHobby(new HobbyDTO(0, "programming", "programming"));
        assertEquals(9, person.size());
    }

    @Test
    public void getAllPersonsByCity() {
        List<PersonDTO> person = facade.getAllPersonsByCity(new CityInfoDTO(14, "2600", "Glostrup"));
        assertEquals(9, person.size());

    }

    @Test
    public void getAllPersonsByAddress() {
        List<PersonDTO> person = facade.getAllPersonsByAddress(new AddressDTO(1, "Personstreet", "Number: 0"));
        assertEquals(20, person.size());
    }

    @Test
    public void createAndDeletePerson() {
        List<PersonDTO> pBefore = facade.getAllPersons();
        //creating person
        List<Hobby> hobby = new ArrayList();
        List<Phone> phones = new ArrayList();
        Phone phone = new Phone("12345678", "Call the test person");
        phones.add(phone);
        Address address = new Address("Testervej 1", "Test personer bor her", new FCityInfo(emf).getAllCitiesRaw().get(4));
        Person p = new Person("Test", "Testsen", hobby, "test@test.dk", phones, address);
        PersonDTO dto = facade.createPerson(p);
        //delete person
        List<PersonDTO> pAfter = facade.getAllPersons();
        assertEquals(pBefore.size() + 1, pAfter.size());

        facade.deletePersonById(dto.getId());
        List<PersonDTO> pAfter2 = facade.getAllPersons();
        assertEquals(pBefore.size(), pAfter2.size());
    }

    @Test
    public void updatePerson() {
        PersonDTO pBefore = facade.getPersonByPhone(new PhoneDTO("12435687", "test"));
        String newValue = "Karl Oskar";
        pBefore.setFirstName(newValue);
        PersonDTO test = facade.updatePerson(pBefore);
        PersonDTO pAfter = facade.getPersonByPhone(new PhoneDTO("12435687", "test"));
        assertEquals(pBefore.getFirstName(), pAfter.getFirstName());
    }
}
