package entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@DiscriminatorValue("COMPANY")
@NamedQueries({
    @NamedQuery(name = "company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "companyDTO.findCompanyByCVR", query = "SELECT NEW DTO.CompanyDTO(c.id, c.name, c.description, c.cvr, c.numEmployees, c.marketValue, c.email, c.address) FROM Company c WHERE c.cvr = :cvr")})
public class Company extends InfoEntity {

    private static final long serialVersionUID = 1L;
    private String name, description;
    private int cvr, numEmployees, marketValue;

    public Company() {
    }

    public Company(String name, String description, int cvr, int numEmployees, int marketValue, String email, List<Phone> phones, Address address) {
        super(email, phones, address);
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

}
