/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.CountryDAO;
import com.ezlife.dao.RegionDAO;
import com.ezlife.login.Permission;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Country;
import com.ezlife.model.Region;
import com.ezlife.model.UserRoles;
import java.util.List;

/**
 *
 * @author guilherme
 */
@Resource
@Permission(UserRoles.ADMIN)
public class CountryController {
    
    private Result result;
    private CountryDAO dao;
    private TravelerSession userSession;
    private RegionDAO regionDao;
    
    public CountryController(Result result, CountryDAO dao, TravelerSession userSession, RegionDAO regionDao){
        this.result = result;
        this.dao = dao;
        this.userSession = userSession;
        this.regionDao = regionDao;
    }
    
    @Path("/admin/country")
    public void list(){
        List<Country> list = dao.findAll();
        result.include("countries", list);
    }
    
    @Path("/admin/country/add")
    public void add(){
        List<Region> listR = regionDao.findAll();
        result.include("regions",listR);
    }
    
    @Path("/admin/country/edit/{id}")
    public void edit(Long id){
       Country c = dao.findById(id);
       result.include("country", c);
       List<Region> listR = regionDao.findAll();
        result.include("regions",listR);
    }
    
    @Path("/admin/country/remove/{id}")
    public void delete(Long id){
        Country c = dao.findById(id);
        dao.delete(c);
        result.redirectTo(CountryController.class).list();
    }
    
    @Post("/admin/country/save")
    public void save(Country country, Long regionId){
        Region r = regionDao.findById(regionId);
        country.setRegion(r);
        dao.saveOrUpdate(country);
        result.redirectTo(CountryController.class).list();
    }
}
