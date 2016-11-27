package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
@ManagedBean
public class AdminReservationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6726115116009569826L;
	private final Logger log = LogManager.getLogger(AdminReservationBean.class.getName());

	private Date date = new Date();
	private Date firstTime = new Date();
	private Date secondTime = new Date();
	private boolean disableWeekends = false;
	private String openingTimes = "9";
	private String closingTimes = "23";
	private String firstname;
	private String surname;
	private String phone;
	private String email;
	private String people;

	@ManagedProperty("#{reservation}")
	List<Reservation> reservations;

	@PostConstruct
	public void init(){
		ReservationDAO dao = new ReservationDAO();
		reservations = dao.getAll();
	}
	
	
	public boolean isEmpty(){
		ReservationDAO dao = new ReservationDAO();
		
		Time firstLocalTime = new Time(firstTime.getHours(), firstTime.getMinutes(), 0);
		Time secondLocalTime = new Time(secondTime.getHours(), secondTime.getMinutes(), 0);
		
		List<Reservation> result = dao.getBetweenTime(date, firstLocalTime, secondLocalTime, people);
		
		if(result.size() == 0)
			return true;
			
		return false;
	}

	public List<Reservation> getBetween(){
		ReservationDAO dao = new ReservationDAO();
		
		Time firstLocalTime = new Time(firstTime.getHours(), firstTime.getMinutes(), 0);
		Time secondLocalTime = new Time(secondTime.getHours(), secondTime.getMinutes(), 0);
		
		List<Reservation> result = dao.getBetweenTime(date, firstLocalTime, secondLocalTime, people);
			
		return result;
	}
	
	
	//getters and setters
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getFirstTime() {
		return firstTime;
	}
	
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	
	public Date getSecondTime() {
		return secondTime;
	}
	
	public void setSecondTime(Date secondTime) {
		this.secondTime = secondTime;
	}
	
	public boolean isDisableWeekends() {
		return disableWeekends;
	}
	
	public void setDisableWeekends(boolean disableWeekends) {
		this.disableWeekends = disableWeekends;
	}
	
	public String getOpeningTimes() {
		return openingTimes;
	}
	
	public void setOpeningTimes(String openingTimes) {
		this.openingTimes = openingTimes;
	}
	
	public String getClosingTimes() {
		return closingTimes;
	}
	
	public void setClosingTimes(String closingTimes) {
		this.closingTimes = closingTimes;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPeople() {
		return people;
	}
	
	public void setPeople(String people) {
		this.people = people;
	}
}
