package facade;

import interfaces.IHobby;
import dto.HobbyDTO;
import entity.Hobby;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jesper
 */
public class FHobby implements IHobby {

    EntityManagerFactory emf;

    public FHobby(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Hobby getHobbyByIDRaw(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Hobby.FindByID", Hobby.class).setParameter("id", id).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public HobbyDTO getHobbyByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("HobbyDTO.findByName", HobbyDTO.class).setParameter("name", name).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Hobby> getAllHobbiesRaw() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Hobby.findAll", Hobby.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<HobbyDTO> getAllHobbies() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("HobbyDTO.findAll", HobbyDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public HobbyDTO createHobby(Hobby hobby) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HobbyDTO(hobby.getId(), hobby.getName(), hobby.getDescription());
    }

    @Override
    public HobbyDTO updateHobby(HobbyDTO updatedHobby) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Hobby h = em.find(Hobby.class, updatedHobby.getId());
            h.setName(updatedHobby.getName());
            h.setDescription(updatedHobby.getDescription());
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return updatedHobby;
    }

    @Override
    public void deleteHobbyByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Hobby h = em.find(Hobby.class, id);
            em.remove(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteHobbyByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            HobbyDTO h = getHobbyByName(name);
            Hobby entity = em.find(Hobby.class, h.getId());
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
