/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name="countries")
public class Country implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idCountry;
    private String nameCountry;
    @ManyToOne
    private Region region;

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
