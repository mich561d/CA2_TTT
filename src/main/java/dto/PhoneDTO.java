/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.InfoEntity;

/**
 *
 * @author Admin
 */
public class PhoneDTO {
    private int id;
    private String number, description;
    private InfoEntity infoEntity;

    public PhoneDTO(int id, String number, String description, InfoEntity infoEntity) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.infoEntity = infoEntity;
    }


    
    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
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
    
    
}
