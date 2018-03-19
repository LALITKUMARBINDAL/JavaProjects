package org.bindal.javabrains.messanger.resource;

import java.util.List;

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

import org.bindal.javabrains.messanger.model.Message;
import org.bindal.javabrains.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class messageResource {

	MessageService msgservice  = new MessageService();
	
	@GET
	public List <Message> getMessages(@QueryParam("year") int year,
									  @QueryParam("Start") int start,
									  @QueryParam("size") int size) {
		if(year > 0) {
			return msgservice.getAllMessagesForYear(year);
		}
		if(start>0 && size>=0) {
			return msgservice.getAllmessagesPaginated(start, size);
		}
		return msgservice.getAllMessages();
	}
	
	@POST
	
	public Message addMessage(Message message) {
	
	return msgservice.addMessage(message);
	}
	
	@DELETE
	public void deleteMessage(@PathParam("messageID") long id) {
		msgservice.removeMesssage(id);
	}
	
	@PUT
	@Path("/{messageID}")
	public Message UpdateMessage(@PathParam("messageID") long id, Message message) {
		message.setId(id);
		return msgservice.updateMessage(message);
	}
	
	@GET
	@Path("/{messageID}")
	public Message gerMessage(@PathParam("messageID") long id) {
		return msgservice.getMessage(id);
	}
	
	@Path("/{messageID}/comments")
		public commentResource getcommentResource() {
			return new commentResource();
		}
}
