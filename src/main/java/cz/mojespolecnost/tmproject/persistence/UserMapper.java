/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject.persistence;

import java.util.List;

/**
 *
 * @author indian
 */
public interface UserMapper {
       
    public UserDO selectUser(int id);
    
    
    public List <UserDO> getAllUsers();
    
    public void insertUser(UserDO user);
    
    public void deleteUser(int id);
    
    public void updateUser(UserDO user);
    
}
