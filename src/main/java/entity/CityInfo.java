package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CityInfo.findAll", query = "SELECT c FROM CityInfo c")
    , @NamedQuery(name = "CityInfoDTO.findAll", query = "SELECT NEW dto.CityInfoDTO(c.id, c.zip, c.city) FROM CityInfo c")
    , @NamedQuery(name = "CityInfoDTO.findByZipCode", query = "SELECT NEW dto.CityInfoDTO(c.id, c.zip, c.city) FROM CityInfo c WHERE c.zip = :zip")
    , @NamedQuery(name = "CityInfo.findAllZipCodes", query = "SELECT c.zip FROM CityInfo c")})
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String zip, city;
    @OneToMany(mappedBy = "cityInfo", cascade = CascadeType.ALL)
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

}
