package com.suresh.demo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.suresh.demo.messenger.database.DatabaseClass;
import com.suresh.demo.messenger.model.*;

public class MessageService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	
	public MessageService()
	{
		messages.put(1L, new Message(1,"Hello World","suresh"));
		messages.put(2L, new Message(2,"Hello you","suresh"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	
	public Message addMesage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Long id)
	{
		return messages.remove(id);
	}

}
