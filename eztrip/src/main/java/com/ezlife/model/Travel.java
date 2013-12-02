/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.model;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.CustomScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name="travels")
public class Travel implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fromandto fromCity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fromandto toCity;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateGo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBack;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fromandto getFromCity() {
        return fromCity;
    }

    public void setFromCity(Fromandto fromCity) {
        this.fromCity = fromCity;
    }

    public Fromandto getToCity() {
        return toCity;
    }

    public void setToCity(Fromandto toCity) {
        this.toCity = toCity;
    }

    public Date getDateGo() {
        return dateGo;
    }

    public void setDateGo(Date dateGo) {
        this.dateGo = dateGo;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
    }
    
}
