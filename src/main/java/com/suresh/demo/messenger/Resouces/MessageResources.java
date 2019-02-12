package com.suresh.demo.messenger.Resouces;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.suresh.demo.messenger.model.Message;
import com.suresh.demo.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService messageservice = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filter) {
		if (filter.getStart() > 0 && filter.getSize() > 0)
			return messageservice.getAllMessagesPaginated(filter.getStart(), filter.getSize());
		if (filter.getYear() > 0)
			return messageservice.getAllMessagesPerYear(filter.getYear());
		return messageservice.getAllMessages();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageservice.updateMessage(message);
	}

	@POST
	public Message addMessage(Message message) {
		return messageservice.addMesage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageservice.removeMessage(id);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId) {
		return messageservice.getMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}

}
