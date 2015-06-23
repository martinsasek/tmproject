/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mojespolecnost.tmproject.rest;

import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author indian
 */
public class MessageRestServiceTest {
    
    static final String ROOT_URL = "http://localhost:8080/tmproject/rest/";
    public MessageRestServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    
    @Test
    public void testGetUserByID() throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response response = client.target(ROOT_URL+"message/user/1").request().get();
//        UserDO user = (UserDO) response.getEntity();
        String user = response.readEntity(String.class);
//        System.err.println(user);
//        System.out.println(user);
        assertTrue(user.contains("Tonik"));        
        
    }    
    
}
