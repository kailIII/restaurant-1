package com.caramel.restaurant.model.view.foodscroller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class FoodDAOImpl implements FoodDAO{
	
	private final Logger log = LogManager.getLogger(FoodDAOImpl.class.getName());
	
	//returning message with specified category
	@Override
	public List<Food> getMessageByCategory(String category){
		
		//querying db, it's small list, sql "where" command is unnecessary
		log.debug("quering db to get food informations");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Food> result = session.createQuery("FROM Food a WHERE a.cat = :param")
				.setParameter("param", category).getResultList();
		
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
	//method to save message object
	@Override
	public void save(Food food){
		
		//with empty values hibernate throws null id exception
		if(!(food.getName().length() > 0)){
			log.info("name should not be empty");
			return;
		}
		
		log.trace("begin transaction with db");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {			
			session.beginTransaction();
		
			log.debug("saving to db " + Food.class.getName());
			session.save(food);
		
			session.getTransaction().commit();
		} catch (Exception e) {
			log.warn("failed to save food object");
		} 
		finally {
			log.debug("closing connection to db");
			session.close();
		}
	}
	
	
	//deleting message with specified Id
	@Override
	public void deleteMessageById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		log.debug("quering db to find records with id: " + id);
		
		@SuppressWarnings("unchecked")
		List<Food> result = session.createQuery("FROM Food a WHERE a.id = :param")
				.setParameter("param", id).getResultList();
		
		for (int i = 0; i < result.size(); i++) {
			session.delete(result.get(i));
		}
		session.flush();
		
		session.getTransaction().commit();
		session.close();
	}
}
