package cz.mojespolecnost.tmproject.rest;

import cz.mojespolecnost.tmproject.persistence.MyBatisMySqlConnector;
import cz.mojespolecnost.tmproject.persistence.UserDO;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//http://localhost:8080/tmproject/rest/users
@Path("/users")
public class UserRestService {
    private static MyBatisMySqlConnector conn;
    private static final String TYPE = MediaType.APPLICATION_XML;
    
    static{
        try{                
            conn = new MyBatisMySqlConnector("cz/mojespolecnost/tmproject/persistence/myBatisTestingConfig.xml");
        } catch (IOException e){            
            conn = null;
            e.printStackTrace();
        }
    }
    
        
	@GET
	@Path("/{id}")
        @Produces(TYPE)
	public UserDO getUserById(@PathParam("id") int id) {        		
		return conn.getUserByID(id);
	}      
        
	@GET
	@Path("/numberOfUsers")
        @Produces(TYPE)
	public int getUserById() {        		
		return conn.getNumberOfUsers();
	}      
        
        
	@GET
        @Produces(TYPE)
	public List<UserDO> getAllUsers() {        		
		return conn.getAllUsers();
	}      
        
        
	@GET
	@Path("/dummyUser")
        @Produces(TYPE)
        public Response dummyUser() {        
                
                String result = "user : " + "dummy user";
		
		return Response.status(200).entity(result).build();
	}        

        
	@POST	
        @Consumes(TYPE)
        @Produces(TYPE)
	public UserDO createUser(UserDO user) {        		
		return conn.insertUser(user);
	}      
        
	@DELETE
	@Path("/{id}")
        @Produces(TYPE)
	public void removeUser(@PathParam("id") int id) {        		
		conn.deleteUser(id);
	}          
    
}