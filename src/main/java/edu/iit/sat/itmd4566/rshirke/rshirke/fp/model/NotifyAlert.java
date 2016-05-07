/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rohan
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(name = "NotifyAlert.findall", query = "SELECT n FROM NotifyAlert n"),
            @NamedQuery(name = "NotifyAlert.findbyId", query = "SELECT n FROM NotifyAlert n where n.alert_id=:alertid"),
            @NamedQuery(name = "NotifyAlert.deletebyId", query = "DELETE FROM NotifyAlert n where n.alert_id=:alertid")
//            @NamedQuery(name = "NotifyAlert.findbyName",query= "SELECT n FROM NotifyAlert n where n.alert_id:sitename")

        }
)
public class NotifyAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alert_id;

    private String email_id;
    private double current_price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "product_id")
    private Product product3;

    public NotifyAlert() {
    }

    public NotifyAlert(String email_id, double current_price) {
        this.email_id = email_id;
        this.current_price = current_price;
    }

    /**
     * @return the alert_id
     */
    public Long getAlert_id() {
        return alert_id;
    }

    /**
     * @param alert_id the alert_id to set
     */
    public void setAlert_id(Long alert_id) {
        this.alert_id = alert_id;
    }

    /**
     * @return the email_id
     */
    public String getEmail_id() {
        return email_id;
    }

    /**
     * @param email_id the email_id to set
     */
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    /**
     * @return the current_price
     */
    public double getCurrent_price() {
        return current_price;
    }

    /**
     * @param current_price the current_price to set
     */
    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    /**
     * @return the product3
     */
    public Product getProduct3() {
        return product3;
    }

    /**
     * @param product3 the product3 to set
     */
    public void setProduct3(Product product3) {
        this.product3 = product3;
    }

    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
            return "NotifyAlert ID:" +alert_id + " Email ID:" + email_id + " CurrentPrice :" +current_price +" Product ID:" +product3.getProduct_id();
    }

}
