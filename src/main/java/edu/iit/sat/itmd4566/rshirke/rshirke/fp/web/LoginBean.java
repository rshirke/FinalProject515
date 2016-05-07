/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author spyrisos
 */
@Named
@RequestScoped
public class LoginBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    @NotNull(message = "You shall not pass without a password!")
    @Size(min = 3, message = "Password must be at least 3 characters in length.")
    private String password;
    @NotNull(message = "You shall not pass without a username!")
    private String username;

    
    public LoginBean() {
        super();
    }

   

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemoteUser(){
        return facesContext.getExternalContext().getRemoteUser();
    }
    
    public boolean isAdmin() {
        return facesContext.getExternalContext().isUserInRole("admin");

    }

    public boolean isUser() {
        return facesContext.getExternalContext().isUserInRole("user");
    }

   
    // Fun: http://www.code-thrill.com/2012/08/stringbuilder-optimizations-demystified.html
    public String getPortalPathByRole(String path) {
        if (isAdmin()) {
           //System.out.println("Admin path is  : "+path);
           //LOG.log(Level.SEVERE,"admin path is  : /admin "+path);
            return "/admin" + path + FACES_REDIRECT;
        } else if (isUser()) {
            return "/user" + path + FACES_REDIRECT;
        } else {
            //System.out.println(path);
            return path + FACES_REDIRECT;
        }
    }    
    
    public String doLogin() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            LOG.log(Level.SEVERE,"UserName is :" +username +" and Password is :"+ password+"");
            req.login(username, password);
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, "There has been a problem invoking HttpServletRequest.login", ex);
            facesContext.addMessage(null, new FacesMessage("Bad Login", "Detail: You made a bad login!"));
            // return the user to the login page with an error message
            return "/login.xhtml";
        }

        // send user to welcome page
        return getPortalPathByRole("/welcome.xhtml");
    }

    public String doLogout() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, "There has been a problem invoking HttpServletRequest.logout", ex);
            facesContext.addMessage(null, new FacesMessage("Bad Logout", "Bad Logout"));
            // return the user to the login page with an error message
            return "/error.xhtml";
        }

        // return the user to the login page
        return "/index.xhtml";
    }
    
    
    
}
