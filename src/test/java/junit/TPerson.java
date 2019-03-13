package junit;

import facade.FPerson;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class TPerson {

    FPerson facade = new FPerson(Persistence.createEntityManagerFactory("pu-test", null));
//
//    @Test
//    public void getPersonByID() {
//    }
//
//    @Test
//    public void getPersonByEmail() {
//    }
//
//    @Test
//    public void getPersonByPhone() {
//    }
//
//    @Test
//    public void getAllPersons() {
//    }
//
//    @Test
//    public void getAllPersonsByHobby() {
//    }
//
//    @Test
//    public void getAllPersonsByCity() {
//    }
//
//    @Test
//    public void getAllPersonsByAddress() {
//    }
//
//    @Test
//    public void createPerson() {
//    }
//
//    @Test
//    public void updatePerson() {
//    }
//
//    @Test
//    public void deletePerson() {
//    }
}
