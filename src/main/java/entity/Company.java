package entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@DiscriminatorValue("COMPANY")
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
