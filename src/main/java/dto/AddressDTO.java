package dto;

/**
 *
 * @author Michael
 */
public class AddressDTO {

    private int id;
    private String street, description;

    public AddressDTO(int id, String street, String description) {
        this.id = id;
        this.street = street;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
