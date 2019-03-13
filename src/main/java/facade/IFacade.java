package facade;

import dto.CityInfoDTO;
import dto.CompanyDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import dto.PhoneDTO;
import entity.Hobby;
import java.util.List;

/**
 *
 * @author Jesper, Michael, Mads
 */
public interface IFacade {

    public abstract PhoneDTO getPhoneByNumber(String number);

    public abstract PersonDTO getPersonByPhone(PhoneDTO phone);

    public abstract CompanyDTO getCompanyByPhone(PhoneDTO phone);

    public abstract CompanyDTO getCompanyByCVR(int cvr);

    public abstract HobbyDTO getHobbyByName(String name);

    public abstract List<PersonDTO> getAllPersonsByHobby(HobbyDTO hobby);

    public abstract CityInfoDTO getCityByZip(String zip);

    public abstract List<PersonDTO> getAllPersonsByCity(CityInfoDTO city);

    public abstract List<String> getAllZipCodes();

    public abstract List<CompanyDTO> getAllCompaniesWithMoreEmployeesThan(int amount);

    public abstract List<Hobby> getAllHobbies();

}
