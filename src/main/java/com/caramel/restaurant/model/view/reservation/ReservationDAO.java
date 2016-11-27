package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class ReservationDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1543442221284521269L;
	private final Logger log = LogManager.getLogger(ReservationDAO.class.getName());

	//return list of reservations with selected id and ordered by date
	public List<Reservation> getBetweenTime(Date date, Time firstTime, Time secondTime, String numberOfPeople){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		log.info("date: " + date.toString() + "firsttime: " + firstTime.toString() + "secondtime: " + secondTime.toString());
		
		@SuppressWarnings("unchecked")
		List<Reservation> result = session.createQuery("FROM Reservation a "
														+ "WHERE date(a.date) like date(:date) " //date() cuts off time from date, the same date and
															+ "AND a.people = :people "// which table type
															+ "AND ((a.secondTime >= :first AND a.secondTime <= :second ) " //second time should be between first and second
																+ "OR (a.firstTime >= :first AND a.firstTime <= :second ) "// or first time should be between first and second
																+ "OR (a.firstTime <= :first AND a.secondTime >= :second )) "// and data can be between two parameters from other records
														+ "ORDER by a.date DESC, a.firstTime DESC")
											.setDate("date", date)
											.setTime("first", firstTime)
											.setTime("second", secondTime)
											.setParameter("people", numberOfPeople)
											.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
	//return list of reservations with selected id and ordered by date
	public List<Reservation> getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Reservation> result = session.createQuery("FROM Reservation a WHERE a.id = :param ORDER by a.date DESC, a.firstTime DESC")
											.setParameter("param", id)
											.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
	//return list of reservations with selected surname and ordered by date
	public List<Reservation> getByEmail(String email){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Reservation> result = session.createQuery("FROM Reservation a WHERE a.email = :param ORDER by a.date DESC, a.firstTime DESC")
											.setParameter("param", email)
											.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
	//return list of reservations ordered by date
	public List<Reservation> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Reservation> result = session.createQuery("FROM Reservation a ORDER by a.date DESC, a.firstTime DESC")
											.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}

	public void save(Reservation res){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(res);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Reservation reservation = session.load(Reservation.class, id);
		session.delete(reservation);
		session.flush();
		
		session.getTransaction().commit();
		session.close();
	}
}
