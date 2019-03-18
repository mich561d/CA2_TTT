package exceptions;

/**
 *
 * @author Fen
 */
public class Entity2NotFoundException extends Exception{
    private String description;

    public Entity2NotFoundException(String description) {
        super(description);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
