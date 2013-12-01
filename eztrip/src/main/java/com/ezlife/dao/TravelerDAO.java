/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Traveler;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
@Component
public class TravelerDAO extends GenericDAO<Traveler>{
    
    public TravelerDAO(Session session){
        super(session);
    }
    
    public Traveler findByEmail(String email){
        Query q = session.createQuery("from Traveler t where t.user.email = '"+email+"'");
        
        Traveler t = (Traveler)q.uniqueResult();
        
        return  t;
    }
    
}
