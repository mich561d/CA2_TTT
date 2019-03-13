package tester;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Micheal
 */
public class Main {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        EntityManager em = emf.createEntityManager();
//         List<Hobby> hobbies = new ArrayList();
//        hobbies.add(new Hobby("Programming", "Java is great"));
//        List<Phone> phones = new ArrayList();
//        phones.add(new Phone("12435687", "mobil"));
//        Address address = new Address("Godthåbsvej", "121, 3th", new CityInfo("2000", "Frederiksberg"));
//        Person person = new Person("Mads", "Floistrup", hobbies, "cph-mf226@cphbusiness.dk", phones, address);
//        em.persist(person);
    }
}
