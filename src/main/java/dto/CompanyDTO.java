package dto;

import java.util.List;

/**
 *
 * @author Jesper, Michael
 */
public class CompanyDTO {

    private int id, cvr, numEmployees, marketValue;
    private String email, name, description, address;
    private List<String> phones;

    public CompanyDTO(int id, int cvr, int numEmployees, int marketValue, String email, String name, String description, String address, List<String> phones) {
        this.id = id;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
        this.email = email;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phones = phones;
    }

    public CompanyDTO(int id, int cvr, int numEmployees, int marketValue, String email, String name, String description) {
        this.id = id;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

}
