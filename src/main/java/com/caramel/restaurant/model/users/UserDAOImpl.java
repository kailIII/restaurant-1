package com.caramel.restaurant.model.users;

import java.util.List;

import org.hibernate.Session;

//i can be my the best class in all this project...
public class UserDAOImpl implements UserDAO{

	@Override//get users
	@SuppressWarnings("unchecked")
	public List<User> getAccounts() {
		
		Session session = sessionFactory.openSession();
		List<User> result = null;
				
		try{
			session.beginTransaction().begin();
			result = session.createQuery("From users").getResultList();
		
		} finally{
			session.getTransaction().commit();
			session.close();
		}
		return result;
	}

	@Override//save new user
	public void saveNewAccount(String nick, String password, boolean enabled) {
		
		User user = new User(nick, password, enabled);
		Session session = sessionFactory.openSession();
		
		try {			
			session.beginTransaction().begin();
			session.save(user);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void changePasswordByName(String nick, String newPassword) {
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction().begin();
			
			//find user with equal nick
			User user = session.load(User.class, nick);

			//remove users from db
			session.delete("users", user);	
			session.flush();
			
			//change password
			user.setPassword(newPassword);
			
			//save users from db
			session.save(user);
			
		} finally {
			session.getTransaction().commit();
			session.close();		
		}
	}

	@Override//delete user
	public void deleteAccountByName(String nick) {
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction().begin();
			
			//find user with equal nick
			User user = session.load(User.class, nick);

			//remove users from db
			session.delete("users", user);	
			session.flush();
			
		} finally {
			session.getTransaction().commit();
			session.close();		
		}
	}
}
