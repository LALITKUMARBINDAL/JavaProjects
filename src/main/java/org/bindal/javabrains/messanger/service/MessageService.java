package org.bindal.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.bindal.javabrains.messanger.database.DatabaseClass;
import org.bindal.javabrains.messanger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages =DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "HelloWorld!", "Lalit"));
		messages.put(2L, new Message(2, "Hello Jersey", "Kumar"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageforyear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)== year ) {
				messageforyear.add(message);
			}
		}
		return messageforyear;
	}
	
	
	public List <Message> getAllmessagesPaginated(int start, int size){
	
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		return list.subList(start, start+size);
	}
	
	
	
	
	public Message getMessage (long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMesssage(long id) {
		return messages.remove(id);
	}
}
