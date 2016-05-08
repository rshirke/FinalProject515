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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rohan
 */
@Entity
@Table(name = "product")
@NamedQueries(
        {
            @NamedQuery(name = "Product.findall", query = "Select p from Product p"),
            @NamedQuery(name = "Product.findbyId", query = "Select p from Product p where p.product_id =:productid"),
            @NamedQuery(name = "Product.delete", query = "Delete from Product as p"),
            @NamedQuery(name = "Product.findByname", query = "Select p from Product p where p.product_name =:productname")    
        }
)

public class Product {

    // @NamedQuery(name = "Product.findbyName",query= "SELECT p FROM Product p where p.product_name=:productname"),
    // @NamedQuery(name = "Product.findbyPrice",query= "SELECT p FROM Product p where p.product_price=:productprice")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    @Column(nullable = false)
    private String product_name;
    private String product_desc;
    @Column(nullable = false)
    private String product_url;
    private double product_price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "site_id")
    private Website website;

    //one to many 
    @OneToMany(mappedBy = "product1", cascade = CascadeType.ALL)

    private List<Prod_Hist> products1 = new ArrayList<Prod_Hist>();

    public void addProduct(Prod_Hist product) {
        if (!products1.contains(product)) {
            products1.add(product);
        }
        product.setProduct1(this);
    }

    @OneToMany(mappedBy = "product3", cascade = CascadeType.ALL)

    private List<NotifyAlert> notifyalert = new ArrayList<NotifyAlert>();

    public void addProductnotify(NotifyAlert product) {
        if (!notifyalert.contains(product)) {
            notifyalert.add(product);
        }
        product.setProduct3(this);
    }

    public Product(String product_name, String product_desc, String product_url, double product_price) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_url = product_url;
        this.product_price = product_price;

    }

    public Product() {
    }

    /**
     * @return the product_id
     */
    public Long getProduct_id() {
        return product_id;
    }

    /**
     * @param product_id the product_id to set
     */
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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
     * @return the product_desc
     */
    public String getProduct_desc() {
        return product_desc;
    }

    /**
     * @param product_desc the product_desc to set
     */
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
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
     * @return the website
     */
    public Website getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(Website website) {
        this.website = website;
    }

    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "Product ID :" + product_id + " ProductName:" + product_name + "Product Desc:" + product_desc + "Product URL:" + product_url + " Price:" + product_price + " siteID:" + website.getSite_id();
    }

}
