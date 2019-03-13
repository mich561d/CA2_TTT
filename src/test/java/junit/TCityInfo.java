package junit;

import dto.CityInfoDTO;
import facade.FCityInfo;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class TCityInfo {

    FCityInfo facade = new FCityInfo(Persistence.createEntityManagerFactory("pu-test", null));

    @Test
    public void testGetAllCities() {
        List<CityInfoDTO> cities = facade.getAllCities();
        assertEquals(1352, cities.size());
    }
}
