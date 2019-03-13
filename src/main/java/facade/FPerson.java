package facade;

import interfaces.IPerson;
import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import entity.Person;
import java.util.ArrayList;
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
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PersonDTO.findAll", PersonDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonDTO> getAllPersonsByHobby(HobbyDTO hobby) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PersonDTO.findAllByHobby", PersonDTO.class).setParameter("hobby", hobby.getId()).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonDTO> getAllPersonsByCity(CityInfoDTO city) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PersonDTO.findAllByCity", PersonDTO.class).setParameter("zip", city.getZipCode()).getResultList();
        } finally {
            em.close();
        }
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
    public void deletePerson(int id) {
        EntityManager em = emf.createEntityManager();
        Person p = getPersonByID(id);
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
