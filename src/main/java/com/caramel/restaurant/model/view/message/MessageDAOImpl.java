package com.caramel.restaurant.model.view.message;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class MessageDAOImpl implements MessageDAO{ 
	private static Logger log = LogManager.getLogger(MessageDAOImpl.class.getName());
	
	//method to save message object
	@Override
	public void save(Message message){
		
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
	//can be used to return a few records in one string
	@Override
	public String getMessageByTarget(String target){
		
		//querying db
		String hql = "SELECT a FROM Message a where a.target = :param";
		log.debug("quering db to get data: " + hql);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Message> result = session.createQuery(hql)
												.setParameter("param", target)
												.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		//default value to return 
		String message = new String();
		
		//comparing data to arg and if true then saving it to variable
		for (Message message_t : result) {
				message += message_t.getMessage();
		}
		
		return message;
	}
	
	//deleting message with specified target
	@Override
	public void deleteMessageByTarget(String target){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		
		log.debug("quering db to find records with target: " + target);
		//querying db
		@SuppressWarnings("unchecked")
		List<Message> result = session.createQuery("FROM Message a WHERE a.target = :param")
										.setParameter("param", target)
										.getResultList();
		
		log.info("delete by target: " + target);
		//comparing data to arg and if true then saving it to variable
		for (Message message_t : result) {
			log.trace("delete message from db: " + message_t.getMessage());
			session.delete(message_t);	
			session.flush();
		}
		session.getTransaction().commit();
		session.close();
	}
}





