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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "query_hist")
@NamedQueries(
        {
            @NamedQuery(name = "Query_History.findall", query = "SELECT qh FROM Query_History qh"),
            @NamedQuery(name = "Query_History.findbyId", query = "SELECT qh FROM Query_History qh where qh.Q_id=:qid"),
            @NamedQuery(name = "Query_History.deletebyId", query = "DELETE FROM Query_History qh where qh.Q_id=:qid")
//            @NamedQuery(name = "Query_History.findbyName",query= "SELECT n FROM Query_History n where qh.Q_id:qid")

        }
)
public class Query_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Q_id;
    private String Query;

    private String status;
    private String UserID;
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "queryhistory", cascade = CascadeType.ALL)

    private List<Clicked_History> click_hist = new ArrayList<Clicked_History>();

    public Query_History(String Query, String status, String UserID, Date date) {
        this.Query = Query;
        this.status = status;
        this.UserID = UserID;
        this.date = date;
    }

    public Query_History() {
    }

    public void addclickhistory(Clicked_History clickhist) {
        if (!click_hist.contains(clickhist)) {
            click_hist.add(clickhist);
        }
        clickhist.setQueryhistory(this);
    }

    /**
     * @return the Q_id
     */
    public Long getQ_id() {
        return Q_id;
    }

    /**
     * @param Q_id the Q_id to set
     */
    public void setQ_id(Long Q_id) {
        this.Q_id = Q_id;
    }

    /**
     * @return the Query
     */
    public String getQuery() {
        return Query;
    }

    /**
     * @param Query the Query to set
     */
    public void setQuery(String Query) {
        this.Query = Query;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

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

    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
            return "QueryHistory ID:"+ Q_id +" Query:"+ Query+ " Status:" +status +"User:"+UserID;
    }
 
}
