/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Traveler;
import com.ezlife.model.User;
import com.ezlife.model.UserRoles;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
@Component
public class UserDAO extends GenericDAO<User>{
    
    public UserDAO(Session session){
        super(session);
    }
    
    public Traveler findTraveler(String email, String password){
       Query q = session.createQuery("from Traveler t where t.user.email='"+email+"' and t.user.password='"+password+"'");
        Traveler t = (Traveler)q.uniqueResult();
        return t;
    }
    
    public User findUser(String email, String password){
        Query q = session.createQuery("from User u where u.email='"+email+"' and u.password='"+password+"'");
        User u = (User)q.uniqueResult();
        return u;
    }
    
}
