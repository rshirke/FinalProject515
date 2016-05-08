/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.service;

import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Website;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rohan
 */
@Stateless
public class WebsiteService extends AbstractService<Website>{

     @PersistenceContext(unitName = "rshirkePU")
    private EntityManager em;

    
    public WebsiteService() {
         super(Website.class);
    }

   

    public WebsiteService(Class entityClass) {
        super(entityClass);
    }   

    public void create(Website l) {
        em.persist(l);
        em.flush();
    }

    public void update(Website l) {
        em.merge(l);
    }

    public void remove(Website l) {
        em.remove(l);
    }

    public Website find(long id) {
        
        Query query = em.createNamedQuery("Website.findbyId");
        query.setParameter("siteid", id);
        Website site1 = (Website) query.getSingleResult();       
        return site1;
    }

     @Override
    public List<Website> findAll() {
        return em.createNamedQuery("Website.findAll",
                Website.class).getResultList();
    }

    public Website findByname(String site_name) {
        return em.createNamedQuery("Website.findByname",
                Website.class)
                .setParameter("site_name", site_name)
                .getSingleResult();
    }
    
    
    
}
