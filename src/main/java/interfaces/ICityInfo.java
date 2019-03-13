package interfaces;

import dto.CityInfoDTO;
import entity.CityInfo;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface ICityInfo {

    public abstract List<CityInfoDTO> getAllCities();

    public abstract CityInfoDTO getCityByZip(String zip);

    public abstract List<String> getAllZipCodes();

    public abstract List<CityInfo> getAllCitiesRaw();
}
