package com.caramel.restaurant.model.view.message;

public interface NumericMessageDAO {
	
	public void save(NumericMessage message);
		
	public int getMessageByTarget(String target);
		
	public boolean doExist(String target);
		
	public void deleteMessageByTarget(String target);
}
