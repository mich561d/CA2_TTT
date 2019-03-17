package facade;

import interfaces.ICompany;
import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.CompanyDTO;
import entity.Company;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Michael, Jesper
 */
public class FCompany implements ICompany {

    EntityManagerFactory emf;

    public FCompany(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Company getCompanyByIDRaw(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Company.class, id);//em.createNamedQuery("Company.findById", Company.class).setParameter("id", id).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public CompanyDTO getCompanyByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findByEmail", CompanyDTO.class).setParameter("email", email).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public CompanyDTO getCompanyByPhone(Phone phone) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findByPhone", CompanyDTO.class).setParameter("number", phone).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public CompanyDTO getCompanyByCVR(int cvr) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findByCVR", CompanyDTO.class).setParameter("cvr", cvr).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findAll", CompanyDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CompanyDTO> getAllCompaniessByCity(CityInfoDTO city) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findByCity", CompanyDTO.class).setParameter("zip", city.getZipCode()).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CompanyDTO> getAllCompaniesByAddress(AddressDTO address) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findAllByAddress", CompanyDTO.class).setParameter("street", address.getStreet()).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CompanyDTO> getAllCompaniesWithNumEmployeesOver(int amount) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findByEmployeeCountMoreThan", CompanyDTO.class).setParameter("amount", amount).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<CompanyDTO> getAllCompaniesWithMarketValueOver(int value) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("CompanyDTO.findByMarketValueHigherThan", CompanyDTO.class).setParameter("value", value).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public CompanyDTO createCompany(Company company) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        List<String> phones = new ArrayList();
        for (int i = 0; i < company.getPhones().size(); i++) {
            phones.add(company.getPhones().get(i).getNumber());
        }

        return new CompanyDTO(company.getId(), company.getCvr(), company.getNumEmployees(), company.getMarketValue(), company.getEmail(), company.getName(), company.getDescription(), company.getAddress().getStreet(), phones);
    }

    @Override
    public CompanyDTO updateCompany(CompanyDTO updatedCompany) {
        EntityManager em = emf.createEntityManager();
        Company c;
        try {
            c = em.find(Company.class, updatedCompany.getId()); //= getCompanyByIDRaw(updatedCompany.getId());
            c.setName(updatedCompany.getName());
            c.setDescription(updatedCompany.getDescription());
            c.setCvr(updatedCompany.getCvr());
            c.setNumEmployees(updatedCompany.getNumEmployees());
            c.setMarketValue(updatedCompany.getMarketValue());
            c.setEmail(updatedCompany.getEmail());
            em.getTransaction().begin();
//            em.merge(c);
            em.refresh(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        List<String> phones = new ArrayList();
        for (int i = 0; i < phones.size(); i++) {
            phones.add(c.getPhones().get(i).getNumber());
        }

        return new CompanyDTO(c.getId(), c.getCvr(), c.getNumEmployees(), c.getMarketValue(), c.getEmail(), c.getName(), c.getDescription(), c.getAddress().getStreet(), phones);

    }

    @Override
    public void deleteCompany(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Company c = getCompanyByIDRaw(id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
