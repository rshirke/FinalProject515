/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.web;

import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Website;
import edu.iit.sat.itmd4566.rshirke.rshirke.fp.service.WebsiteService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rohan
 */
//@Named
//@RequestScoped
@ManagedBean
@SessionScoped
public class WedSiteAdd extends AbstractJSFBean implements Serializable{
    
    
     @EJB 
    private WebsiteService websiteservice;
    
     @Size(min = 3, message = "Password must be at least 3 characters in length.")
    private String websitename;
    @NotNull(message = "You shall not pass without a username!")
    private String websiteurl;
    @NotNull(message = "You shall not pass without a username!")
    private String websitedescription;
     
    
    public String insertWebsite() {
    HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            
            Website w7 = new Website(websitename,websiteurl, websitedescription);
            
            websiteservice.create(w7);
            
        } catch (Exception ex) {
           
           
            // return the user to the login page with an error message
            return "/error.xhtml";
        }

        // return the user to the login page
        return "/admin/welcome.xhtml";
    
    }
     
     public String addWebsite() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            
            
        } catch (Exception ex) {
           
           
            // return the user to the login page with an error message
            return "/error.xhtml";
        }

        // return the user to the login page
        return "/addWebsite.xhtml";
    }

    public String getWebsitename() {
        return websitename;
    }

    public void setWebsitename(String websitename) {
        this.websitename = websitename;
    }

    public String getWebsiteurl() {
        return websiteurl;
    }

    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    public String getWebsitedescription() {
        return websitedescription;
    }

    public void setWebsitedescription(String websitedescription) {
        this.websitedescription = websitedescription;
    }
    
    
    
}
