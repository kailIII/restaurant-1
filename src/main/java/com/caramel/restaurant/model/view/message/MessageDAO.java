package com.caramel.restaurant.model.view.message;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class MessageDAO { 
	private static Logger log = LogManager.getLogger(MessageDAO.class.getName());
	
	//method to find next free id
	public int getNextFreeId(){
		
		String hql = "SELECT Max(a.id) FROM Message a";
		log.debug("quering DB: " + hql);
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Integer> result = session.createQuery(hql).getResultList();
		session.beginTransaction().commit();
		session.close();
		
		int id = 1;
		if(result.size() > 0)
			id = result.get(0) + 1;
		
		
		return id;
	}
	
	//method to save message object
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
	
	//returning message with target specified target, 
	//can be used to return a few records in one string
	public String getMessageByTarget(String target){
		
		//querying db, it's small list, sql "where" command is unnecessary
		String hql = "SELECT a FROM Message a";
		log.debug("quering db to get data: " + hql);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Message> result = session.createQuery(hql).getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		//default value to return 
		String message = new String();
		
		//comparing data to arg and if true then saving it to variable
		for (Message message_t : result) {
			if (message_t.getTarget().equals(target)) {
				log.trace("adding message content to bean: " + message_t.getMessage());
				message += message_t.getMessage();
			}
			else{
				log.trace("isn't equal: " + message_t.getTarget() + " and " + target);
			}
		}
		
		return message;
	}
	
	//deleting message with specified target
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





