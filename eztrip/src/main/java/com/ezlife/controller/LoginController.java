/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author guilherme
 */
@Resource
public class LoginController {
    
    private Result result;
    
    public LoginController(Result result){
        this.result = result;
    }
    
    @Path("/register")
    public void register(){
        
    }
    
}
