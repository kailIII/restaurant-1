package com.caramel.restaurant.model.view.message;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class NumericMessageDAOImpl implements NumericMessageDAO{ 
	private static Logger log = LogManager.getLogger(NumericMessageDAOImpl.class.getName());
	
	//method to save message object
	@Override
	public void save(NumericMessage message){
		
		log.trace("begin transaction with db");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		log.debug("saving to db " + Message.class.getName());
		session.save(message);
		
		log.debug("commiting and closing connection to db");
		session.getTransaction().commit();
		session.close();
	}
	
	//returning message with specified target, 
	@Override
	public int getMessageByTarget(String target){
		
		//querying db
		String hql = "SELECT a FROM NumericMessage a where a.target = :param";
		log.debug("quering db to get data: " + hql);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<NumericMessage> result = session.createQuery(hql)
												.setParameter("param", target)
												.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		//default value to return 
		int message;
		
		if(!result.isEmpty()){
			message = result.get(0).getNumber();
			return message;
		}
		
		return -1;
	}
	
	@Override
	public boolean doExist(String target){
		
		//querying db
		String hql = "SELECT a FROM NumericMessage a where a.target = :param";
		log.debug("quering db to get data: " + hql);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<NumericMessage> result = session.createQuery(hql)
												.setParameter("param", target)
												.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		if(!result.isEmpty()){
			return true;
		}
		
		return false;
	}
	
	//deleting message with specified target
	@Override
	public void deleteMessageByTarget(String target){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		
		log.debug("quering db to find records with target: " + target);
		//querying db
		@SuppressWarnings("unchecked")
		List<NumericMessage> result = session.createQuery("FROM NumericMessage a WHERE a.target = :param")
										.setParameter("param", target)
										.getResultList();
		
		
		log.info("delete by target: " + target);
		//comparing data to arg and if true then saving it to variable
		for (NumericMessage message_t : result) {
			log.trace("delete numericmessage from db: " + message_t.getNumber());
			session.delete(message_t);	
			session.flush();
		}
		
		session.getTransaction().commit();
		session.close();
	}
}





