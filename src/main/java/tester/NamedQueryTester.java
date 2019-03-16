package tester;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.HobbyDTO;
import dto.PhoneDTO;
import entity.Company;
import entity.Person;
import facade.FCityInfo;
import facade.FCompany;
import facade.FHobby;
import facade.FPerson;
import facade.FPhone;
import generateData.Generator2;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Michael
 */
public class NamedQueryTester {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test");
    private FPhone fPhone = new FPhone(emf);
    private FPerson fPerson = new FPerson(emf);
    private FHobby fHobby = new FHobby(emf);
    private FCompany fCompany = new FCompany(emf);
    private FCityInfo fCity = new FCityInfo(emf);

    public static void main(String[] args) {

        new NamedQueryTester().test();

    }

    private void test() {
        System.out.println("----- Start ------------------------------------------");
        Generator2 generator = new Generator2(emf);
        List<Person> persons = generator.generateExactTestPersonData();
        List<Company> companies = generator.generateExactTestCompanyData();
        persons.get(4).setEmail("Tester@Test.com");
        for (int i = 0; i < persons.size(); i++) {
            fPerson.createPerson(persons.get(i));
        }
        for (int i = 0; i < companies.size(); i++) {
            fCompany.createCompany(companies.get(i));
        }
        System.out.println("----- Phone ------------------------------------------------------------------------------------");
        System.out.println("getPhoneByNumber                    : " + fPhone.getPhoneByNumber("12435687"));
        System.out.println("getPhoneByNumberRaw                 : " + fPhone.getPhoneByNumberRaw("12435687"));
        System.out.println("----- Person -----------------------------------------------------------------------------------");
        System.out.println("getPersonByIDRaw                    : " + fPerson.getPersonByIDRaw(5));
        System.out.println("getPersonByEmail                    : " + fPerson.getPersonByEmail("Tester@Test.com"));
        //System.out.println("getPersonByPhone                    : " + fPerson.getPersonByPhone(new PhoneDTO(0, "12435687", "Tester", 0)));
        System.out.println("getAllPersons                       : " + fPerson.getAllPersons());
        //System.out.println("getAllPersonsByHobby                : " + fPerson.getAllPersonsByHobby(new HobbyDTO(0, "Programming", "Tester")));
        //System.out.println("getAllPersonsByCity                 : " + fPerson.getAllPersonsByCity(new CityInfoDTO("2640")));
        //System.out.println("getAllPersonsByAddress              : " + fPerson.getAllPersonsByAddress(new AddressDTO(0, "Personstreet", "Tester")));
        System.out.println("----- Hobby ------------------------------------------------------------------------------------");
        System.out.println("getHobbyByIDRaw                     : " + fHobby.getHobbyByIDRaw(1));
        System.out.println("getAllHobbiesRaw                    : " + fHobby.getAllHobbiesRaw());
        System.out.println("getHobbyByName                      : " + fHobby.getHobbyByName("Programming"));
        System.out.println("----- Company ----------------------------------------------------------------------------------");
        System.out.println("getCompanyByIDRaw                   : " + fCompany.getCompanyByIDRaw(25));
        System.out.println("getCompanyByCVR                     : " + fCompany.getCompanyByCVR(36069420));
        System.out.println("getCompanyByEmail                   : " + fCompany.getCompanyByEmail("Company 0@Company 0.com"));
        System.out.println("getCompanyByPhone                   : " + fCompany.getCompanyByPhone(fPhone.getPhoneByNumberRaw("21346578")));
        System.out.println("getAllCompanies                     : " + fCompany.getAllCompanies());
        //System.out.println("getAllCompaniesByAddress            : " + fCompany.getAllCompaniesByAddress(new AddressDTO(0, "Companystreet", "Tester")));
        System.out.println("getAllCompaniesWithMarketValueOver  : " + fCompany.getAllCompaniesWithMarketValueOver(100000));
        System.out.println("getAllCompaniesWithNumEmployeesOver : " + fCompany.getAllCompaniesWithNumEmployeesOver(360));
        //System.out.println("getAllCompaniessByCity              : " + fCompany.getAllCompaniessByCity(new CityInfoDTO("2640")));
        System.out.println("----- City -------------------------------------------------------------------------------------");
        System.out.println("getAllCities                        : " + fCity.getAllCities());
        System.out.println("getAllCitiesRaw                     : " + fCity.getAllCitiesRaw());
        System.out.println("getAllZipCodes                      : " + fCity.getAllZipCodes());
        System.out.println("getAllCities                        : " + fCity.getCityByZip("2600"));
        System.out.println("----- End --------------------------------------------------------------------------------------");
    }
}
