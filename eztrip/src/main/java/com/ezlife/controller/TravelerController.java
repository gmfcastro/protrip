/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.TravelerDAO;
import com.ezlife.login.Public;
import com.ezlife.model.Traveler;
import com.ezlife.model.UserRoles;
import java.util.Date;

/**
 *
 * @author guilherme
 */
@Resource
@Public
@Path("/traveler")
public class TravelerController {
    
    private Result result;
    private TravelerDAO dao;
    
    public TravelerController(Result result, TravelerDAO dao){
        
        this.result = result;
        this.dao = dao;
        
    }
    
    public void list(){
        
    }
    
    @Post("/save")
    public void save(Traveler traveler, String confirmPass){
       if(traveler.getUser().getPassword().equals(confirmPass)){
            Traveler t = dao.findByEmail(traveler.getUser().getEmail());
            if(t==null){
               traveler.getUser().setUserRole(UserRoles.USER);
               traveler.getUser().setLastAcesss(new Date());

               dao.saveOrUpdate(traveler);

               result.include("success", "Usuário cadastrado com sucesso!");
               result.redirectTo(IndexController.class).index();
            }else{
               result.include("error","Usuário com e-mail já cadastrado!");
               result.redirectTo(LoginController.class).register();
            }
        }else{
           result.include("error","A senha deve ser confirmada");
           result.redirectTo(LoginController.class).register();
        } 
     }
    
    @Path("/remove/{id}")
    public void remove(Long id){
        
    }
    
    public void edit(){
        
    }
    
    public void add(){
        
    }
    
}
