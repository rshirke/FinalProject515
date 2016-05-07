/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4566.rshirke.rshirke.fp.service;


import edu.iit.sat.itmd4566.rshirke.rshirke.fp.model.security.Group;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author spyrisos
 */
@Stateless
public class GroupService extends AbstractService<Group>{

    public GroupService() {
        super(Group.class);
    }

    @Override
    public List<Group> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
