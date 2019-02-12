package com.suresh.demo.messenger.Resouces;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/InjectDemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemo {

	@GET
	@Path("/anotations")
	public String getParamsUsingAnotations(@MatrixParam("param") String param,
			@HeaderParam("customparam") String customparam,@CookieParam("cookieparam") String cookieparam) {

		return param + customparam+cookieparam;
	}
	
	@GET
	@Path("/context")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpheaders)
	{
		return  uriInfo.getAbsolutePath().toString();
		
	}
}
