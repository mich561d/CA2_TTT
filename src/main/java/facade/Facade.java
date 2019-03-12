package facade;

import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Michael, Jesper
 */
public class Facade implements IFacade {

    EntityManagerFactory emf;

    @Override
    public Phone getPhoneByNumber(String number) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PhoneDTO.findByNumber", Phone.class).setParameter("number", number).getSingleResult();
        } finally {
            em.close();
        }
    }
    
    //Querien er ikke lavet..
    @Override
    public Person getPersonByPhone(Phone phone) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PhoneDTO.findByPNumber", Person.class).setParameter("number", phone.getNumber()).getSingleResult();
        } finally {
            em.close();
        }
    }
    
    //Querien er ikke lavet..
    @Override
    public Company getCompanyByPhone(Phone phone) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findCompanyByPNumber", Company.class).setParameter("number", phone.getNumber()).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompanyByCVR(int cvr) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("companyDTO.findCompanyByCVR", Company.class).setParameter("cvr", cvr).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Hobby getHobbyByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("HobbyDTO.findByHobbyName", Hobby.class).setParameter("name", name).getSingleResult();
        } finally {
            em.close();
        }
    }
    
    // PLEASE FIX ME
    @Override
    public List<Person> getAllPersonsByHobby(Hobby hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CityInfo getCityByZip(String zip) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("cityInfoDTO.findCityByZipCode", CityInfo.class).setParameter("zipCode", zip).getSingleResult();
        } finally {
            em.close();
        }
    }

    // PLEASE FIX ME
    @Override
    public List<Person> getAllPersonsByCity(CityInfo city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // PLEASE FIX ME
    @Override
    public List<String> getAllZipCodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // PLEASE FIX ME
    @Override
    public List<Company> getAllCompaniesWithMoreEmployeesThan(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
