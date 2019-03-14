package facade;

import interfaces.IPerson;
import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.CompanyDTO;
import dto.HobbyDTO;
import dto.PersonDTO;
import dto.PhoneDTO;
import entity.Address;
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
    public PersonDTO getPersonByPhone(PhoneDTO phone) {
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
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findAllByAddress", PersonDTO.class).setParameter("address", address.getStreet()).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        List<String> phones = new ArrayList();
        for (int i = 0; i < person.getPhones().size(); i++) {
            phones.add(person.getPhones().get(i).getNumber());
        }
        List<String> hobbies = new ArrayList();
        for (int i = 0; i < person.getHobbies().size(); i++) {
            hobbies.add(person.getHobbies().get(i).getName());
        }

        return new PersonDTO(person.getId(),person.getFirstName(),person.getLastName(),person.getEmail(),person.getAddress().getStreet(),hobbies,phones);
    }

    @Override
    public PersonDTO updatePerson(PersonDTO updatedPerson) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person p = getPersonByID(updatedPerson.getId());
            p.setEmail(updatedPerson.getEmail());
            p.setFirstName(updatedPerson.getFirstName());
            p.setLastName(updatedPerson.getLastName());
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return updatedPerson;
    }

    @Override
    public void deletePersonById(int id) {
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
