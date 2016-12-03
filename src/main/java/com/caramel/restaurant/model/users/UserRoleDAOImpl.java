package com.caramel.restaurant.model.users;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class UserRoleDAOImpl implements UserRoleDAO{
//	
//	private static Logger log = LogManager.getLogger(UserRoleDAO.class.getName());
//
//	@Override
//	public void saveAdminRole(String username) {
//	}
//
//	@Override
//	public void deleteRoleById(int id) {
////		Session session = null;
////		
////		try {
////			session = HibernateUtil.getSessionFactory().openSession();
////			session.beginTransaction();
////			UserRole role = session.load(UserRole.class, id);
////			session.delete(role);
////			session.flush();
////			
////		} finally {
////			session.getTransaction().commit();
////			session.close();
////			
////		}
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<UserRole> getAll() {
//		List<UserRole> result = new ArrayList<UserRole>();
//		Session session = null;
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//			result = session.createQuery("").getResultList();
//			
//		} finally {
//			session.getTransaction().commit();
//			session.close();
//			
//		}
//		
//		return result;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<UserRole> getByName(String nick) {
//		Session session = null;
//		List<UserRole> result;
//		User user = new User();
//		user.setUsername(nick);
//		
//		try {
//			log.info("querring db");
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//			
//			result = session.createQuery("FROM UserRole u WHERE u.username = :param").setParameter("param", user.getUsername()).getResultList();
//		
//		} finally {
//			session.getTransaction().commit();
//			session.close();
//		}
//		
//		return result;
//	}
}