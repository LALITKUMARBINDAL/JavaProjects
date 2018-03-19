package org.bindal.javabrains.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.bindal.javabrains.messanger.model.Message;
import org.bindal.javabrains.messanger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfile(){
		return profile;
	}
}
