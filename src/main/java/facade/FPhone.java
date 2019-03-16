package facade;

import dto.PhoneDTO;
import entity.Phone;
import interfaces.IPhone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Michael
 */
public class FPhone implements IPhone {

    EntityManagerFactory emf;

    public FPhone(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public PhoneDTO getPhoneByNumber(String number) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PhoneDTO.findByNumber", PhoneDTO.class).setParameter("number", number).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Phone getPhoneByNumberRaw(String number) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Phone.findByNumber", Phone.class).setParameter("number", number).getSingleResult();
        } finally {
            em.close();
        }
    }

}
