package com.caramel.restaurant.model.view.message;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


//this bean was created for long strings like page's content
@ManagedBean(eager = true)
@ApplicationScoped
public class MessageBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7807535320421353434L;
	
	private int Id;
	private String message;
	private String target;
	
	public String getMessageFromDB(String passedTarget){
		MessageDAO messageDAO = new MessageDAOImpl();
		return messageDAO.getMessageByTarget(passedTarget);
	}
	
	public void deleteMessageFromDB(String passedTarget){
		MessageDAO messageDAO = new MessageDAOImpl();
		messageDAO.deleteMessageByTarget(passedTarget);
	}
	
	public void saveMessage(Message passedMessage){
		MessageDAO messageDAO = new MessageDAOImpl();
		messageDAO.save(passedMessage);
	}
	
	//getters and setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
