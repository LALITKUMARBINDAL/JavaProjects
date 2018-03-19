package org.bindal.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bindal.javabrains.messanger.database.DatabaseClass;
import org.bindal.javabrains.messanger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfile();

	
	public ProfileService() {
		profiles.put("LalitKumar", new Profile(1L,"LalitKumar", "Lalit", "Kumar"));
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String ProfileName) {
		return profiles.get(ProfileName);
	}
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;			
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
