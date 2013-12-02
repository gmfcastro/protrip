/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.FromandtoDAO;
import com.ezlife.dao.TravelDAO;
import com.ezlife.dao.TravelerDAO;
import com.ezlife.login.Permission;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Fromandto;
import com.ezlife.model.Travel;
import com.ezlife.model.Traveler;
import com.ezlife.model.UserRoles;
import java.util.List;

/**
 *
 * @author guilherme
 */
@Resource
@Permission(UserRoles.USER)
@Path("/travel")
public class TravelController{
    
    private Result result;
    private TravelDAO dao;
    private FromandtoDAO fromandtoDAO;
    private TravelerDAO travelerDAO;
    private TravelerSession userSession;
    
    public TravelController(Result result, TravelDAO dao, TravelerSession userSession,FromandtoDAO fromandtoDAO, TravelerDAO travelerDAO){
        this.result = result;
        this.dao = dao;
        this.travelerDAO = travelerDAO;
        this.userSession = userSession;
        this.fromandtoDAO = fromandtoDAO;
    }
    
    @Path("")
    public void list(){
        List<Travel> list = dao.findMyTravels(userSession.getTraveler());
        result.include("viagens", list);
        result.include("session", userSession.getTraveler());
    }
    
    @Path("/add")
    public void add(){
        
        List<Fromandto> listFromandtos = fromandtoDAO.findAll();
        result.include("destinos",listFromandtos);
        result.include("session", userSession.getTraveler());
    }
    
    @Path("/edit/{id}")
    public void edit(Long id){
        Travel t = dao.findById(id);
        List<Fromandto> listFromandtos = fromandtoDAO.findAll();
        result.include("travel",t);
        result.include("destinos",listFromandtos);
        result.include("session", userSession.getTraveler());
    }
    
    @Post("/save")
    public void save(Travel travel, Long fromandtoIdFrom, Long fromandtoIdDest){
        
           Fromandto from = fromandtoDAO.findById(fromandtoIdFrom);
           Fromandto dest = fromandtoDAO.findById(fromandtoIdDest);
           
           travel.setToCity(dest);
           travel.setFromCity(from);
           
           Traveler traveler = userSession.getTraveler();
           
           traveler.getTravels().add(travel);
           dao.flush();
           travelerDAO.saveOrUpdate(traveler);
           result.include("mensagem", "Viagem cadastrada");
           result.redirectTo(TravelController.class).list();
    }
    
    @Path("/remove/{id}")
    public void remove(Long id){
        Traveler traveler = userSession.getTraveler();
        List<Travel> listT = traveler.getTravels();
        Travel t = dao.findById(id);
        for (Travel tl:listT){
            if(tl.getId() == t.getId()){
                listT.remove(tl);
                break;
            }
        }
        dao.flush();
        travelerDAO.saveOrUpdate(traveler);
        result.include("mensagem", "Deletado com sucesso");
        result.redirectTo(TravelController.class).list();
    }
    
    @Post("/edit/save")
    public void editSave(Travel travel, Long fromandtoIdFrom, Long fromandtoIdDest){
       Fromandto from = fromandtoDAO.findById(fromandtoIdFrom);
       Fromandto dest = fromandtoDAO.findById(fromandtoIdDest);
       
       travel.setToCity(dest);
       travel.setFromCity(from);
       
       dao.saveOrUpdate(travel);
       result.include("mensagem", "Viagem cadastrada");
       result.redirectTo(TravelController.class).list();
    }
    
}
