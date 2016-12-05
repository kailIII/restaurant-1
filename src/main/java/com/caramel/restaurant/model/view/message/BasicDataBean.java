package com.caramel.restaurant.model.view.message;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//this bean was created for short data like email or phone number.
@ManagedBean
@ApplicationScoped
public class BasicDataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1616751649739679266L;
	private static Logger log = LogManager.getLogger(BasicDataBean.class.getName());
	private static MessageDAO dao = new MessageDAOImpl();
	private static NumericMessageDAO numDAO = new NumericMessageDAOImpl();
	
	private int tablesFor2;
	private int tablesFor6;
	
	private String openTime;
	private String closeTime;
	private String logoUrl;
	private String phone;
	private String address;
	private String email;
	private String restaurantName;
	private String footerInfo;
	private String title;
	private String description;
	
	
	@PostConstruct
	public void init(){
		setLogoUrl(dao.getMessageByTarget("logoUrl"));
		setPhone(dao.getMessageByTarget("phone"));
		setAddress(dao.getMessageByTarget("address"));
		setEmail(dao.getMessageByTarget("email"));
		setRestaurantName(dao.getMessageByTarget("restaurantName"));
		setFooterInfo(dao.getMessageByTarget("footerInfo"));
		setTitle(dao.getMessageByTarget("title"));
		setDescription(dao.getMessageByTarget("description"));

		setOpenTime(dao.getMessageByTarget("openTime"));
		setCloseTime(dao.getMessageByTarget("closeTime"));
		
		setTablesFor2(numDAO.getMessageByTarget("tablesFor2"));
		setTablesFor6(numDAO.getMessageByTarget("tablesFor6"));
	}
	
	public void sendPFSuccessMessage(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Value was saved ", null));
	}
	
	public void saveTitle(){
		log.info("saving message with target: " + title);
		
		Message message = new Message("title", title);
		
		dao.deleteMessageByTarget("title");
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveDesc(){
		log.info("saving message with target: " + description);
		
		Message message = new Message("description", description);
		
		dao.deleteMessageByTarget("description");
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveTF2(){
		log.info("saving message with target: " + tablesFor2);
		
		NumericMessage message = new NumericMessage("tablesFor2", tablesFor2);
		
		numDAO.deleteMessageByTarget("tablesFor2");
		numDAO.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveTF6(){
		log.info("saving message with target: " + tablesFor6);
		NumericMessage message = new NumericMessage("tablesFor6", tablesFor6);
		
		numDAO.deleteMessageByTarget("tablesFor6");
		numDAO.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveOpenTime(){
		log.info("saving message with target: " + openTime);
		try {
			if(Integer.parseInt(openTime) < 24 && Integer.parseInt(openTime) >= 0){
				Message message = new Message("openTime", openTime);
		
				dao.deleteMessageByTarget(message.getTarget());
				dao.save(message);
				sendPFSuccessMessage();
			}
		}catch (Exception e) {
			log.warn("conversion to int failed");
		}
	}
	
	public void saveCloseTime(){
	try {
		if(Integer.parseInt(closeTime) < 24 && Integer.parseInt(closeTime) >= 0){
			log.info("saving message with target: " + closeTime);
		
			Message message = new Message("closeTime", closeTime);
		
			dao.deleteMessageByTarget(message.getTarget());
			dao.save(message);
			sendPFSuccessMessage();
			}
		}catch (Exception e) {
			log.warn("conversion to int failed");
		}
	}
	
	public void saveLogoUrl(){
		log.info("saving message with target: " + logoUrl);
		
		Message message = new Message("logoUrl", logoUrl);
		
		dao.deleteMessageByTarget(message.getTarget());
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void savePhone(){
		log.info("saving message with target: " + phone);
		
		Message message = new Message("phone", phone);
		
		dao.deleteMessageByTarget(message.getTarget());
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveEmail(){
		log.info("saving message with target: " + email);
		
		Message message = new Message("email", email);
		
		dao.deleteMessageByTarget(message.getTarget());
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveRestaurantName(){
		log.info("saving message with target: " + restaurantName);
		
		Message message = new Message("restaurantName", restaurantName);
		
		dao.deleteMessageByTarget(message.getTarget());
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveFooterInfo(){
		log.info("saving message with target: " + footerInfo);
		
		Message message = new Message("footerInfo", footerInfo);
		
		dao.deleteMessageByTarget(message.getTarget());
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	public void saveAddress(){
		log.info("saving message with target: " + address);
		
		Message message = new Message("address", address);
		
		dao.deleteMessageByTarget(message.getTarget());
		dao.save(message);
		sendPFSuccessMessage();
	}
	
	//getters and setters
	public int getTablesFor2() {
		return tablesFor2;
	}
	public void setTablesFor2(int tablesFor2) {
		this.tablesFor2 = tablesFor2;
	}
	public int getTablesFor6() {
		return tablesFor6;
	}
	public void setTablesFor6(int tablesFor6) {
		this.tablesFor6 = tablesFor6;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFooterInfo() {
		return footerInfo;
	}
	public void setFooterInfo(String footerInfo) {
		this.footerInfo = footerInfo;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
