/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Region;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
@Component
public class RegionDAO extends GenericDAO<Region>{
    
    public RegionDAO(Session session){
        super(session);
    }
}
