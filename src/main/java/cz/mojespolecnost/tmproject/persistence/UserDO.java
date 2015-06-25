/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject.persistence;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data object used to send user info through all the layers. 
 *  
 * @author indian
 */
@XmlRootElement
public class UserDO {
    private Integer userID;
    private String name;
    private String address;
    private Integer userGroupID;

    /**
     * Construct new UserDO so far for testing purposes.
     * userID is ommitted on purpose because it should be set by the database engine.
     * @param name
     * @param address
     * @param userGroupID 
     */
    public UserDO(String name, String address, Integer userGroupID) {        
        this.name = name;
        this.address = address;
        this.userGroupID = userGroupID;
    }
    
//    /**
//     * Transfers all info from User to UserDO, used to convert
//     * communication of MyBatisMySqlConnector in User interfaces
//     * to the communication with MySQL database in UserDO.
//     * 
//     * @param user 
//     */
//    public UserDO(User user){
//        if (user.getUserID() != null){
//            this.userID = new Integer(user.getUserID());
//        }        
//        this.name = new String(user.getName());
//        this.address = new String(user.getAddress());
//        this.userGroupID = new Integer(user.getUserGroupID());
//    }

    public UserDO() {
    }
    
    
    
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", name=" + name + ", address=" + address + ", userGroupID=" + userGroupID + '}';
    }
    
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Integer getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(Integer userGroupID) {
        this.userGroupID = userGroupID;
    }
    
    
    
}
