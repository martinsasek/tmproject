/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mojespolecnost.tmproject.rest;

import cz.mojespolecnost.tmproject.application.MessageApplication;
import cz.mojespolecnost.tmproject.utils.RemoteUtil;
import java.io.IOException;
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
 *
 * @author indian
 */
public class MessageRestServiceTest {
    
    private static int port;    
    private static String rootUri = "http://localhost:8080/tmproject/rest/";
    private static TJWSEmbeddedJaxrsServer server;
    
    public MessageRestServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException{
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
    public void testGetUserByID() throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response response = client.target(rootUri+"message/user/1").request().get();
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
    
}
