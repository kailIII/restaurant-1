package com.caramel.restaurant.model.view.foodscroller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(eager=true)
@ApplicationScoped
public class DataScrollerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6783843624445469414L;
	
	private FoodDAO dao = new FoodDAOImpl();
    

	//define list with obcject creation and store it 
	//to reduce number of connections to DB
	private List<Food> main;
	private List<Food> deserts;
	private List<Food> beverages;
    
    @PostConstruct
    public void init(){
    	main = dao.getMessageByCategory("main");
    	deserts = dao.getMessageByCategory("deserts");
    	beverages = dao.getMessageByCategory("beverages");
    }
    
    public void refresh(){
    	main = dao.getMessageByCategory("main");
    	deserts = dao.getMessageByCategory("deserts");
    	beverages = dao.getMessageByCategory("beverages");
    	addMessage("success");
    }
    
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	
	//getters and setters
	public List<Food> getMain() {
		return main;
	}

	public void setMain(List<Food> main) {
		this.main = main;
	}

	public List<Food> getDeserts() {
		return deserts;
	}

	public void setDesert(List<Food> deserts) {
		this.deserts = deserts;
	}

	public List<Food> getBeverages() {
		return beverages;
	}

	public void setBeverages(List<Food> beverages) {
		this.beverages = beverages;
	}
	
}
