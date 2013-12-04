/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.dao;

import br.com.caelum.vraptor.ioc.Component;
import com.ezlife.model.Travel;
import com.ezlife.model.Traveler;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
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
    
    public List<Travel> findMyTravels(Traveler traveler){
        Query q = session.createQuery("Select t.travels from Traveler t where t.id="+traveler.getId());
        List<Travel> trips = q.list();
        
        return trips;
    }
    
    public List<Object[]> findDestMaisProcurados(String dataIda,String dataVolta){
        Query q = session.createQuery("Select t.toCity.name,count(t.toCity.name) from Travel t where t.dateGo between'"+dataIda+"' and '"+dataVolta+"' group by t.toCity.name ");
        
        List<Object[]> list = q.list();
        
        return list;
    }
    
}
