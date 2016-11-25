package com.caramel.restaurant.model.view.menuform;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.caramel.restaurant.model.view.foodscroller.FoodDAO;

@ViewScoped
@ManagedBean
public class DeleteButtonBean {
	
	private FoodDAO foodDao = new FoodDAO();
	
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
