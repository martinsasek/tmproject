/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject.persistence;

/**
 * Supposed user contract, but it seems, that UserDO POJO
 * is well suited for the job it is doing and this contract does not make much sense.
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
