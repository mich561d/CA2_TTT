package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@DiscriminatorValue("C")
@Table(name = "COMPANY")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    , @NamedQuery(name = "CompanyDTO.findAll", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c")
    , @NamedQuery(name = "CompanyDTO.findByEmail", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c WHERE c.email = :email")
    , @NamedQuery(name = "CompanyDTO.findByPhone", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c WHERE :number MEMBER OF c.phones")
    , @NamedQuery(name = "CompanyDTO.findByCVR", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c WHERE c.cvr = :cvr")
    , @NamedQuery(name = "CompanyDTO.findAllByAddress", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c, Address a WHERE c MEMBER OF a.infoEntities AND a.street = :street")
    , @NamedQuery(name = "CompanyDTO.findByCity", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c, Address a WHERE c MEMBER OF a.infoEntities AND a.cityInfo.zip = :zip")
    , @NamedQuery(name = "CompanyDTO.findByEmployeeCountMoreThan", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c WHERE c.numEmployees > :amount")
    , @NamedQuery(name = "CompanyDTO.findByMarketValueHigherThan", query = "SELECT NEW dto.CompanyDTO(c.id, c.cvr, c.numEmployees, c.marketValue, c.email, c.name, c.description) FROM Company c WHERE c.marketValue > :value")})
public class Company extends InfoEntity {

    private static final long serialVersionUID = 1L;
    private String name, description;
    @NotNull
    @Column(unique = true)
    private int cvr;
    private int numEmployees, marketValue;

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

    public String toSql() {
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO ADDRESS (STREET,ADDITIONALINFO,CITYINFO_ID) VALUES ('").append(this.getAddress().getStreet()).append("','").append(this.getAddress().getAdditionalInfo()).append("','").append(this.getAddress().getCityInfo().getId()).append("');");
        str.append("INSERT INTO INFOENTITY (ENTITY_TYPE,EMAIL,ADRESS_ID) VALUES ('C','").append(this.getEmail()).append("',LAST_INSERT_ID());\n");
        str.append("INSERT INTO COMPANY (ID,CVR,DESCRIPTION,MARKETVALUE,NAME,NUMEMPLOYEES) VALUES (LAST_INSERT_ID(),'").append(this.cvr).append("','").append(this.description).append("','").append(this.marketValue).append("','").append(this.name).append("','").append(this.numEmployees).append("');\n");
        str.append("INSERT INTO PHONE(INFOENTITY_ID,DESCRIPTION,NUMBER) VALUES (LAST_INSERT_ID(),'").append(this.getPhones().get(0).getDescription()).append("','").append(this.getPhones().get(0).getNumber()).append("');\n");
        return str.toString();
    }
}
