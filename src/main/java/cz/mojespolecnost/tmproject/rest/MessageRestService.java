package cz.mojespolecnost.tmproject.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {        

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}

}