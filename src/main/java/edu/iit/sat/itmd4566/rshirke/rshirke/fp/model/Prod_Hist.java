/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rohan
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(name = "Prod_Hist.findall", query = "SELECT ph FROM Prod_Hist ph"),
            @NamedQuery(name = "Prod_Hist.findbyId", query = "SELECT ph FROM Prod_Hist ph where ph.prod_hist_id=:prodhistid"),
            @NamedQuery(name = "Prod_Hist.deletebyId", query = "DELETE FROM Prod_Hist ph where ph.prod_hist_id=:prodhistid")
        }
)
public class Prod_Hist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prod_hist_id;

    @Column(nullable = false)
    private String product_url;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private String site_id;

    @Column(nullable = false)
    private double product_price;

    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * ****************************************************
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "product_id")
    private Product product1;

    public Prod_Hist() {
    }

    public Prod_Hist(String product_url, double product_price, Date date) {
        this.product_url = product_url;
        this.product_price = product_price;
        this.date = date;
    }

    /**
     * ******************************************************************************************
     */
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the prod_hist_id
     */
    public Long getProd_hist_id() {
        return prod_hist_id;
    }

    /**
     * @param prod_hist_id the prod_hist_id to set
     */
    public void setProd_hist_id(Long prod_hist_id) {
        this.prod_hist_id = prod_hist_id;
    }

    /**
     * @return the product_url
     */
    public String getProduct_url() {
        return product_url;
    }

    /**
     * @param product_url the product_url to set
     */
    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    /**
     * @return the product_price
     */
    public double getProduct_price() {
        return product_price;
    }

    /**
     * @param product_price the product_price to set
     */
    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    /**
     * @return the product1
     */
    public Product getProduct1() {
        return product1;
    }

    /**
     * @param product1 the product1 to set
     */
    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the site_id
     */
    public String getSite_id() {
        return site_id;
    }

    /**
     * @param site_id the site_id to set
     */
    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
            return "ProductHistory ID" + prod_hist_id + " URL :" + product_url + "Name :"+product_name + "SiteID"+site_id + "Price "+ product_price ;
    }

}
