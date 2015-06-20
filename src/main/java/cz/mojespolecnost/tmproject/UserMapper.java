/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject;

import org.apache.ibatis.annotations.Select;

/**
 *
 * @author indian
 */
public interface UserMapper {
    
    //@Select("SELECT * FROM User WHERE userID = #{id}")
    UserDO selectUser(int id);
    
}
