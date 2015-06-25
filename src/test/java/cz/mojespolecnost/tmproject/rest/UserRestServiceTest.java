/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mojespolecnost.tmproject.rest;

import cz.mojespolecnost.tmproject.persistence.UserDO;
import java.io.IOException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the rest service against live deplyment on e.g. Glassfish server.
 * Tried to use TJWS but did not succeed so far.
 * 
 * Worked in a way that I skipped tests using pom.xml and then allowed tests
 * in pom.xml and run unit tests. It is a very ugly way to do, but there were to
 * many other things to learn so far. It still made sense because it allowed 
 * me to test service before I started to create frontend.
 * 
 * Preffered way would be to use TJWS and maybe also a dummy simple test service, 
 * that even does not use database.
 * 
 * @author indian
 */
public class UserRestServiceTest {
    
    private static int port;    
    private static String rootUri = "http://localhost:8080/tmproject/rest/";
    private static TJWSEmbeddedJaxrsServer server;
    
    public UserRestServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException{

//        Tried to set Tiny Java WebServer for testig bu so far did not suceed  
//        port = RemoteUtil.findFreePort();
//        server = new TJWSEmbeddedJaxrsServer();
//        server.setPort(port);
//        server.start();
//        server.getDeployment().getRegistry().addSingletonResource(new MessageRestService());
//        //server.getDeployment().getProviderClasses().add("cz.mojespolecnost.tmproject.rest.MessageRestService");
//        rootUri  = "http://localhost:"+port+"/tmproject/rest/";
//        System.out.println("Providers");
//        System.out.println(server.getDeployment().getProviders());
//        System.out.println("Resources");
//        System.out.println(server.getDeployment().getResources());
//        System.out.println("ResourceClass");
//        System.out.println(server.getDeployment().getResourceClasses());        
    }
    
    @AfterClass
    public static void tearDownClass() {
        if (server != null) server.stop();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetUserById() throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response response = client.target(rootUri+"users/1").request().get();
//        UserDO user = (UserDO) response.getEntity();
//        System.out.println(response.toString());
        String user = response.readEntity(String.class);
//        System.err.println(user);
//        System.out.println(user);
//        response = client.target(rootUri).request().get();
//        user = response.readEntity(String.class);
//        System.err.println(user);
//        System.out.println(user);        
        assertTrue(user.contains("Tonik"));        
        
    }   
    
    @Test
    public void testCreateRemoveUser() throws Exception{
        UserDO newUser = new UserDO("Tempik", "Tempikova", 3);        
        ResteasyClient client = new ResteasyClientBuilder().build();
        
        Response response = client.target(rootUri+"users").request()
                .post(Entity.xml(newUser)); 
        UserDO user = response.readEntity(UserDO.class);
        assertTrue (user != null);
        assertEquals(user.getName(), "Tempik");
        assertTrue(user.getUserID() > 6);      
        
        response = client.target(rootUri+"users/"+user.getUserID()).request().delete();
        System.out.println("delete worked "+response.getStatusInfo());
        assertEquals(204, response.getStatus());                
        
        
        
    }       
    
    @Test
    public void testGetAllUsers() throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response response = client.target(rootUri+"users").request().get();
        String allUsers = response.readEntity(String.class);
        assertTrue(allUsers.contains("Tonik"));
        assertTrue(allUsers.contains("Roman"));
    }    
    
/**    Does not work right now - two test classes (MyBatisMySQLConnectorTest as well) 
 *   are acessing  database in paralel - number of users is not guaranteed.
 */   
//    @Test
//    public void testGetNumberOfUsers() throws Exception{
//        ResteasyClient client = new ResteasyClientBuilder().build();
//        Response response = client.target(rootUri+"users/numberOfUsers").request().get();
//        String userCount = response.readEntity(String.class);
//        assertEquals("6", userCount);        
//    }      
    
}
