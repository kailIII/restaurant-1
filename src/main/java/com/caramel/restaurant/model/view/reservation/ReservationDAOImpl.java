package com.caramel.restaurant.model.view.reservation;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.joda.time.DateTime;

import com.caramel.restaurant.utils.HibernateUtil;

public class ReservationDAOImpl implements ReservationDAO{
	private final Logger log = LogManager.getLogger(ReservationDAOImpl.class.getName());

	//return list of reservations with selected id and ordered by date
	@Override
	public List<Reservation> getBetweenTime(Date date, Time firstTime, Time secondTime, String numberOfPeople) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		log.info("date: " + date.toString() + "firsttime: " + firstTime.toString() + "secondtime: " + secondTime.toString());
		
		@SuppressWarnings({ "unchecked", "deprecation" })
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
	@Override
	public List<Reservation> getById(int id) {
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
	@Override
	public List<Reservation> getByEmail(String email) {
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
	@Override
	public List<Reservation> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Reservation> result = session.createQuery("FROM Reservation a ORDER by a.date DESC, a.firstTime DESC")
											.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}

	@Override
	public void save(Reservation res) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(res);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteById(long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Reservation reservation = session.load(Reservation.class, id);
			session.delete(reservation);
			session.flush();
			session.getTransaction().commit();
		}
		
		catch (Exception e) {
			log.warn("Id doesn't exist");
		}
		
		finally{
			session.close();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getByDay(int year, int month, int day, String people) {

		//stop if month doesn't exist
		if (month > 12 || month < 1)
			return new ArrayList<>();
		
		Session session = null;
		List<Reservation> result = null;
		
		
		//init, create date time
		DateTime jodaD1 = new DateTime(new Date()).withYear(year)
													.withMonthOfYear(month)
													.withDayOfMonth(day)
													.withHourOfDay(12)
													.withMinuteOfHour(0)
													.withSecondOfMinute(0)
													.withMillisOfSecond(0);
		
		//set datetime to dates
		Date date1 = jodaD1.toDate();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		result = session.createQuery("FROM Reservation a "
														+ "WHERE date(a.date) = date(:date1) " //date() cuts off time from date and
															+ "AND a.people = :people "// which table type
														+ "ORDER by a.date DESC, a.firstTime DESC")
											.setParameter("date1", date1)
											.setParameter("people", people)
											.getResultList();

			log.info("received: " + result.size() + " reservations where date is: " + date1.toString());

		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
}
