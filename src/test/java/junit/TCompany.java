package junit;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.CompanyDTO;
import entity.Address;
import entity.Company;
import entity.Phone;
import facade.FCityInfo;
import facade.FCompany;
import facade.FPhone;
import generateData.Generator2;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Michael, Mads
 */
public class TCompany {

    private static EntityManagerFactory emf;
    private static FCompany facade;
    private static List<Company> companies;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("pu-test");
        Generator2 generator = new Generator2(emf);
        companies = generator.generateExactTestCompanyData();
        facade = new FCompany(emf);
        for (int i = 0; i < companies.size(); i++) {
            facade.createCompany(companies.get(i));
        }
    }

//    @Before
//    public void setup() {
//        emf = Persistence.createEntityManagerFactory("pu-test");
//        Generator2 generator = new Generator2(emf);
//        companies = generator.generateExactTestCompanyData();
//        facade = new FCompany(emf);
//        em = emf.createEntityManager();
//        for (int i = 0; i < companies.size(); i++) {
//            facade.createCompany(companies.get(i));
//        }
//    }
//    @After
//    public void tearDown() throws Exception {
//        if (em != null) {
//            em.getTransaction().begin();
//            em.flush();
//            em.
//            em.getTransaction().commit();
//            em.close();
//            em = null;
//        }
//    }
    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    @Test
    public void testGetCompanyByID() {
        Company c = facade.getCompanyByIDRaw(1);
        assertNotNull(c);
    }

    @Test
    public void testGetCompanyByEmail() {
        String email = "Company1@Company1.com";
        CompanyDTO c = facade.getCompanyByEmail(email);
        assertEquals(email, c.getEmail());
    }

    @Test
    public void testGetCompanyByPhone() {
        String number = "21346578";
        Phone phone = new FPhone(emf).getPhoneByNumberRaw(number);
        CompanyDTO c = facade.getCompanyByPhone(phone);
        assertTrue(phone.getInfoEntity().getId() == c.getId());
    }

    @Test
    public void testGetCompanyByCVR() {
        int CVR = 70000001;
        CompanyDTO c = facade.getCompanyByCVR(CVR);
        assertNotNull(c);
    }

    @Test
    public void testGetAllCompanies() {
        List<CompanyDTO> cs = facade.getAllCompanies();
        assertEquals(20, cs.size());
    }

    @Test
    public void testGetAllCompaniessByCity() {
        List<CompanyDTO> cs = facade.getAllCompaniessByCity(new CityInfoDTO(0, "2800", "Lyngby"));
        assertEquals(7, cs.size());
    }

    @Test
    public void testGetAllCompaniesByAddress() {
        List<CompanyDTO> cs = facade.getAllCompaniesByAddress(new AddressDTO(0, "Companystreet", "Test"));
        assertEquals(20, cs.size());
    }

    @Test
    public void testGetAllCompaniesWithNumEmployeesOver() {
        List<CompanyDTO> cs = facade.getAllCompaniesWithNumEmployeesOver(360);
        assertEquals(7, cs.size());
    }

    @Test
    public void testGetAllCompaniesWithMarketValueOver() {
        List<CompanyDTO> cs = facade.getAllCompaniesWithMarketValueOver(4900000);
        assertEquals(7, cs.size());
    }

    @Test
    public void testCreateAndDeleteCompany() {
        List<CompanyDTO> csBefore = facade.getAllCompanies();
        // Creating company
        List<Phone> phones = new ArrayList();
        Phone phone = new Phone("13371337", "Call the elite");
        phones.add(phone);
        Address address = new Address("Heaven", "Because we are gods", new FCityInfo(emf).getAllCitiesRaw().get(4));
        Company company = new Company("The Turtle Troopers A/S", "We are the best", 36069421, 4, 2499999, "contact@TTT.com", phones, address);

        CompanyDTO dto = facade.createCompany(company);
        // Done creating company
        List<CompanyDTO> csAfter = facade.getAllCompanies();
        assertEquals(csBefore.size() + 1, csAfter.size());

        facade.deleteCompany(dto.getId());
        List<CompanyDTO> csAfter2 = facade.getAllCompanies();
        assertEquals(csBefore.size(), csAfter2.size());

    }

    @Test
    public void testUpdateCompany() {
        CompanyDTO cBefore = facade.getCompanyByCVR(36069420);
        String newValue = "NewName A/S";
        cBefore.setName(newValue);
        CompanyDTO test = facade.updateCompany(cBefore);
        CompanyDTO cAfter = facade.getCompanyByCVR(36069420);
        assertEquals(cBefore.getName(), cAfter.getName());
    }

//    @Test
//    public void testDeleteCompany() {
//        List<CompanyDTO> csBefore = facade.getAllCompanies();
//        facade.deleteCompany(4);
//        List<CompanyDTO> csAfter = facade.getAllCompanies();
//        assertEquals(csBefore.size() - 1, csAfter.size());
//    }
}
