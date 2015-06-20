/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.mojespolecnost.tmproject;

import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
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
        String resource = "cz/mojespolecnost/tmproject/myBatisTestingConfig.xml";
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
        User us1 = conn.getUserByID(1);
        assertEquals(1, (int) us1.getUserID());
        assertEquals("Tonik Chlupaty", us1.getName());
        
        us1 = conn.getUserByID(2);
        assertEquals(2, (int) us1.getUserID());
        assertEquals("Alzbeta Stara", us1.getName());
        
        us1 = conn.getUserByID(6);
        assertEquals(6, (int) us1.getUserID());
        assertEquals("Roman Cerny", us1.getName());        
        
        User notFound = conn.getUserByID(9); 
        assertEquals(-1, (int) notFound.getUserID());
        assertEquals("none", notFound.getName());     
        
        notFound = conn.getUserByID(-2); 
        assertEquals(-1, (int) notFound.getUserID());
        assertEquals("none", notFound.getName());           
    }
    
    @org.junit.Test
    public void testGetAllUsers() {
        List<? extends User> allUsers = conn.getAllUsers();
        //SPOCK to test all elements?
        assertEquals(6, allUsers.size());
        assertEquals(3, (int) allUsers.get(2).getUserID());        
    }    
    
}
