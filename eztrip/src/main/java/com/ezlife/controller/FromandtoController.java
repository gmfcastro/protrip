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
import com.ezlife.dao.FromandtoDAO;
import com.ezlife.login.Permission;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Country;
import com.ezlife.model.Fromandto;
import com.ezlife.model.UserRoles;
import java.util.List;

/**
 *
 * @author guilherme
 */
@Resource
@Permission(UserRoles.ADMIN)
public class FromandtoController {
    
    private Result result;
    private FromandtoDAO dao;
    private CountryDAO countryDAO;
    private TravelerSession userSession;
    
    public FromandtoController(Result result, FromandtoDAO dao, CountryDAO countryDAO, TravelerSession userSession){
        this.result = result;
        this.dao = dao;
        this.countryDAO = countryDAO;
        this.userSession = userSession;
    }
    
    @Path("/admin/fromandto")
    public void list(){
        List<Fromandto> list = dao.findAll();
        result.include("fromandtos", list);
    }
    
    @Path("/admin/fromandto/add")
    public void add(){
        List<Country> listC = countryDAO.findAll();
        result.include("countries",listC);
    }
    
    @Path("/admin/fromandto/edit/{id}")
    public void edit(Long id){
       Fromandto ft = dao.findById(id);
       result.include("fromandto", ft);
       List<Country> listC = countryDAO.findAll();
        result.include("countries",listC);
    }
    
    @Path("/admin/fromandto/remove/{id}")
    public void delete(Long id){
        Fromandto ft = dao.findById(id);
        dao.delete(ft);
        result.redirectTo(FromandtoController.class).list();
    }
    
    @Post("/admin/fromandto/save")
    public void save(Fromandto fromandto, Long countryId){
        Country c = countryDAO.findById(countryId);
        fromandto.setCountry(c);
        dao.saveOrUpdate(fromandto);
        result.redirectTo(FromandtoController.class).list();
    }

}
