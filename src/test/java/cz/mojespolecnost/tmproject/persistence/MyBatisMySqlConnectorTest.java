/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject.persistence;

import cz.mojespolecnost.tmproject.persistence.UserDO;
import cz.mojespolecnost.tmproject.persistence.MyBatisMySqlConnector;
import cz.mojespolecnost.tmproject.persistence.User;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 * Tests are directly acessing database, so this should be configured to
 * access a given testing database that is provided in 
 * "testingDB/topomonksTesting.sql".
 * @author indian
 */
public class MyBatisMySqlConnectorTest {
    
    private static MyBatisMySqlConnector conn;
    
    public MyBatisMySqlConnectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException{
//        File config = new File("/home/indian/java/tmproject/src/main/resources/cz/mojespolecnost/tmproject/myBatisTestingConfig.xml");
//        assertTrue(config.exists());
        String resource = "cz/mojespolecnost/tmproject/persistence/myBatisTestingConfig.xml";
        conn = new MyBatisMySqlConnector(resource);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testGetUser() {
        UserDO us1 = conn.getUserByID(1);
        assertEquals(1, (int) us1.getUserID());
        assertEquals("Tonik Chlupaty", us1.getName());
        
        us1 = conn.getUserByID(2);
        assertEquals(2, (int) us1.getUserID());
        assertEquals("Alzbeta Stara", us1.getName());
        
        us1 = conn.getUserByID(6);
        assertEquals(6, (int) us1.getUserID());
        assertEquals("Roman Cerny", us1.getName());        
        
        UserDO notFound = conn.getUserByID(9); 
        assertEquals(-1, (int) notFound.getUserID());
        assertEquals("none", notFound.getName());     
        
        notFound = conn.getUserByID(-2); 
        assertEquals(-1, (int) notFound.getUserID());
        assertEquals("none", notFound.getName());           
    }
    
    @org.junit.Test
    public void testGetAllUsers() {
        List<UserDO> allUsers = conn.getAllUsers();
        //SPOCK to test all elements?
        assertEquals(3, (int) allUsers.get(2).getUserID());        
    }    
    
    @org.junit.Test
    public void testInsertUpdateDelete(){
        // testing insert
        UserDO inserted =  new UserDO ("Karel Hlavnicka", "Rostacka 18", 3);                        
        assertTrue(inserted.getUserID() == null);        
        inserted = conn.insertUser(inserted);
        assertTrue(inserted.getUserID() != null);        
//        assertEquals(7, conn.getAllUsers().size());
        UserDO temporary = conn.getUserByID(inserted.getUserID());
        assertEquals(temporary.getUserID(), inserted.getUserID());
        assertEquals(temporary.getName(), inserted.getName());
        assertEquals(temporary.getAddress(), inserted.getAddress());
        assertEquals(temporary.getUserGroupID(), inserted.getUserGroupID());
        
        //testing update on the temporary inserted object
        UserDO updated = new UserDO("Karel Kulatoucky", "Rostacka 18", 4);
        updated.setUserID(temporary.getUserID());
        conn.updateUser(updated);
        //using old ID byt the data should be new
        UserDO tempUpdated = conn.getUserByID(temporary.getUserID());
        assertEquals(tempUpdated.getUserID(), temporary.getUserID());
        assertEquals(tempUpdated.getName(), updated.getName());        
        
        //testing delete of the temporary object
        conn.deleteUser(temporary.getUserID());
//        assertEquals(6, conn.getAllUsers().size());
    }
    
}
