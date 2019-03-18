package junit;

import dto.CityInfoDTO;
import entity.CityInfo;
import entity.Company;
import entity.Person;
import facade.FCityInfo;
import facade.FCompany;
import facade.FPerson;
import generateData.Generator2;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Michael
 */
public class TCityInfo {

    private static FCityInfo facade;

    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test");
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
        facade = new FCityInfo(emf);
    }

    @Test
    public void testGetAllCities() {
        List<CityInfoDTO> cities = facade.getAllCities();
        assertEquals(50, cities.size());
    }

    @Test
    public void testGetAllCitiesRaw() {
        List<CityInfo> cities = facade.getAllCitiesRaw();
        assertEquals(50, cities.size());
    }

}
