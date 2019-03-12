package junit;

import dto.CityInfoDTO;
import dto.CompanyDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import dto.PhoneDTO;
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
        PhoneDTO phone = facade.getPhoneByNumber("12435687");
        assertNotNull(phone);
    }

    @Test
    public void getPersonByPhoneTest() {
        PhoneDTO phone = facade.getPhoneByNumber("12435687");
        PersonDTO person = facade.getPersonByPhone(phone);
        assertNotNull(person);
    }

    @Test
    public void getCompanyByPhoneTest() {
        PhoneDTO phone = facade.getPhoneByNumber("21346578");
        CompanyDTO company = facade.getCompanyByPhone(phone);
        assertNotNull(company);
    }

    @Test
    public void getCompanyByCVRTest() {
        CompanyDTO company = facade.getCompanyByCVR(36069420);
        assertNotNull(company);
    }

    @Test
    public void getHobbyByNameTest() {
        HobbyDTO hobby = facade.getHobbyByName("Programming");
        assertNotNull(hobby);
    }

    @Test
    public void getAllPersonsByHobbyTest() {
        HobbyDTO hobby = facade.getHobbyByName("Programming");
        List<PersonDTO> persons = facade.getAllPersonsByHobby(hobby);
        assertEquals(10, persons.size());
    }

    @Test
    public void getCityByZipTest() {
        CityInfoDTO city = facade.getCityByZip("2800");
        assertEquals("Lyngby", city.getCity());
    }

    @Test
    public void getAllPersonsByCityTest() {
        CityInfoDTO city = facade.getCityByZip("2800");
        List<PersonDTO> persons = facade.getAllPersonsByCity(city);
        assertEquals(12, persons.size());
    }

    @Test
    public void getAllZipCodesTest() {
        List<String> zips = facade.getAllZipCodes();
        assertEquals(1352, zips.size());
    }

    @Test
    public void getAllCompaniesWithMoreEmployeesThanTest() {
        List<CompanyDTO> companies = facade.getAllCompaniesWithMoreEmployeesThan(360);
        assertEquals(42, companies.size());
    }

}
