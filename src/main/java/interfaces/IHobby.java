package interfaces;

import dto.HobbyDTO;
import entity.Hobby;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface IHobby {

    public abstract Hobby getHobbyByIDRaw(int id);

    public abstract HobbyDTO getHobbyByName(String name);

    public abstract List<Hobby> getAllHobbiesRaw();

    public abstract List<HobbyDTO> getAllHobbies();

    public abstract HobbyDTO createHobby(Hobby hobby);

    public abstract HobbyDTO updateHobby(HobbyDTO updatedHobby);

    public abstract void deleteHobbyByID(int id);

    public abstract void deleteHobbyByName(String name);
}
