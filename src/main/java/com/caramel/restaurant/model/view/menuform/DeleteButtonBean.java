package com.caramel.restaurant.model.view.menuform;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.caramel.restaurant.model.view.foodscroller.FoodDAO;
import com.caramel.restaurant.model.view.foodscroller.FoodDAOImpl;

@ManagedBean
@SessionScoped
public class DeleteButtonBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7199795023014449419L;

	private FoodDAO foodDao = new FoodDAOImpl();
	
	private int index;
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void deleteMenuByIndex(){
		foodDao.deleteMessageById(index);
		addMessage("success");
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
