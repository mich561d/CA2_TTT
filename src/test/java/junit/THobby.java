package junit;

import dto.HobbyDTO;
import entity.Company;
import entity.Hobby;
import entity.Person;
import facade.FCompany;
import facade.FHobby;
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
 * @author Michael
 */
public class THobby {

    FHobby facade;

    @Before
    public void setup() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test");
        facade = new FHobby(emf);
        Generator2 generator = new Generator2(emf);
        List<Person> persons = generator.generateExactTestPersonData();
        List<Company> companies = generator.generateExactTestCompanyData();
        FPerson fPerson = new FPerson(emf);
        for (int i = 0; i < persons.size(); i++) {
            fPerson.createPerson(persons.get(i));
        }
        FCompany fCompany = new FCompany(emf);
        for (int i = 0; i < companies.size(); i++) {
            fCompany.createCompany(companies.get(i));
        }
    }

    @Test
    public void getHobbyByID() {
        Hobby hobby = facade.getHobbyByIDRaw(1);
        assertNotNull(hobby);
    }

    @Test
    public void getHobbyByName() {
        HobbyDTO hobby = facade.getHobbyByName("Programming");
        assertNotNull(hobby);
    }

    @Test
    public void getAllHobbies() {
        List<Hobby> hobbies = facade.getAllHobbiesRaw();
        assertEquals(11, hobbies.size());
    }

    @Test
    public void createHobby() {
        List<Hobby> hBefore = facade.getAllHobbiesRaw();
        Hobby hobby = new Hobby("Art of Nothing", "The secret art of doing nothing!", new ArrayList<Person>());
        facade.createHobby(hobby);
        List<Hobby> hAfter = facade.getAllHobbiesRaw();
        assertEquals(hBefore.size() + 1, hAfter.size());
    }

    @Test
    public void updateHobby() {
        Hobby h = facade.getHobbyByIDRaw(5);
        String newValue = "Stalking";
        HobbyDTO hBefore = new HobbyDTO(h.getId(), newValue, h.getDescription());
        facade.updateHobby(hBefore);
        Hobby hAfter = facade.getHobbyByIDRaw(5);
        assertEquals(hBefore.getName(), hAfter.getName());
    }

    @Test
    public void deleteHobbyByID() {
        List<Hobby> csBefore = facade.getAllHobbiesRaw();
        facade.deleteHobbyByID(3);
        List<Hobby> csAfter = facade.getAllHobbiesRaw();
        assertEquals(csBefore.size() - 1, csAfter.size());
    }

    @Test
    public void deleteHobbyByName() {
        List<Hobby> csBefore = facade.getAllHobbiesRaw();
        facade.deleteHobbyByName("Programming");
        List<Hobby> csAfter = facade.getAllHobbiesRaw();
        assertEquals(csBefore.size() - 1, csAfter.size());
    }
}
