package com.caramel.restaurant.model.view.message;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@ViewScoped
public class EditorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1611198153407147973L;
	
	private static Logger log = LogManager.getLogger(EditorBean.class.getName());
	
	private String target;
	private String text;
	
	//delete message with equal target and save passed
	public void save(){
		log.debug("saving text from editor to db");
		
		//simple validation
		if(target == null || target == ""){
			log.warn("no target data, operation interrupted");
			return;
		}
		
		Message message = new Message();
		message.setMessage(text);
		message.setTarget(target);
		
		MessageDAO messageDAO = new MessageDAOImpl();
		messageDAO.deleteMessageByTarget(message.getTarget());
		messageDAO.save(message);
		
		addMessage("Message was saved");
	}
	
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	//getters and setters
	public String getText() {
		log.debug("sending text to client editor");		
		
		MessageDAOImpl messageDAO = new MessageDAOImpl();
		text = messageDAO.getMessageByTarget(target);
		return text;
	}
	
	public void setText(String text) {
		log.debug("save text to bean: " + text);
		this.text = text;
	}

	public String getTarget() {
		log.debug("getting target from editor: " + target);
		return target;
	}

	public void setTarget(String target) {
		log.debug("saving target to editor: " + target);
		this.target = target;
	}
}
