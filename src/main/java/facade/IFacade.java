package facade;

import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;

/**
 *
 * @author Jesper, Michael, Mads
 */
public interface IFacade {

    public abstract Phone getPhoneByNumber(String number);

    public abstract Person getPersonByPhone(Phone phone);

    public abstract Company getCompanyByPhone(Phone phone);

    public abstract Company getCompanyByCVR(int cvr);

    public abstract Hobby getHobbyByName(String name);

    public abstract List<Person> getAllPersonsByHobby(Hobby hobby);

    public abstract CityInfo getCityByZip(String zip);

    public abstract List<Person> getAllPersonsByCity(CityInfo city);

    public abstract List<String> getAllZipCodes();

    public abstract List<Company> getAllCompaniesWithMoreEmployeesThan(int amount);

}
