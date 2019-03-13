package dto;

/**
 *
 * @author Jesper, Michael
 */
public class PhoneDTO {

    private int id;
    private String number, description;
    private int infoEntityID;

    public PhoneDTO(int id, String number, String description, int infoEntityID) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.infoEntityID = infoEntityID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getInfoEntityID() {
        return infoEntityID;
    }

    public void setInfoEntityID(int infoEntityID) {
        this.infoEntityID = infoEntityID;
    }

}
