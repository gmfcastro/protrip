/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.RegionDAO;
import com.ezlife.login.Permission;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Region;
import com.ezlife.model.UserRoles;
import java.util.List;

/**
 *
 * @author guilherme
 */
@Resource
@Permission(UserRoles.ADMIN)
public class RegionController {
    
    private Result result;
    private RegionDAO dao;
    private TravelerSession userSession;
    
    public RegionController(Result result, RegionDAO dao, TravelerSession userSession){
        this.result = result;
        this.dao = dao;
        this.userSession = userSession;
    }
    
    @Path("/admin/region")
    public void list(){
        List<Region> list = dao.findAll();
        result.include("regions", list);
    }
    
    @Path("/admin/region/add")
    public void add(){
        
    }
    
    @Path("/admin/region/edit/{id}")
    public void edit(Long id){
       Region r = dao.findById(id);
       result.include("region", r);
    }
    
    @Path("/admin/region/remove/{id}")
    public void delete(Long id){
        Region r = dao.findById(id);
        dao.delete(r);
        result.redirectTo(RegionController.class).list();
    }
    
    @Post("/admin/region/save")
    public void save(Region region){
        dao.saveOrUpdate(region);
        result.redirectTo(RegionController.class).list();
    }
    
}
