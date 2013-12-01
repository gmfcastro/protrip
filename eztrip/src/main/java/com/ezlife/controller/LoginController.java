/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.login.Public;
import com.ezlife.login.UserSession;

/**
 *
 * @author guilherme
 */
@Resource
@Public
public class LoginController {
    
    private Result result;
    private UserSession userSession;
    
    public LoginController(Result result, UserSession userSession){
        this.result = result;
        this.userSession = userSession;
    }
    
    @Path("/register")
    public void register(){
        result.include("session", userSession.getUser());
    }
    
    @Path("/login")
    public void login(){
        result.include("session", userSession.getUser());
    }
    
}
