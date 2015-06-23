package cz.mojespolecnost.tmproject.rest;

import cz.mojespolecnost.tmproject.persistence.MyBatisMySqlConnector;
import cz.mojespolecnost.tmproject.persistence.UserDO;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
@Path("/message")
public class MessageRestService {
    private static MyBatisMySqlConnector conn;
    
    static{
        try{                
            conn = new MyBatisMySqlConnector("cz/mojespolecnost/tmproject/persistence/myBatisTestingConfig.xml");
        } catch (IOException e){            
            conn = null;
            e.printStackTrace();
        }
    }
    
    

//	@GET
//	@Path("/{param}")
//	public Response printMessage(@PathParam("param") String msg) {        
//
//		String result = "Restful example : " + msg;
//
//		return Response.status(200).entity(result).build();
//
//	}
    
    
//	@GET
//	@Path("/firstUser")
////        @Produces(MediaType.APPLICATION_JSON)
//	public Response printMessage() {        
//                
//                String result = "user : " + conn.getUserByID(1).getName();
//		
//		return Response.status(200).entity(result).build();
//
//	}
        
	@GET
	@Path("/user/{id}")
        @Produces(MediaType.APPLICATION_JSON)
	public UserDO printMessage(@PathParam("id") int id) {        
		
		return conn.getUserByID(id);

	}      
        
	@GET
	@Path("/secondUser")
        public Response printSecondMessage() {        
                
                String result = "user : " + conn.getUserByID(1).getName();
		
		return Response.status(200).entity(result).build();

	}        

    
}