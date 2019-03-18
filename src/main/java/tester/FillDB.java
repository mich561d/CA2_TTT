package tester;

import entity.Company;
import entity.Person;
import facade.FCompany;
import facade.FPerson;
import generateData.Generator2;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mads
 */
public class FillDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Persistence.generateSchema("pu2", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu2");
        Generator2 generator = new Generator2(emf);
        List<Person> persons = generator.generateRandomPersons(500);
        List<Company> companies = generator.generateRandomCompanies(100);
        FPerson fPerson = new FPerson(emf);
        for (int i = 0; i < persons.size(); i++) {
            //System.out.println(persons.get(i).getHobbies().get(0).getName());
            fPerson.createPerson(persons.get(i));
        }
        FCompany fCompany = new FCompany(emf);
        for (int i = 0; i < companies.size(); i++) {
            //System.out.println(persons.get(i).getHobbies().get(0).getName());
            fCompany.createCompany(companies.get(i));
        }
    }

}
