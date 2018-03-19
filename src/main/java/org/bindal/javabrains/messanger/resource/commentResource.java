package org.bindal.javabrains.messanger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class commentResource {

	@GET
	public String test() {
		return "I am new Sub Resource";
	}
	
	@GET
	@Path("/{commentID}")
	public String test2(@PathParam ("messageID") long messageID, @PathParam ("commentID") long commentID) {
		return "I am MessgaeID: " + messageID + " I am CommentID: " +commentID;
	}
}
