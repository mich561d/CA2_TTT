package facade;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Michael
 */
public class FPerson implements IPerson {

    EntityManagerFactory emf;

    public FPerson(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Person getPersonByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Person.findById", Person.class).setParameter("id", id).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO getPersonByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PersonDTO.findByEmail", PersonDTO.class).setParameter("email", email).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO getPersonByPhone(String phone) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PersonDTO.findByNumber", PersonDTO.class).setParameter("number", phone).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonDTO> getAllPersonsByHobby(HobbyDTO hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonDTO> getAllPersonsByCity(CityInfoDTO city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonDTO> getAllPersonsByAddress(AddressDTO address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO createPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO updatePerson(PersonDTO updatedPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
