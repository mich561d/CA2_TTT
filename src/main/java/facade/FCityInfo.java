package facade;

import interfaces.ICityInfo;
import dto.CityInfoDTO;
import entity.CityInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Michael
 */
public class FCityInfo implements ICityInfo {

    EntityManagerFactory emf;

    public FCityInfo(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<CityInfoDTO> getAllCities() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CityInfoDTO.findAll", CityInfoDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CityInfo> getAllCitiesRaw() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CityInfo.findAll", CityInfo.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public CityInfo getCityByZipRAW(String zip) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CityInfo.findByZipCode", CityInfo.class).setParameter("zip", zip).getSingleResult();
        } finally {
            em.close();
        }

    }

    @Override
    public CityInfoDTO getCityByZip(String zip) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CityInfoDTO.findByZipCode", CityInfoDTO.class).setParameter("zip", zip).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CityInfoDTO> getAllZipCodes() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CityInfo.findAllZipCodes", CityInfoDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

}
