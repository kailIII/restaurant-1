package com.caramel.restaurant.model.view.image;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class ImageViewDAO {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger log = LogManager.getLogger(ImageViewDAO.class.getName());
	
	public void save(ImageView image){
		log.debug("begin transaction with db");
		session.beginTransaction();
		
		log.debug("saving to db");
		session.save(image);
		
		log.debug("commiting and closing connection to db");
		session.getTransaction().commit();
		session.close();
	}
	
	public int getNextFreeId(){
		
		String hql = "SELECT Max(a.id) FROM ImageView a";
		log.info("quering DB: " + hql);
		
		@SuppressWarnings("unchecked")
		List<Integer> result = session.createQuery(hql).getResultList();
		
		log.debug("creating id value");
		int imageId = 1;
		if(result.size() > 0)
			imageId = result.get(0) + 1;
		
		return imageId;
	}

}
