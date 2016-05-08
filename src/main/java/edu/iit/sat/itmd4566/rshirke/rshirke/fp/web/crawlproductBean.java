/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.web;

import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Product;
import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Website;
import edu.iit.sat.itmd4566.rshirke.rshirke.fp.service.ProductService;
import edu.iit.sat.itmd4566.rshirke.rshirke.fp.service.WebsiteService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Rohan
 */
@Named
@RequestScoped
public class crawlproductBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    @EJB
    private ProductService productservice;

    @EJB
    private WebsiteService websiteservice;

    public String executecrawler() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {

            ArrayList<String> PName = new ArrayList<String>();
            ArrayList<String> PPrice = new ArrayList<String>();
            ArrayList<String> PLink = new ArrayList<String>();

            Document doc;
            try {
                doc = Jsoup.connect("http://www.bestbuy.com/site/searchpage.jsp?cp=1&searchType=search&_dyncharset=UTF-8&id=pcat17071&type=page&ks=960&sc=Global&sp=&list=y&usc=All%20Categories&iht=n&seeAll=&st=unlock%20cell%20phones&qp=category_facet%3DUnlocked%20Cell%20Phones~pcmcat156400050037").get();
                // get page title
                String title = doc.title();
                System.out.println("title : " + title);

                Elements alltabs = doc.getElementsByClass("list-items");
                for (Element alltab : alltabs) {
                    Elements singlemobileclass = alltab.getElementsByClass("medium-item-price");
                    for (Element singlemobileclasse : singlemobileclass) {
                        System.out.println("The Price is " + singlemobileclasse.text());
                        String price = singlemobileclasse.text();
                        String new_price = price.substring(1);
                        System.out.println("The new price is "+ new_price);
                        PPrice.add(new_price);
                    }
                    Elements Names = alltab.getElementsByClass("sku-title");
                    for (Element name : Names) {
                        System.out.println("The Name is " + name.text());
                        PName.add(name.text());
                    }
                    Elements Links = alltab.getElementsByClass("sku-title");

                    for (Element link : Links) {
                        Elements eachlink = link.getElementsByTag("a");
                        System.out.println("The Link is :http://bestbuy.com" + eachlink.attr("href"));
                        String newlink = "http://bestbuy.com" + eachlink.attr("href");
                        PLink.add(newlink);
                    }
                }


                Website w1 = websiteservice.find(1);
                LOG.log(Level.SEVERE,"Website got retrieved !!!");
                LOG.log(Level.SEVERE,"Website  is" + w1.getSite_name());
                //System.out.println("Website got retrieved !!!");
                 //  System.out.println("Website name "+ w1.getSite_name());     
                for (int i = 0; i < PName.size(); i++) {
                    Product p1 = new Product(PName.get(i), "Mobile Description", PLink.get(i), Double.valueOf(PPrice.get(i)));
                    
                    w1.addWebsite(p1);
                    productservice.create(p1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //call the product service and find all the products 
            // returns list  product.findall string pass
        } catch (Exception ex) {

            // return the user to the login page with an error message
            return "/login.xhtml";
        }

        // send user to page main page where comparison will be made
        return "/mainpage.xhtml";
    }

}
