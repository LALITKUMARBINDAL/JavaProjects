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
import javax.ws.rs.core.MediaType;

import org.bindal.javabrains.messanger.model.Profile;
import org.bindal.javabrains.messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileservice = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileservice.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return profileservice.addProfile(profile);
	}
	
	@GET
	@Path("/{ProfileName}")
	public Profile getProfile(@PathParam("ProfileName") String profilename) {
		return profileservice.getProfile(profilename);
	}
	
	@PUT
	@Path("/{ProfileName}")
	public Profile updateProfile(@PathParam("ProfileName") String profilename, Profile profile) {
	profile.setProfileName(profilename);
	return profileservice.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{ProfileName}")
	public void deleteProfile(@PathParam("ProfileName") String profilename) {
		profileservice.removeProfile(profilename);
	}
}
