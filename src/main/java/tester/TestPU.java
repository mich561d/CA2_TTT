package tester;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import generateData.Generator2;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fen
 */
public class TestPU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persistence.generateSchema("pu-test", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        Generator2 generator = new Generator2(emf);
        List<Person> persons = generator.generateRandomPersons(50);
        
//        EntityManager em = emf.createEntityManager();
//        List<Hobby> hobbies = new ArrayList();
//        hobbies.add(new Hobby("Programming", "Java is great"));
//        List<Phone> phones = new ArrayList();
//        phones.add(new Phone("12435687", "mobil"));
//        Address address = new Address("Godthåbsvej", "121, 3th", new CityInfo("2000", "Frederiksberg"));
//        Person person = new Person("Mads", "Floistrup", hobbies, "cph-mf226@cphbusiness.dk", phones, address);
//        em.persist(person);
    }

}
