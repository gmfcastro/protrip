/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Travel;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
@Component
public class TravelDAO extends GenericDAO<Travel>{
    
    public TravelDAO(Session session){        
        super(session);
    }   
}
