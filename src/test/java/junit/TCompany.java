package junit;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.CompanyDTO;
import entity.Address;
import entity.Company;
import entity.Phone;
import facade.FCityInfo;
import facade.FCompany;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class TCompany {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);
    FCompany facade = new FCompany(emf);

    public void testGetCompanyByID() {
        Company c = facade.getCompanyByID(1);
        assertNotNull(c);
    }

    public void testGetCompanyByEmail() {
        CompanyDTO c = facade.getCompanyByEmail("Company1@Company1.com");
        assertNotNull(c);
    }

    public void testGetCompanyByPhone() {
        CompanyDTO c = facade.getCompanyByPhone("10000001");
        assertNotNull(c);
    }

    public void testGetCompanyByCVR() {
        CompanyDTO c = facade.getCompanyByCVR(70000001);
        assertNotNull(c);
    }

    public void testGetAllCompanies() {
        List<CompanyDTO> cs = facade.getAllCompanies();
        assertEquals(5, cs.size());
    }

    public void testGetAllCompaniessByCity() {
        List<CompanyDTO> cs = facade.getAllCompaniessByCity(new CityInfoDTO(0, "2800", "Lyngby"));
        assertEquals(2, cs.size());
    }

    public void testGetAllCompaniesByAddress() {
        List<CompanyDTO> cs = facade.getAllCompaniesByAddress(new AddressDTO(0, "TestVej 1", "Test"));
        assertEquals(1, cs.size());
    }

    public void testGetAllCompaniesWithNumEmployeesOver() {
        List<CompanyDTO> cs = facade.getAllCompaniesWithNumEmployeesOver(360);
        assertEquals(2, cs.size());
    }

    public void testGetAllCompaniesWithMarketValueOver() {
        List<CompanyDTO> cs = facade.getAllCompaniesWithMarketValueOver(2500000);
        assertEquals(1, cs.size());
    }

    public void testCreateCompany() {
        List<CompanyDTO> csBefore = facade.getAllCompanies();
        // Creating company
        List<Phone> phones = new ArrayList();
        Phone phone = new Phone("13371337", "Call the elite");
        phones.add(phone);
        Address address = new Address("Heaven", "Because we are gods", new FCityInfo(emf).getAllCitiesRaw().get(4));
        Company company = new Company("The Turtle Troopers A/S", "We are the best", 36069420, 4, 2499999, "contact@TTT.com", phones, address);
        address.getInfoEntities().add(company);
        phone.setInfoEntity(company);
        facade.createCompany(company);
        // Done creating company
        List<CompanyDTO> csAfter = facade.getAllCompanies();
        assertEquals(csBefore.size() + 1, csAfter.size());
    }

    public void testUpdateCompany() {
        CompanyDTO cBefore = facade.getCompanyByCVR(70000000);
        String newValue = "NewName A/S";
        cBefore.setName(newValue);
        facade.updateCompany(cBefore);
        CompanyDTO cAfter = facade.getCompanyByCVR(70000000);
        assertEquals(cBefore.getName(), cAfter.getName());
    }

    public void testDeleteCompany() {
        List<CompanyDTO> csBefore = facade.getAllCompanies();
        facade.deleteCompany(4);
        List<CompanyDTO> csAfter = facade.getAllCompanies();
        assertEquals(csBefore.size() - 1, csAfter.size());
    }
}
