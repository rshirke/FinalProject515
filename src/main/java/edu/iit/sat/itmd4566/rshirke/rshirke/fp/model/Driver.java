/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.model;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Rohan
 */
public class Driver {

    public static void main(String args[]) {
        //creating a website and then adding that website to a product and then persist website and product and then check the database..

        //similarly we need to do for rest of the tables..
//        
//        
//        
//        Website w1= new Website("amazon.com","www.amazon.com","amazon big website in the world");
//        
//        Website w2= new Website("flipkart.com","www.flipkkart.com","flipkart big website in the india");
//        Product p1 = new Product("iphone","apple mobile","www.apple.com",649.99);
//        
//        Product p2 = new Product("samsung","samsung mobile","www.samsung.com",449.99);
//        
//       
//        w1.addWebsite(p1);
//        w2.addWebsite(p2);
//        
//        
//        Website tempsite = new Website();
//        
//        tempsite = p1.getWebsite();
//        
//        
//        
//        System.out.println(tempsite.getSite_id()+ " sitename: " + tempsite.getSite_name() +" siteurl: "+ tempsite.getSite_url());
//        
//        Prod_Hist ph1 = new Prod_Hist("www.amazon.com",345.67, new GregorianCalendar(2, 5, 2012).getTime());
//        
//        ph1.setProduct_name("Product_Name");
//        ph1.setSite_id("123456");
//        
//        Prod_Hist ph2 = new Prod_Hist("www.amazon123.com", 5745.57, new GregorianCalendar(2, 5, 2012).getTime());
//        
//        
//         ph2.setProduct_name("Product_Name");
//        ph2.setSite_id("123456");
//        
//        
//        Prod_Hist ph3 = new Prod_Hist("www.amazon12345.com", 3454.57, new GregorianCalendar(2, 5, 2012).getTime());
//        
//         ph3.setProduct_name("Product_Name");
//        ph3.setSite_id("123456");
//        
//      //  w1.addProduct(ph1);
//        p1.addProduct(ph1);
//        
//       // w2.addProduct(ph2);
//        p2.addProduct(ph2);
//        
//       // w1.addProduct(ph3);
//        p1.addProduct(ph3);
//        
//        Clicked_History C1 = new Clicked_History();
//        
//        Clicked_History C2 = new Clicked_History();
//        
//        Clicked_History C3 = new Clicked_History();
//        
//        
//       Clicked_History C1 = new Clicked_History();
//        Website w1= new Website("amazon.com","www.amazon.com","amazon big website in the world");
//        Query_History Q1 = new Query_History("MObiel search Query1", "Status false","userid_temp1", new GregorianCalendar(2, 5, 2012).getTime());
//        
//        Q1.addclickhistory(C1);
//        w1.addclickhistory(C1);
//        
//        Query_History Q2 = new Query_History("MObiel search Query2", "Status false2","userid_temp2", new GregorianCalendar(2, 5, 2012).getTime());
//        
//        
//        Q2.addclickhistory(C2);
//        w1.addclickhistory(C2);
//        
//        Query_History Q3 = new Query_History("MObiel search Query3", "Status false3","userid_temp3", new GregorianCalendar(2, 5, 2012).getTime());
//                
//        Q3.addclickhistory(C1);
//        w2.addclickhistory(C1);
//        
//        
//         Q1.addclickhistory(C3);
//        w1.addclickhistory(C3);
//        
//        
//        Clicked_History C4 = new Clicked_History();
//        
//        Q1.addclickhistory(C4);
//        w1.addclickhistory(C4);
//        
//        Product p1 = new Product("iphone","apple mobile","www.apple.com",649.99);
//        NotifyAlert N1 = new NotifyAlert("rshirke@hawk.iit.edu", 50.00);
//        
//        p1.addProductnotify(N1);
//        
//        NotifyAlert N2 = new NotifyAlert("rshirke@hawk.iit.edu2", 52.00);
//        
//        p2.addProductnotify(N2);
//        
//        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rshirkePU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        // do stuff with em
//        tx.begin();
//        em.persist(w1);
//        em.persist(p1);
//         em.persist(w2);
//        em.persist(p2);
//        
//        
//        em.persist(ph1);
//         em.persist(ph2);
//          em.persist(ph3);
//          em.persist(C1);
//          em.persist(C2);
//          em.persist(C3);
//          em.persist(C4);
////          em.persist(N1);
////          em.persist(N2);
//        tx.commit();
//
//        //System.out.println("Composer is:" + score.getComposer().getLastName());
////        System.out.println("Scores for Composer: " + c.getMusicalScores());
//        
//        em.close();
//        emf.close();
    }

}
