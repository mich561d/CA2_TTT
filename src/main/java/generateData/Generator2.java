package generateData;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.FCityInfo;
import facade.FHobby;
import interfaces.ICityInfo;
import interfaces.IHobby;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Fen
 */
public class Generator2 {

    private final static String[] FIRSTNAMES = {"Mads", "Christian", "Jesper", "Michael", "Lone", "Sine"};
    private final static String[] LASTNAMES = {"Nielsen", "Jensen", "Olsen", "Fløistrup", "Andersen", "Åberg"};
    EntityManagerFactory emf;

    public Generator2(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Person> generateRandomPersons(int amountOfPersons) {
        ArrayList<Person> persons = new ArrayList();
        ICityInfo cityInfoFacade = new FCityInfo(emf);
        IHobby hobbyFacade = new FHobby(emf);
        Random rand = new Random();
        //String path = "src/main/resources/scripts/infoEntities.sql";

        List<Hobby> allHobbies = hobbyFacade.getAllHobbies();
        List<CityInfo> allZipCodes = cityInfoFacade.getAllCitiesRaw();
        int phoneNumber = 50000000;

        for (int i = 0; i < amountOfPersons; i++) {
            String firstName = FIRSTNAMES[rand.nextInt(FIRSTNAMES.length)];
            String lastName = LASTNAMES[rand.nextInt(LASTNAMES.length)];
            ArrayList<Hobby> hobbies = new ArrayList();
            String email = "" + firstName + "@" + lastName + ".com";
            ArrayList<Phone> phones = new ArrayList();
            Address address = new Address();

            Person person = new Person(firstName, lastName, hobbies, email, phones, address);

            int amountOfHobbies = rand.nextInt(3) + 1;
            for (int j = 0; j < amountOfHobbies; j++) {
                int hobby = rand.nextInt(allHobbies.size());
                hobbies.add(allHobbies.get(hobby));
            }
            person.setHobbies(hobbies);
            int amountOfPhones = rand.nextInt(2) + 1;
            for (int j = 0; j < amountOfPhones; j++) {
                phones.add(new Phone(Integer.toString(phoneNumber++), "mobile", person));
            }
            person.setPhones(phones);
            address = new Address("Personstreet", "Number: " + i, allZipCodes.get(rand.nextInt(allZipCodes.size())));
            person.setAddress(address);

            //writeToFile(person.toSql(), path, true);
        }
        return persons;
    }

}
