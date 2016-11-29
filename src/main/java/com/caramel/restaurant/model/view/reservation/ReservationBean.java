package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.caramel.restaurant.model.view.message.MessageDAO;
import com.caramel.restaurant.model.view.message.MessageDAOImpl;
import com.caramel.restaurant.model.view.message.NumericMessageDAO;
import com.caramel.restaurant.model.view.message.NumericMessageDAOImpl;


@ManagedBean
@ViewScoped
public class ReservationBean implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1277131828348490458L;
	private final Logger log = LogManager.getLogger(ReservationBean.class.getName());
	private static MessageDAO messageDAO = new MessageDAOImpl();
	private static NumericMessageDAO numericMessageDAO = new NumericMessageDAOImpl();
	
	private Date date = new Date();
	private Date firstTime = new Date();
	private Date secondTime = new Date();
	private boolean disableWeekends = false;
	private String openingTime;
	private String closingTime;
	private int items2;//how many tables for people
	private int items6;//how many tables for people
	private String firstname;
	private String surname;
	private String phone;
	private String email;
	private String people;
	
	@ManagedProperty("#{reservation}")
	List<Reservation> reservations;
	
	
	//all date object is deprecated, but primefaces uses it
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init(){
		log.debug("create new reservation bean");
		
		firstTime.setHours(12);
		firstTime.setMinutes(0);
		
		secondTime.setHours(12);
		secondTime.setMinutes(0);
		try {
			
		openingTime = messageDAO.getMessageByTarget("openTime");
		closingTime = messageDAO.getMessageByTarget("closeTime");
		items2 = numericMessageDAO.getMessageByTarget("tablesFor2");
		items6 = numericMessageDAO.getMessageByTarget("tablesFor6");
		} catch (Exception e) {
			// TODO: handle exception
			log.warn("failed to set times and numbers of items: " + e.getStackTrace().toString());
		}
	}
	
	public void setReservationsListByEmail(){
		ReservationDAOImpl reservationDAO = new ReservationDAOImpl();
		log.info("list was changed: " + email);
		this.reservations =  reservationDAO.getByEmail(email);
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
		
		ReservationDAOImpl dao = new ReservationDAOImpl();
		dao.save(res);
	}
	
	public void saveIfok(){
		
		//validation
		//saving allowed only for 2 and 6
		if( !(people.equals("2") || people.equals("6")) ){
			log.info("reservation failed for " + people + " people parameter");
			return;
		}
		
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
		
		ReservationDAOImpl dao = new ReservationDAOImpl();
		List<Reservation> checkList = dao.getBetweenTime(res.getDate(), 
														res.getFirstTime(), 
														res.getSecondTime(),
														res.getPeople());
		
		
		//create actual date for validation
		Date actualDate = new Date();
		
		//create date with opening time for validation
		Date openDateChecker = new Date(res.getFirstTime().getTime());
		openDateChecker.setHours(Integer.parseInt(openingTime));
		
		//create date with closing time for validation
		Date closeDateChecker = new Date(res.getFirstTime().getTime());
		closeDateChecker.setHours(Integer.parseInt(closingTime));
		
		
		log.debug("validates reservation properties");
		//simple validation with if statement
		switch (people) {
		case "2":
			if(checkList.size() < items2 
			&& res.getDate().after(actualDate)
			
			&& res.getFirstTime().before(closeDateChecker) //between opening time and closing time
			&& res.getFirstTime().after(openDateChecker)
			
			&& res.getSecondTime().before(closeDateChecker) //between opening time and closing time
			&& res.getSecondTime().after(openDateChecker)
			
			&& (res.getPeople().equals("2") || res.getPeople().equals("6") )// only for 2 people and 6
			&& res.getFirstTime().before( res.getSecondTime() )//first should be before second
			&& !res.getFirstTime().equals( res.getSecondTime() )){//first time isn't equal to second
				dao.save(res);
				
				//show information to client
				requestContext.update("form:success");
				requestContext.execute("PF('success').show()");
				log.info("reservation successed");
				return;
			}
			break;
			
			
		case "6":
			if(checkList.size() < items6 
			&& res.getDate().after(actualDate)
			
			&& res.getFirstTime().before(closeDateChecker) //between opening time and closing time
			&& res.getFirstTime().after(openDateChecker)
			
			&& res.getSecondTime().before(closeDateChecker) //between opening time and closing time
			&& res.getSecondTime().after(openDateChecker)
			
			&& (res.getPeople().equals("2") || res.getPeople().equals("6") )// only for 2 people and 6
			&& res.getFirstTime().before( res.getSecondTime() )//first should be before second
			&& !res.getFirstTime().equals( res.getSecondTime() )){//first time isn't equal to second
				dao.save(res);
				
				//show information to client
				requestContext.update("form:success");
				requestContext.execute("PF('success').show()");
				log.info("reservation successed");
				return;
			}
			break;
		}
		
		requestContext.update("form:fail");
		requestContext.execute("PF('fail').show()");
		log.info("reservation failed");
		log.info("start");
		
		if(!(res.getDate().after(actualDate))){
			log.info("!res.getDate().after(actualDate) return true");
		}
			
		if(!(res.getFirstTime().before(closeDateChecker))){
			log.info("!res.getFirstTime().before(closeDateChecker) return true " + closeDateChecker);
		}
			
		if( !(res.getSecondTime().after(openDateChecker))){
			log.info("! res.getSecondTime().after(openDateChecker) return true " + openDateChecker);
		}
			
		if( !(res.getSecondTime().before(closeDateChecker))){
			log.info("!res.getSecondTime().before(closeDateChecker) return true " + closeDateChecker);
		}
		
		if( !(res.getSecondTime().after(openDateChecker))){
			log.info("!res.getSecondTime().after(openDateChecker) return true " + closeDateChecker);
		}
			
		if( !(res.getPeople().equals("2") || res.getPeople().equals("6"))){
			log.info("!res.getPeople().equals(2) || res.getPeople().equals(6) return true");
		}
			
		if( !(res.getFirstTime().before( res.getSecondTime() ))){
			log.info("!res.getFirstTime().before( res.getSecondTime() ) return true");
		}
		
		if(res.getFirstTime().equals( res.getSecondTime() )){
			log.info("res.getFirstTime().equals( res.getSecondTime() ) return true");
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
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public boolean isDisableWeekends() {
		return disableWeekends;
	}

	public String getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}


	public String getClosingTime() {
		return closingTime;
	}


	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
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

	public int getItems6() {
		return items6;
	}

	public void setItems6(int items6) {
		this.items6 = items6;
	}

	public int getItems2() {
		return items2;
	}

	public void setItems2(int items2) {
		this.items2 = items2;
	}
}
