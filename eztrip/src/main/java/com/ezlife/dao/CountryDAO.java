/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Country;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
@Component
public class CountryDAO extends GenericDAO<Country>{
    
    public CountryDAO(Session session){
        super(session);
    }
    
}
