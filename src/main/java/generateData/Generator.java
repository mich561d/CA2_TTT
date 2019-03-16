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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fen
 */
public class Generator {

    private final static String[] FIRSTNAMES = {"Mads", "Christian", "Jesper", "Michael", "Lone", "Sine"};
    private final static String[] LASTNAMES = {"Nielsen", "Jensen", "Olsen", "Fløistrup", "Andersen", "Åberg"};
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void generateRandomPersons(int sampleAmount) throws IOException {
        ICityInfo cityInfoFacade = new FCityInfo(emf);
        IHobby hobbyFacade = new FHobby(emf);
        Random rand = new Random();
        String path = "src/main/resources/scripts/infoEntities.sql";

        List<Hobby> allHobbies = hobbyFacade.getAllHobbiesRaw();
        List<CityInfo> allZipCodes = cityInfoFacade.getAllCitiesRaw();
        int phoneNumber = 50000000;

        for (int i = 0; i < sampleAmount; i++) {
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

            writeToFile(person.toSql(), path, true);
        }
    }

    public void generateRandomCompanies(int sampleAmount) throws IOException {
        ICityInfo cityInfoFacade = new FCityInfo(emf);
        Random rand = new Random();
        String path = "src/main/resources/scripts/infoEntities.sql";

        List<CityInfo> allZipCodes = cityInfoFacade.getAllCitiesRaw();
        int phoneNumber = 10000000;
        int cvrNumber = 70000000;

        for (int i = 0; i < sampleAmount; i++) {
            System.out.println("----- i : " + i + " -----");
            String name = "Company " + i;
            String description = "Description of " + name;
            int cvr = cvrNumber++;
            int numEmployees = rand.nextInt(1000);
            int marketValue = 1000 * numEmployees;
            String email = "" + name + "@" + name + ".com";
            ArrayList<Phone> phones = new ArrayList();
            Address address = new Address();
            System.out.println("----- End of data -----");
            //String name, String description, int cvr, int numEmployees, int marketValue, String email, List<Phone> phones, Address address
            Company company = new Company(name, description, cvr, numEmployees, marketValue, email, phones, address);
            System.out.println("----- Created company entity -----");
            int amountOfPhones = rand.nextInt(2) + 1;
            System.out.println("----- Amount of Phones: " + amountOfPhones + " -----");
            for (int j = 0; j < amountOfPhones; j++) {
                System.out.println("----- j : " + j + " -----");
                phones.add(new Phone(Integer.toString(phoneNumber++), "mobile", company));
            }
            company.setPhones(phones);
            address = new Address("Companystreet", "Number: " + i, allZipCodes.get(rand.nextInt(allZipCodes.size())));
            company.setAddress(address);
            System.out.println("----- Added Phone & Address -----");
            writeToFile(company.toSql(), path, true);
            System.out.println("----- End of method -----");
        }
    }

    public String generateTestData() throws IOException {
        //IFacade facade = new Facade();
        String path = "src/main/resources/scripts/infoEntities.sql";
        //Person with phone: 12435687
        List<Hobby> hobbies = new ArrayList();
        List<Phone> phones = new ArrayList();
        Address address = null;
        Person person = new Person("Mads2", "Floistrup", hobbies, "cph-mf226@cphbusiness.dk", phones, address);
        hobbies.add(new Hobby("Programming", "Java is great", new ArrayList<Person>()));
        phones.add(new Phone("12435687", "mobil", new Person()));
        address = new Address("Godthåbsvej", "121, 3th", new CityInfo("2000", "Frederiksberg", new ArrayList<Address>()));

        writeToFile(person.toSql(), path, false);
        //Company with phone: 21346578

        //Company with CVR: 36069420
        //Hobby Programming
        //42 companies with more than 360 employees
        return "";
    }

    public void writeToFile(String content, String path, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, append));
        writer.write(content);
        writer.close();
    }

    public static void main(String[] args) {

        Generator generator = new Generator();
        try {
            //generator.generateTestData();
            //generator.generateRandomPersons(5);
            generator.generateRandomCompanies(5);
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
