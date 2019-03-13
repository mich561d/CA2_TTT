package generateData;

import com.google.gson.Gson;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.Facade;
import facade.IFacade;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fen
 */
public class Generator {

    private final static String[] FIRSTNAMES = {"Mads", "Christian", "Jesper", "Michael", "Lone", "Sine"};
    private final static String[] LASTNAMES = {"Nielsen", "Jensen", "Olsen", "Fløistrup", "Andersen", "Åberg"};

    public static void generateRandomPersons(int sampleAmount) {
        IFacade facade = new Facade();
        //List<Hobby> allHobbies = facade.getAllHobbies();
        Random rand = new Random();
        //Gson gson = new Gson();
        for (int i = 0; i < sampleAmount; i++) {
            String firstName = FIRSTNAMES[rand.nextInt(FIRSTNAMES.length)];
            String lastName = LASTNAMES[rand.nextInt(LASTNAMES.length)];

//            ArrayList<Hobby> hobbies = new ArrayList();
//            int amountOfHobbies = rand.nextInt(3) + 1;
//            for(int j = 0; j < amountOfHobbies ; i++) {
//                int hobby = rand.nextInt(allHobbies.size());
//                hobbies.add(allHobies.get(hobby));
//            }
            String email = "" + firstName + "@" + lastName + ".com";

            //persons.add(new Person(FIRSTNAMES[fName], LASTNAMES[lName], hobbies, email, phones, address));
        }

        //return gson.toJson(persons);
    }

    public String generateTestData() throws IOException {
        IFacade facade = new Facade();
        String path = "src/main/resources/sqlDataScript.sql";
        //Person with phone: 12435687
        List<Hobby> hobbies = new ArrayList();
        hobbies.add(new Hobby("Programming", "Java is great", new ArrayList<Person>()));
        List<Phone> phones = new ArrayList();
        phones.add(new Phone("12435687", "mobil", new Person()));
        Address address = new Address("Godthåbsvej", "121, 3th", new CityInfo("2000", "Frederiksberg", new ArrayList<Address>()));
        Person person = new Person("Mads", "Floistrup", hobbies, "cph-mf226@cphbusiness.dk", phones, address);

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
            //System.out.println(Generator.generateRandomPersons(100));
            generator.generateTestData();
            //generator.writeToFile("INSERT INTO name (name,surname,gender) VALUES ('Linda','Schreiber','female');\n", true);
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
