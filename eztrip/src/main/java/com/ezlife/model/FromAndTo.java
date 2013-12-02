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
@Table(name="fromandtos")
public class FromAndTo implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Country country;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    } 
}
