/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.ezlife.login.Public;
import com.ezlife.login.TravelerSession;

/**
 *
 * @author guilherme
 */
@Resource
@Public
public class LoginController {
    
    private Result result;
    private TravelerSession userSession;
    
    public LoginController(Result result, TravelerSession userSession){
        this.result = result;
        this.userSession = userSession;
    }
    
    @Path("/register")
    public void register(){
        result.include("session", userSession.getTraveler());
    }
    
    @Path("/login")
    public void login(){
        result.include("session", userSession.getTraveler());
    }
    
}
