package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CityInfo.findAll", query = "SELECT c FROM CityInfo c")
    , @NamedQuery(name = "CityInfo.findByZipCode", query = "SELECT c FROM CityInfo c WHERE c.zip = :zip")
    , @NamedQuery(name = "CityInfoDTO.findAll", query = "SELECT NEW dto.CityInfoDTO(c.id, c.zip, c.city) FROM CityInfo c")
    , @NamedQuery(name = "CityInfoDTO.findByZipCode", query = "SELECT NEW dto.CityInfoDTO(c.id, c.zip, c.city) FROM CityInfo c WHERE c.zip = :zip")
    , @NamedQuery(name = "CityInfo.findAllZipCodes", query = "SELECT NEW dto.CityInfoDTO(c.zip) FROM CityInfo c")})
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String zip;
    private String city;
    @OneToMany(mappedBy = "cityInfo", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Address> addresses;

    public CityInfo() {
    }

    public CityInfo(String zip, String city, List<Address> addresses) {
        this.zip = zip;
        this.city = city;
        this.addresses = addresses;
    }

    public CityInfo(String zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CityInfo other = (CityInfo) obj;
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        return true;
    }
    
    

}
