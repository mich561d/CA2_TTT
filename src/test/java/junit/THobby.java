package junit;

import dto.HobbyDTO;
import entity.Hobby;
import entity.Person;
import facade.FHobby;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class THobby {

    FHobby facade = new FHobby(Persistence.createEntityManagerFactory("pu-test", null));

//    @Test
//    public void getHobbyByID() {
//        Hobby hobby = facade.getHobbyByID(1);
//        assertNotNull(hobby);
//    }
//
//    @Test
//    public void getHobbyByName() {
//        HobbyDTO hobby = facade.getHobbyByName("Programming");
//        assertNotNull(hobby);
//    }
//
//    @Test
//    public void getAllHobbies() {
//        List<Hobby> hobbies = facade.getAllHobbies();
//        assertEquals(5, hobbies.size());
//    }
//
//    @Test
//    public void createHobby() {
//        List<Hobby> hBefore = facade.getAllHobbies();
//        Hobby hobby = new Hobby("Art of Nothing", "The secret art of doing nothing!", new ArrayList<Person>());
//        facade.createHobby(hobby);
//        List<Hobby> hAfter = facade.getAllHobbies();
//        assertEquals(hBefore.size() + 1, hAfter.size());
//    }
//
//    @Test
//    public void updateHobby() {
//        Hobby h = facade.getHobbyByID(5);
//        String newValue = "Blah blah blah";
//        HobbyDTO hBefore = new HobbyDTO(h.getId(), newValue, h.getDescription());
//        facade.updateHobby(hBefore);
//        Hobby hAfter = facade.getHobbyByID(5);
//        assertEquals(hBefore.getName(), hAfter.getName());
//    }
//
//    @Test
//    public void deleteHobbyByID() {
//        List<Hobby> csBefore = facade.getAllHobbies();
//        facade.deleteHobbyByID(3);
//        List<Hobby> csAfter = facade.getAllHobbies();
//        assertEquals(csBefore.size() - 1, csAfter.size());
//    }
//
//    @Test
//    public void deleteHobbyByName() {
//        List<Hobby> csBefore = facade.getAllHobbies();
//        facade.deleteHobbyByName("Programming");
//        List<Hobby> csAfter = facade.getAllHobbies();
//        assertEquals(csBefore.size() - 1, csAfter.size());
//    }
}
