package com.caramel.restaurant.model.view.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class ImageViewDAOImpl implements ImageViewDAO{
	
	private static Logger log = LogManager.getLogger(ImageViewDAOImpl.class.getName());
	
	@Override
	public void save(ImageView image){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		log.debug("begin transaction with db");
		session.beginTransaction();
		
		log.debug("saving to db");
		session.save(image);
		
		log.debug("commiting and closing connection to db");
		session.getTransaction().commit();
		session.close();
	}
}
