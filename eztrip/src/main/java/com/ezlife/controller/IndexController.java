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
public class IndexController {
    
    private Result result;
    private UserSession userSession;
    
    public IndexController(Result result, UserSession userSession){
        this.result = result;
        this.userSession = userSession;
    }
    
    @Path("/")
    public void index(){
       result.include("session", userSession.getUser());
    }
    
}
