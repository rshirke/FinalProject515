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
@Table(name = "click_hist")
@NamedQueries(
        {
            @NamedQuery(name = "Clicked_History.findall", query = "SELECT ch FROM Clicked_History ch"),
            @NamedQuery(name = "Clicked_History.findbyId", query = "SELECT ch FROM Clicked_History ch where ch.click_id=:clickid"),
            @NamedQuery(name = "Clicked_History.deletebyId", query = "DELETE FROM Clicked_History ch where ch.click_id=:clickid")
//            @NamedQuery(name = "Query_History.findbyName",query= "SELECT n FROM Query_History n where qh.Q_id:qid")

        }
)
public class Clicked_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long click_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "site_id")
    private Website website2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "Q_id")
    private Query_History queryhistory;

    public Clicked_History() {
    }

    /**
     * @return the click_id
     */
    public Long getClick_id() {
        return click_id;
    }

    /**
     * @param click_id the click_id to set
     */
    public void setClick_id(Long click_id) {
        this.click_id = click_id;
    }

    /**
     * @return the website2
     */
    public Website getWebsite2() {
        return website2;
    }

    /**
     * @param website2 the website2 to set
     */
    public void setWebsite2(Website website2) {
        this.website2 = website2;
    }

    /**
     * @return the queryhistory
     */
    public Query_History getQueryhistory() {
        return queryhistory;
    }

    /**
     * @param queryhistory the queryhistory to set
     */
    public void setQueryhistory(Query_History queryhistory) {
        this.queryhistory = queryhistory;
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "ClickedHistory ID:" + click_id + " Website ID : " + website2.getSite_id() + " QueryID : " + queryhistory.getQ_id();
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
