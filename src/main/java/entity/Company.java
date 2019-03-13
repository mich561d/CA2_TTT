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
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "CompanyDTO.findByPhone", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description, c.address, c.phones) FROM Company c WHERE c.phones.number = :phone")
    , @NamedQuery(name = "CompanyDTO.findByCVR", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description, c.address, c.phones) FROM Company c WHERE c.cvr = :cvr")
    , @NamedQuery(name = "CompanyDTO.findByEmployeeCountMoreThan", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description, c.address, c.phones.number) FROM Company c WHERE c.numEmployees > :amount")})
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
