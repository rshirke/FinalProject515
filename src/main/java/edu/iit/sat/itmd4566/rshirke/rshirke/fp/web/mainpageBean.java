/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.web;


import edu.iit.sat.itmd4566.rshirke.rshirke.fp.service.ProductService;
import java.io.Serializable;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.sessions.serializers.Serializer;

/**
 *
 * @author Rohan
 */
@ManagedBean
@SessionScoped
public class mainpageBean extends AbstractJSFBean implements Serializable{
    
    
     @EJB
    private ProductService productservice;
    
    @NotNull(message = "Kindly enter product name!")
    private String searchstring;
    
    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    
    public String doSearch(String searchvalue) {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
           LOG.log(Level.SEVERE, "The Search String is "+ searchvalue);
           LOG.log(Level.SEVERE, "The Searchstring is "+ searchstring);
           
           
           
           
           //findout the product searched by user 
          // productservice.findByname(searchstring);
           
           //call the product service and find all the products 
           // returns list  product.findall string pass
           
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "There has been a problem when search query was hit", ex);
            facesContext.addMessage(null, new FacesMessage("Bad Login", "Detail: You made a bad login!"));
            // return the user to the login page with an error message
            return "/login.xhtml";
        }

        // send user to page main page where comparison will be made
        return "/mainpage.xhtml";
    }

    public String getSearchstring() {
        return searchstring;
    }

    public void setSearchstring(String searchstring) {
        this.searchstring = searchstring;
    }
    
}
