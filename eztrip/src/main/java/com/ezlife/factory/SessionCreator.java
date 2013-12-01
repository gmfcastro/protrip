/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ezlife.factory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.Session;

/**
 *
 * @author Andre
 */
@Component
public class SessionCreator implements ComponentFactory<Session> {

    private Session session;

    @PostConstruct
    public void create() {
        this.session = HibernateFactory.getSession();
    }

    @Override
    public Session getInstance() {
        return session;
    }

    @PreDestroy
    public void destroy() {
        this.session.close();
    }
}
