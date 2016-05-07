/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.service;


import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.security.Group;
import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.security.User;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author spyrisos
 */
@Singleton
@Startup
public class DatabasePopulator {

    
    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;

   
    public DatabasePopulator() {
    }

    @PostConstruct
    private void seedDatabase() {

        
        Group userGroup = new Group("USER", "Users Group");
        Group adminGroup = new Group("ADMIN", "Administrative Group");
        
        
        User user = new User("user", "user");
        User admin = new User("admin", "admin");
        
        user.addGroup(userGroup);
        admin.addGroup(adminGroup);

      
        groupService.create(userGroup);
        groupService.create(adminGroup);

      
    
        userService.create(user);
        userService.create(admin);

        
    }
}
