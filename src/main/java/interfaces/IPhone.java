package interfaces;

import dto.PhoneDTO;
import entity.Phone;

/**
 *
 * @author Jesper, Michael
 */
public interface IPhone {

    public abstract PhoneDTO getPhoneByNumber(String number);

    public abstract Phone getPhoneByNumberRaw(String number);

}
