package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITY_TYPE")
@NamedQueries({
    @NamedQuery(name = "PersonDTO.findPersonByPNumber", query = "SELECT NEW DTO.PersonDTO() FROM InfoEntity e WHERE e.phones.number = :number")
    , @NamedQuery(name = "CompanyDTO.findCompanyByPNumber", query = "SELECT NEW dto.CompanyDTO() FROM InfoEntity e WHERE e.phones.number = :number")})
public class InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @OneToMany(mappedBy = "infoEntity")
    private List<Phone> phones;
    @ManyToOne
    private Address address;

    public InfoEntity() {
    }

    public InfoEntity(String email, List<Phone> phones, Address address) {
        this.email = email;
        this.phones = phones;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
