/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.PhoneDTO;

/**
 *
 * @author Admin
 */
public interface IPhone {
    
    public abstract PhoneDTO getPhoneByNumber(String number);
    
}
