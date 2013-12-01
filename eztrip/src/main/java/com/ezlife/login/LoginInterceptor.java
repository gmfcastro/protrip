/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.login;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import com.ezlife.controller.LoginController;
import com.ezlife.model.UserRoles;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author guilherme
 */
@Intercepts
public class LoginInterceptor implements Interceptor {

    private UserSession userSession;
    private Result result;
    private Method m;

    public LoginInterceptor(UserSession userSession, Result result) {
        this.userSession = userSession;
        this.result = result;
    }

    private boolean hasAccess(Permission permission) {
        if (permission == null) {
            return true;
        }
        Collection<UserRoles> roles = Arrays.asList(permission.value());

        return roles.contains(userSession.getUser().getUserRole());
    }

    @Override
    public void intercept(InterceptorStack is, ResourceMethod rm, Object o) throws InterceptionException {
        if (!userSession.isLogged()) {
            result.redirectTo(LoginController.class).login();
        } else {
            Permission methodPermission = rm.getMethod().getAnnotation(Permission.class);

            Permission controllerPermission = rm.getResource().getType().getAnnotation(Permission.class);

            if (hasAccess(methodPermission) && hasAccess(controllerPermission)) {
                is.next(rm, o);
            } else {
                System.out.println("Permission Denied");
            }
        }
    }

    @Override
    public boolean accepts(ResourceMethod rm) {
        return !rm.getResource().getType().isAnnotationPresent(Public.class);
    }
}
