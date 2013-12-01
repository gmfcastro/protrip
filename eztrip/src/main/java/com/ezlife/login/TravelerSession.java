/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.login;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import com.ezlife.model.Traveler;
import com.ezlife.model.User;
import java.io.Serializable;

/**
 *
 * @author guilherme
 */
@Component
@SessionScoped
public class TravelerSession implements Serializable{
    
  private Traveler traveler;
   
  public Traveler getTraveler() {
        return traveler;
   }
  
   public User getUser(){
       return traveler.getUser();
   }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }
    
    public void setUser(User user) {
        this.traveler.setUser(user);
    }

    public boolean isLogged() {
        return traveler != null;
    }

    public void logout() {
        traveler = null;
    }   
}


