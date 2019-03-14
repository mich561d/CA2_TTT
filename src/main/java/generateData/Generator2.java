package generateData;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.FCityInfo;
import facade.FHobby;
import interfaces.ICityInfo;
import interfaces.IHobby;
import java.io.IOException;
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

        List<CityInfo> allZipCodes = cityInfoFacade.getAllCitiesRaw();
        int phoneNumber = 50000000;

        for (int i = 0; i < amountOfPersons; i++) {
            List<Hobby> allHobbies = hobbyFacade.getAllHobbies();
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
                allHobbies.remove(hobby); //So the same hobby won't be picked twice.
            }
            person.setHobbies(hobbies);
            int amountOfPhones = rand.nextInt(2) + 1;
            for (int j = 0; j < amountOfPhones; j++) {
                phones.add(new Phone(Integer.toString(phoneNumber++), "mobile", person));
            }
            person.setPhones(phones);
            address = new Address("Personstreet", "Number: " + i, allZipCodes.get(rand.nextInt(allZipCodes.size())));
            person.setAddress(address);
            persons.add(person);

        }
        return persons;
    }
    
    public List<Company> generateRandomCompanies(int sampleAmount) {
        ArrayList<Company> companies = new ArrayList();
        ICityInfo cityInfoFacade = new FCityInfo(emf);
        Random rand = new Random();

        List<CityInfo> allZipCodes = cityInfoFacade.getAllCitiesRaw();
        int phoneNumber = 10000000;
        int cvrNumber = 70000000;

        for (int i = 0; i < sampleAmount; i++) {
            String name = "Company " + i;
            String description = "Description of " + name;
            int cvr = cvrNumber++;
            int numEmployees = rand.nextInt(1000);
            int marketValue = 1000 * numEmployees;
            String email = "" + name + "@" + name + ".com";
            ArrayList<Phone> phones = new ArrayList();
            Address address = new Address();

            //String name, String description, int cvr, int numEmployees, int marketValue, String email, List<Phone> phones, Address address
            Company company = new Company(name, description, cvr, numEmployees, marketValue, email, phones, address);
            int amountOfPhones = rand.nextInt(2) + 1;
            for (int j = 0; j < amountOfPhones; j++) {
                phones.add(new Phone(Integer.toString(phoneNumber++), "mobile", company));
            }
            company.setPhones(phones);
            address = new Address("Companystreet", "Number: " + i, allZipCodes.get(rand.nextInt(allZipCodes.size())));
            company.setAddress(address);
            companies.add(company);
        }
        return companies;
    }

}
