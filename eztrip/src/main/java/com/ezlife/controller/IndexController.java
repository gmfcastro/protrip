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
public class IndexController {
    
    private Result result;
    
    public IndexController(Result result){
        this.result = result;
    }
    
    @Path("/")
    public void index(){
        
    }
    
}
