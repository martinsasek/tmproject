/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject;

/**
 *
 * @author indian
 */
public class User {
    private Integer userID;
    private String name;
    private String address;
    private Integer userGroupID;

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
