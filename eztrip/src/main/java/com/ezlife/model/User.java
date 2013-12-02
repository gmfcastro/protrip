/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name="users")
public class User implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    @Enumerated
    private UserRoles userRole; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastAcesss;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoles userRole) {
        this.userRole = userRole;
    }

    public Date getLastAcesss() {
        return lastAcesss;
    }

    public void setLastAcesss(Date lastAcesss) {
        this.lastAcesss = lastAcesss;
    }
    
    
}
