package junit;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.CompanyDTO;
import entity.Company;
import facade.FCompany;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class TCompany {

    FCompany facade = new FCompany(Persistence.createEntityManagerFactory("pu-test", null));

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

    }

    public void testGetAllCompaniesWithMarketValueOver() {

    }

    public void testCreateCompany() {

    }

    public void testUpdateCompany() {

    }

    public void testDeleteCompany() {

    }
}
