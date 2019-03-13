package interfaces;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import entity.Person;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface IPerson {

    public abstract Person getPersonByID(int id);

    public abstract PersonDTO getPersonByEmail(String email);

    public abstract PersonDTO getPersonByPhone(String phone);

    public abstract List<PersonDTO> getAllPersons();

    public abstract List<PersonDTO> getAllPersonsByHobby(HobbyDTO hobby);

    public abstract List<PersonDTO> getAllPersonsByCity(CityInfoDTO city);

    public abstract List<PersonDTO> getAllPersonsByAddress(AddressDTO address);

    public abstract PersonDTO createPerson(Person person);

    public abstract PersonDTO updatePerson(PersonDTO updatedPerson);

    public abstract void deletePerson();
}
