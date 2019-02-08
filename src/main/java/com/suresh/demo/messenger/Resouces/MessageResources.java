package com.suresh.demo.messenger.Resouces;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suresh.demo.messenger.model.Message;
import com.suresh.demo.messenger.service.MessageService;

@Path("/messages")
public class MessageResources {
	
	MessageService messageservice = new MessageService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages()
	{
		return messageservice.getAllMessages();
	}

}
