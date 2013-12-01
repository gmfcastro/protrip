/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.dao.UserDAO;
import com.ezlife.login.Public;
import com.ezlife.login.TravelerSession;
import com.ezlife.model.Traveler;
import com.ezlife.model.User;
import com.ezlife.model.UserRoles;

/**
 *
 * @author guilherme
 */
@Resource
@Public
public class UserController{
    
    private Result result;
    private UserDAO dao;
    private TravelerSession userSession;
    
    public UserController(Result result, UserDAO dao, TravelerSession userSession){
        this.result = result;
        this.dao = dao;
        this.userSession = userSession;
    }
    
    @Post("/authenticate")
    public void authenticate(String email, String password){
        
       Traveler t = dao.findTraveler(email,password);
       if(t== null){
           result.include("erro", "Usuário não existe");
           result.include("session", null);
       }else{
           userSession.setTraveler(t);
           result.include("session", t);
           result.redirectTo(IndexController.class).index();
       }       
    }
    
    @Post("/admin/authenticate")
    public void adminAuthenticate(String email, String password){
        
        User admin = dao.findUser(email, password);
        if(admin == null){
            result.include("erro", "Administrador não existe");
            result.include("session", null);
            result.redirectTo(IndexController.class).admin();
        }else{
            if(admin.getUserRole().equals(UserRoles.ADMIN)){
                Traveler t = new Traveler();
                t.setUser(admin);
                userSession.setTraveler(t);
                result.include("session",t);
                result.redirectTo(IndexController.class).admin();
            }else{
                result.include("erro", "Usuário não tem permissão");
                result.redirectTo(IndexController.class).admin();
            }
        }
   }
   
    @Post("/logout")
    public void logout(){
        userSession.logout();
        result.include("session",userSession.getTraveler());
        result.forwardTo(IndexController.class).index();
    }
    
    @Post("/admin/logout")
    public void adminLogout(){
        userSession.logout();
        result.include("session",userSession.getTraveler());
        result.forwardTo(IndexController.class).index();
    }
}
