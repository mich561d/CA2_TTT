/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.PhoneDTO;
import entity.Phone;

/**
 *
 * @author Admin
 */
public interface IPhone {
    public abstract Phone getPhoneByNumber(String number);
    public abstract PhoneDTO getPhoneByNumberRaw(String number);

}
