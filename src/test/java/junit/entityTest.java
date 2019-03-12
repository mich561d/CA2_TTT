package junit;

import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.Facade;
import facade.IFacade;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class entityTest {

    IFacade facade;

    public entityTest() {
        facade = new Facade();
    }

    @Test
    public void getPhoneByNumberTest() {
        Phone phone = facade.getPhoneByNumber("12435687");
        assertNotNull(phone);
    }

    @Test
    public void getPersonByPhoneTest() {
        Phone phone = facade.getPhoneByNumber("12435687");
        Person person = facade.getPersonByPhone(phone);
        assertNotNull(person);
    }

    @Test
    public void getCompanyByPhoneTest() {
        Phone phone = facade.getPhoneByNumber("21346578");
        Company company = facade.getCompanyByPhone(phone);
        assertNotNull(company);
    }

    @Test
    public void getCompanyByCVRTest() {
        Company company = facade.getCompanyByCVR(36069420);
        assertNotNull(company);
    }

    @Test
    public void getHobbyByNameTest() {
        Hobby hobby = facade.getHobbyByName("Programming");
        assertNotNull(hobby);
    }

    @Test
    public void getAllPersonsByHobbyTest() {
        Hobby hobby = facade.getHobbyByName("Programming");
        List<Person> persons = facade.getAllPersonsByHobby(hobby);
        assertEquals(10, persons.size());
    }

    @Test
    public void getCityByZipTest() {
        CityInfo city = facade.getCityByZip("2800");
        assertEquals("Lyngby", city.getCity());
    }

    @Test
    public void getAllPersonsByCityTest() {
        CityInfo city = facade.getCityByZip("2800");
        List<Person> persons = facade.getAllPersonsByCity(city);
        assertEquals(12, persons.size());
    }

    @Test
    public void getAllZipCodesTest() {
        List<String> zips = facade.getAllZipCodes();
        assertEquals(1352, zips.size());
    }

    @Test
    public void getAllCompaniesWithMoreEmployeesThanTest() {
        List<Company> companies = facade.getAllCompaniesWithMoreEmployeesThan(360);
        assertEquals(42, companies.size());
    }

}
