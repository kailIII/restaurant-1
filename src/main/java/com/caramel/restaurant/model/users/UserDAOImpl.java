package com.caramel.restaurant.model.users;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.caramel.restaurant.utils.HibernateUtil;

//i can be my the best class in all this project...
public class UserDAOImpl implements UserDAO {

	private Logger log = LogManager.getLogger(UserDAOImpl.class.getName());

	@Override // get users
	@SuppressWarnings("unchecked")
	public List<User> getAccounts() {

		Session session = sessionFactory.openSession();
		List<User> result = null;

		try {
			session.beginTransaction().begin();
			result = session.createQuery("FROM users").getResultList();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
		
		return result;
	}

	@Override // save new user
	public void saveNewAccount(String nick, String password, boolean enabled) {

		Session session = null;
		User user = new User(nick, password, enabled);
		UserRole role = new UserRole(user, "ROLE_ADMIN");

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(user);

		} finally {
			session.getTransaction().commit();
		}
		
		user.getUserRole().add(role);
		
		try {
			session.beginTransaction();

			session.save(role);

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void changePasswordByName(String nick, String newPassword) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction().begin();

			// find user with equal nick
			User user = session.load(User.class, nick);

			// remove users from db
			session.delete("users", user);
			session.flush();

			// change password
			user.setPassword(newPassword);

			// save users from db
			session.save(user);

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override // delete user
	public void deleteAccountByName(String nick) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction().begin();

			// find user with equal nick
			User user = session.load(User.class, nick);

			// remove users from db
			session.delete("users", user);
			session.flush();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public List<User> getByName(String nick) {
		List<User> result = null;
		Session session = null;
		
		try {
			log.info("querring db for users");
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			result = session.createQuery("FROM User u WHERE u.username = :param").setParameter("param", nick).getResultList();
			
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		
		
		return result;
	}
}
