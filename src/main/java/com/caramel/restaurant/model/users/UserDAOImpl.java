package com.caramel.restaurant.model.users;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	private Logger log = LogManager.getLogger(UserDAOImpl.class.getName());

	
	@Override // get users
	@SuppressWarnings("unchecked")
	public List<User> getAccounts() {

		Session session = null;
		List<User> result = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			result = session.createQuery("FROM User").getResultList();
			session.getTransaction().commit();

		} finally {
			session.close();
		}
		
		return result;
	}

	
	@Override // save new user
	public void saveNewAccount(String nick, String password, boolean enabled) {

		Session session = null;
		User user = new User(nick, password, enabled);
		UserRole role = new UserRole(user, "ROLE_MODERATOR");
		user.getUserRole().add(role);
		
		//stop if it already exists
		if(getByName(nick).size() > 0){
			log.info("account already exists");
			
			return;
		}
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			//save user
			session.save(user);
			session.getTransaction().commit();

		
			
			//save user role
			session.beginTransaction();
			session.save(role);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

	
	@Override
	public void changePasswordByName(String nick, String newPassword) {
		Session session = null;
		
		
		try {//update data
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			//get users from db
			@SuppressWarnings("unchecked")
			List<User> users = session.createQuery("FROM User u WHERE u.username = :param ")
														.setParameter("param", nick)
														.getResultList();
			
			//validation
			if(users.size() == 1){
				
				//set new password
				users.get(0).setPassword(newPassword);
				
				//change db data
				session.update(users.get(0));
			}
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

	

	@Override // delete user and its roles
	public void deleteAccountByName(String nick) {
		Session session = null;
		List<User>users = new ArrayList<User>();
		
		users = getByName(nick);
		

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			//for every user with username == nick get all roles and delete them
			for (User user : users) {
				
				//delete roles
				for(UserRole role : user.getUserRole()){
					session.delete(role);
				}
				
				//delete user
				session.delete(user);
			}
			session.flush();
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}	
	}

	
	@SuppressWarnings("unchecked")
	@Override//return user with equal nick
	public List<User> getByName(String nick) {
		List<User> result = null;
		Session session = null;
		
		try {
			log.info("querring db for users");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			result = session.createQuery("FROM User u WHERE u.username = :param")
											.setParameter("param", nick)
											.getResultList();

			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
		
		return result;
	}
}
