/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.TravelDAO;
import com.ezlife.dao.TravelerDAO;
import com.ezlife.login.Permission;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Travel;
import com.ezlife.model.UserRoles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author guilherme
 */
@Resource
@Permission(UserRoles.ADMIN)
public class ReportController {
    
    private Result result;
    private TravelerDAO travelerDAO;
    private TravelDAO travelDAO;
    private TravelerSession userSession;
    
    public ReportController(Result result,TravelDAO travelDAO, TravelerDAO travelerDAO, TravelerSession userSession){
        this.result = result;
        this.travelerDAO = travelerDAO;
        this.travelDAO = travelDAO;
        this.userSession = userSession;
    }
    
    @Path("/admin/reports")
    public void report(){
        
    }
    
    @Path("/admin/reports/destinations")
    public void destinations(){
    }
    
    @Post("/admin/report/destinations/generate")
    public void generateDestinationsChart(String dataIda, String dataVolta) throws ParseException{
        List<Object[]> list = travelDAO.findDestMaisProcurados(dataIda,dataVolta);
        List<String> destinos = new ArrayList<String>();
        List<Integer> valores = new ArrayList<Integer>();
//        String destinos = "";
//        String valores=""; 
//        
        for(Object[] o:list){
            destinos.add(o[0].toString());
            valores.add(Integer.parseInt(o[1].toString()));
        }
//        
//        destinos = "["+destinos+"]";
//        valores = "["+valores+"]";
        
        result.include("valores",valores);
        result.include("destinos",destinos);
        result.redirectTo(ReportController.class).destinations();
    }
    
    @Path("/admin/reports/months")
    public void months(){
    
    }
    
    @Path("/admin/reports/travels")
    public void travels(){
        
    }
    
    public void createDataSet(){
        
        
        
    }
}
