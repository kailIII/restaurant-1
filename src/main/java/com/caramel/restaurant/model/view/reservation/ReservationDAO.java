package com.caramel.restaurant.model.view.reservation;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ReservationDAO {

	//return list of reservations with selected id and ordered by date
	public List<Reservation> getBetweenTime(Date date, 
													Time firstTime, 
													Time secondTime, 
													String numberOfPeople);
		
	public List<Reservation> getById(int id);
		
	public List<Reservation> getByEmail(String email);
		
	public List<Reservation> getAll();

	public void save(Reservation res);
		
	public void deleteById(int id);
}
