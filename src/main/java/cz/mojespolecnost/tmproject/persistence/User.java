/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject.persistence;

/**
 * @author indian
 */
public interface User {

    String getAddress();

    String getName();

    Integer getUserGroupID();

    Integer getUserID();

    @Override
    String toString();
    
}
