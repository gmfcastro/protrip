/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.login;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import com.ezlife.model.User;
import java.io.Serializable;

/**
 *
 * @author guilherme
 */
@Component
@SessionScoped
public class UserSession implements Serializable{
    
  private User user;
   
  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return user != null;
    }

    public void logout() {
        user = null;
    }   
}


