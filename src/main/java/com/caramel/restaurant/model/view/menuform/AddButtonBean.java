package com.caramel.restaurant.model.view.menuform;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.caramel.restaurant.model.view.foodscroller.Food;
import com.caramel.restaurant.model.view.foodscroller.FoodDAO;

@ViewScoped
@ManagedBean
public class AddButtonBean {
	
	private FoodDAO foodDao = new FoodDAO();
	
	private String name;
	private String desc;
	private String cat;
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void saveMenu(){
		foodDao.save(new Food(name, desc, cat));
		addMessage("success");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
}
