/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.web;

import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.Website;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
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
public class crawlproductBean extends AbstractJSFBean{
    
    
    
    
    public String executecrawler() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
           
             ArrayList PName = new ArrayList();
             ArrayList PPrice = new ArrayList();
             ArrayList PLink = new ArrayList();
            
             
            
            Document doc;
	try {
		doc = Jsoup.connect("http://www.bestbuy.com/site/searchpage.jsp?cp=1&searchType=search&_dyncharset=UTF-8&id=pcat17071&type=page&ks=960&sc=Global&sp=&list=y&usc=All%20Categories&iht=n&seeAll=&st=unlock%20cell%20phones&qp=category_facet%3DUnlocked%20Cell%20Phones~pcmcat156400050037").get();
		// get page title
		String title = doc.title();
		System.out.println("title : " + title);

                Elements alltabs = doc.getElementsByClass("list-items");         
                for( Element alltab :alltabs)
                {
                   Elements singlemobileclass = alltab.getElementsByClass("medium-item-price");
                   for(Element singlemobileclasse : singlemobileclass)
                   {
                   System.out.println("The Price is "+singlemobileclasse.text());
                        PPrice.add(singlemobileclasse.text());
                   }
                   Elements Names = alltab.getElementsByClass("sku-title");
                   for(Element name : Names)
                   {
                   System.out.println("The Name is "+name.text());
                   PName.add(name.text());
                   }           
                   Elements Links = alltab.getElementsByClass("sku-title");
                   
                   for(Element link : Links)
                   {
                       Elements eachlink = link.getElementsByTag("a");
                   System.out.println("The Link is :http://bestbuy.com"+eachlink.attr("href"));
                   String newlink = "http://bestbuy.com" + eachlink.attr("href");
                   PLink.add(newlink);
                   }                  
                 }
                
                Website w7 = new Website("BestBuy.com", "www.bestbuy.com", "Best Online website in the USA for Electronics");
                
           for (int i = 0; i < PName.size(); i++) {
//			System.out.println(PName.get(i));

		}
                
                
//                Elements isactivelinks = doc.getElementsByClass("results-pagination");                
//                for(Element isactive : isactivelinks)
//                {
//                     Elements actlink = isactive.getElementsByTag("a");
//                     for(Element finalatag : actlink)
//                     {
//                         String linkclick = "http://bestbuy.com"+finalatag.attr("href");
//                         System.out.println("The Link is :http://bestbuy.com"+finalatag.attr("href"));
//                         if(finalatag.attr("disabled").contains("disabled"))
//                         {
//                             System.out.println("Disabled function is enabled");
//                             break;
//                         }
//                         else
//                         {
//    final WebClient webClient = new WebClient(); 
//    final HtmlPage page1 = (HtmlPage)webClient.getPage("www.bestbuy.com");
//    page1.getAnchorByHref(linkclick).click();                        
//                         }
//                     }
//                }

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
