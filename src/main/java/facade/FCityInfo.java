package facade;

import dto.CityInfoDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
