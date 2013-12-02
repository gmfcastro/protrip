/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Fromandto;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
@Component
public class FromandtoDAO extends GenericDAO<Fromandto>{
    
    public FromandtoDAO(Session session){
        super(session);
    }
}
