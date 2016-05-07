/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rohan
 */
@Entity
@Table(name = "website")
@NamedQueries(
        {
            @NamedQuery(name = "Website.findall", query = "SELECT w FROM Website w"),
            @NamedQuery(name = "Website.findbyId", query = "SELECT w FROM Website w where w.site_id=:siteid"),
            @NamedQuery(name = "Website.deletebyId", query = "DELETE FROM Website w where w.site_id=:siteid")
//            @NamedQuery(name = "Website.findbyName",query= "SELECT w FROM Website w where w.site_name:sitename")

        }
)
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long site_id;
    private String site_name;
    @Column(nullable = false)
    private String site_url;

    private String site_desc;

    //*************************************************************************************
    @OneToMany(mappedBy = "website", cascade = CascadeType.ALL)

    private List<Product> products = new ArrayList<Product>();

    public void addWebsite(Product product) {
        if (!products.contains(product)) {
            products.add(product);
        }
        product.setWebsite(this);
    }

    //*************************************************************************
    @OneToMany(mappedBy = "website2", cascade = CascadeType.ALL)

    private List<Clicked_History> click_hist = new ArrayList<Clicked_History>();

    public void addclickhistory(Clicked_History clickhist) {
        if (!click_hist.contains(clickhist)) {
            click_hist.add(clickhist);
        }
        clickhist.setWebsite2(this);
    }

    public Website(String site_name, String site_url, String site_desc) {
        this.site_name = site_name;
        this.site_url = site_url;
        this.site_desc = site_desc;
    }

    public Website() {
    }

    /**
     * @return the site_id
     */
    public Long getSite_id() {
        return site_id;
    }

    /**
     * @param site_id the site_id to set
     */
    public void setSite_id(Long site_id) {
        this.site_id = site_id;
    }

    /**
     * @return the site_name
     */
    public String getSite_name() {
        return site_name;
    }

    /**
     * @param site_name the site_name to set
     */
    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public String getSite_desc() {
        return site_desc;
    }

    public void setSite_desc(String site_desc) {
        this.site_desc = site_desc;
    }

    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "Site ID:" + site_id + " Name:" + site_name + " URL:" + site_url + " Desc: " + site_desc;
    }
    /**
     * @return the product
     */
    /**
     * @return the prod_hist
     */
//    public Prod_Hist getProd_hist() {
//        return prod_hist1;
//    }
//
//    /**
//     * @param prod_hist the prod_hist to set
//     */
//    public void setProd_hist(Prod_Hist prod_hist) {
//        this.prod_hist1 = prod_hist;
//    }
//    /**
//     * @return the click_hist
//     */
//    public Clicked_History getClick_hist() {
//        return click_hist;
//    }
//
//    /**
//     * @param click_hist the click_hist to set
//     */
//    public void setClick_hist(Clicked_History click_hist) {
//        this.click_hist = click_hist;
//    }
//     public List<Website> getWebsites() {
//        return websites;
//    }
//
//    /**
//     * @param websites the websites to set
//     */
//    public void setWebsites(List<Website> websites) {
//        this.websites = websites;
//    }
}
