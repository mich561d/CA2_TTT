package facade;

import dto.CityInfoDTO;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface ICityInfo {

    public abstract List<CityInfoDTO> getAllCities();
}
