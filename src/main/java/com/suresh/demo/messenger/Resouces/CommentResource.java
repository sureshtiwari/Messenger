package com.suresh.demo.messenger.Resouces;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	@GET
	public String test()
	{
		return "test for commenst";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") String commentId, @PathParam("messageId") String messageId)
	{
		return commentId+ " " +messageId;
	}
}
