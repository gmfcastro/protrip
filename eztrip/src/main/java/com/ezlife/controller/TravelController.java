/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.TravelDAO;
import com.ezlife.login.Permission;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Travel;
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
    private TravelerSession userSession;
    
    public TravelController(Result result, TravelDAO dao, TravelerSession userSession){
        this.result = result;
        this.dao = dao;
        this.userSession = userSession;
    }
    
    @Path("")
    public void list(){
        List<Travel> list = dao.findMyTravels(userSession.getTraveler());
        result.include("viagens", list);
        result.include("session", userSession.getTraveler());
    }
    
}
