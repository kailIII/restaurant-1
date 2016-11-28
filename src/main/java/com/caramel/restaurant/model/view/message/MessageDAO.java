package com.caramel.restaurant.model.view.message;

public interface MessageDAO {
	
	public String getMessageByTarget(String target);
	
	public void save(Message message);
	
	public void deleteMessageByTarget(String target);
}
