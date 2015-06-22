/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject.persistence;

/**
 * Null implementation of User interface.
 * @author indian
 */
public class UserNull extends UserDO{

    private static final UserNull instance = new UserNull();
    
    private UserNull (){
        
    }
    
    public String getAddress() {
        return "none";
    }

    public String getName() {
        return "none";
    }

    public Integer getUserGroupID() {
        return -1;
    }

    public Integer getUserID() {
        return -1;
    }

    @Override
    public String toString() {
        return "no user found";
    }
    
    public static UserNull getUserNull(){
        return instance;
    }
    
}
