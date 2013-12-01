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
import com.ezlife.login.UserSession;
import com.ezlife.model.Traveler;
import com.ezlife.model.User;

/**
 *
 * @author guilherme
 */
@Resource
@Public
public class UserController{
    
    private Result result;
    private UserDAO dao;
    private UserSession userSession;
    
    public UserController(Result result, UserDAO dao, UserSession userSession){
        this.result = result;
        this.dao = dao;
        this.userSession = userSession;
    }
    
    @Post("/authenticate")
    public void authenticate(String email, String password){
        
       Traveler t = dao.findUser(email,password);
       if(t== null){
           result.include("erro", "Usuário não existe");
           result.include("session", null);
       }else{
           userSession.setUser(t.getUser());
           result.include("session", t.getUser());
           result.redirectTo(IndexController.class).index();
       }       
    }   
   
    @Post("/logout")
    public void logout(){
        userSession.setUser(null);
        result.include("session",userSession.getUser());
        result.forwardTo(IndexController.class).index();
    }
}
