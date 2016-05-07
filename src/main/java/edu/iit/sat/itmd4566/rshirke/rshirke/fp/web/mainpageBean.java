/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.web;


import java.util.logging.Logger;
import java.util.logging.Level;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rohan
 */
@Named
@RequestScoped
public class mainpageBean extends AbstractJSFBean {
    
    @NotNull(message = "Kindly enter product name!")
    private String searchstring;
    
    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    
    public String doSearch() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
           LOG.log(Level.SEVERE, "The Search String is "+ searchstring);
           
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "There has been a problem when search query was hit", ex);
            facesContext.addMessage(null, new FacesMessage("Bad Login", "Detail: You made a bad login!"));
            // return the user to the login page with an error message
            return "/login.xhtml";
        }

        // send user to welcome page
        return "/mainpage.xhtml";
    }
    
}
