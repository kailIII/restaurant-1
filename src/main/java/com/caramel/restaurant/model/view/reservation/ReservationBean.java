package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@ManagedBean
@ViewScoped
public class ReservationBean implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1277131828348490458L;
	private final Logger log = LogManager.getLogger(ReservationBean.class.getName());
	
	
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

	
	//all date object is deprecated, but primefaces uses it
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init(){
		log.debug("create new reservation bean");
		
		firstTime.setHours(12);
		firstTime.setMinutes(0);
		
		secondTime.setHours(12);
		secondTime.setMinutes(0);
	}

	
	public void save(){
		//creates new object to save in database
		Reservation res = new Reservation();
		res.setEmail(email);
		res.setPhone(phone);
		res.setFirstname(firstname);
		res.setSurname(surname);
		res.setPeople(people);
		res.setDate(date);
		res.setFirstTime(new Time(firstTime.getHours(), firstTime.getMinutes(), 0));
		res.setSecondTime(new Time(secondTime.getHours(), secondTime.getMinutes(), 0));
		
		ReservationDAO dao = new ReservationDAO();
		dao.save(res);
	}
	
	public void saveIfok(){
		//creates new object to save in database
		Reservation res = new Reservation();
		res.setEmail(email);
		res.setPhone(phone);
		res.setFirstname(firstname);
		res.setSurname(surname);
		res.setPeople(people);
		
		date.setTime((date.getTime() + (12L * 60L * 60L * 1000L) ));// (date time plus 12 hours) should make the same date for every timezone
		res.setDate(date);
		res.setFirstTime(new Time(firstTime.getHours(), firstTime.getMinutes(), 0));//setting date time into sql time object
		
		secondTime.setTime((secondTime.getTime()));
		res.setSecondTime(new Time(secondTime.getHours(), secondTime.getMinutes(), 0));//setting date time into sql time object
		
		//create object which allow to communicate with client
		RequestContext requestContext = RequestContext.getCurrentInstance();
		
		ReservationDAO dao = new ReservationDAO();
		List<Reservation> checkList = dao.getBetweenTime(res.getDate(), 
														res.getFirstTime(), 
														res.getSecondTime(),
														res.getPeople());
		
		
		//create actual date for validation
		Date actualDate = new Date();
		
		//create date with opening time for validation
		Date openDateChecker = new Date(res.getFirstTime().getTime());
		openDateChecker.setHours(Integer.parseInt(openingTimes));
		
		//create date with closing time for validation
		Date closeDateChecker = new Date(res.getFirstTime().getTime());
		closeDateChecker.setHours(Integer.parseInt(closingTimes));
		
		
		log.debug("validates reservation properties");
		//simple validation with if statement
		if(checkList.size() <= 15 
				&& res.getDate().after(actualDate)
				
				&& res.getFirstTime().before(openDateChecker) //between opening time and closing time
				&& res.getFirstTime().after(closeDateChecker)
				
				&& res.getSecondTime().before(openDateChecker) //between opening time and closing time
				&& res.getSecondTime().after(closeDateChecker)
				
				&& (res.getPeople().equals("2") || res.getPeople().equals("6") )// only for 2 people and 6
				&& res.getFirstTime().before( res.getSecondTime() )//first is before second
				&& !res.getFirstTime().equals( res.getSecondTime() )){//first time isn't equal to second
			dao.save(res);
		//show information to client
		requestContext.update("form:success");
		requestContext.execute("PF('success').show()");
		log.info("reservation successed");
		return;
		}
		
		requestContext.update("form:fail");
		requestContext.execute("PF('fail').show()");
		log.info("reservation failed");
		log.info("start");
		
		if(!(checkList.size() <= 15)){
			log.info("checkList.size() <= 15 return true");
		}
		
		if(!(res.getDate().after(actualDate))){
			log.info("res.getDate().after(actualDate) return true");
		}
			
		if(!(res.getFirstTime().after(closeDateChecker))){
			log.info("res.getFirstTime().after(closeDateChecker) return true");
		}
			
		if( !(res.getSecondTime().before(openDateChecker))){
			log.info(" res.getSecondTime().before(openDateChecker) return true");
		}
			
		if( !(res.getSecondTime().after(closeDateChecker))){
			log.info("res.getSecondTime().after(closeDateChecker) return true");
		}
			
		if( !(res.getPeople().equals("2") || res.getPeople().equals("6"))){
			log.info("res.getPeople().equals(2) || res.getPeople().equals(6) return true");
		}
			
		if( !(res.getFirstTime().before( res.getSecondTime() ))){
			log.info("res.getFirstTime().before( res.getSecondTime() ) return true");
		}
		
		if(res.getFirstTime().equals( res.getSecondTime() )){
			log.info("!res.getFirstTime().equals( res.getSecondTime() ) return false");
		}
		
		log.info("end");
	}
	
	
	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected",
				format.format(event.getObject())));
	}
	
	
	
	
	
	
	//getters and setters
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

	public boolean isDisableWeekends() {
		return disableWeekends;
	}

	public void setDisableWeekends(boolean disableWeekends) {
		this.disableWeekends = disableWeekends;
	}

	public Date getDate() {
		return date;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
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
}
