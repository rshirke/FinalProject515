/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.service;

import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Product;
import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Website;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rohan
 */
@Named
@Stateless
public class ProductService extends AbstractService<Product> {
    
    
   
    @PersistenceContext(unitName = "rshirkePU")
    private EntityManager em;

     public ProductService() {
        super(Product.class);
    }
     
    public void create(Product l) {
        
      
        em.persist(l);
        em.flush();
       
    }

    public void update(Product l) {
        em.merge(l);
    }

    public void remove(Product l) {
        em.remove(l);
    }

    public Product find(long id) {
        return em.find(Product.class, id);
    }

    //@Override
    public List<Product> findAll() {
        return em.createNamedQuery("Product.findall",
                Product.class).getResultList();
    }

    public Product findByname(String product_name) {
        return em.createNamedQuery("Product.findByname",
                Product.class)
                .setParameter("product_name", product_name)
                .getSingleResult();
    }
    
}
