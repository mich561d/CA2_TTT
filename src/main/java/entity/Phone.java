package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jesper, Michael, Mads
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
    , @NamedQuery(name = "PhoneDTO.findByNumber", query = "SELECT NEW dto.PhoneDTO(p.id, p.number, p.description, p.infoEntity.id) FROM Phone p WHERE p.number = :number")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number, description;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private InfoEntity infoEntity;

    public Phone() {
    }

    public Phone(String number, String description, InfoEntity infoEntity) {
        this.number = number;
        this.description = description;
        this.infoEntity = infoEntity;
    }

    public Phone(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
    }

    public String toSql() {
        return "INSERT INTO PERSON (NUMBER,DESCRIPTION) VALUES ('" + this.number + "','" + this.description + "');\n";
    }
}
