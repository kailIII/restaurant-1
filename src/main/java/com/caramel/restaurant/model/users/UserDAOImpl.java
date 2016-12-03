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

		Session session = null;
		List<User> result = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			result = session.createQuery("FROM User").getResultList();

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
			
			//save user
			session.save(user);

		} finally {
			session.getTransaction().commit();
		}
		
		//save user role
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

	@SuppressWarnings("unchecked")
	@Override // delete user and its roles
	public void deleteAccountByName(String nick) {
		Session session = null;
		List<UserRole>rolesResult = new ArrayList<UserRole>();
		
		
		//get roles by nick
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			rolesResult = session.createQuery("FROM UserRole r WHERE r.username = :param")
												.setParameter("param", nick)
												.getResultList();
			
		} finally {
			session.getTransaction().commit();
		}
		
		
		//delete users and their role
		try {
			session.beginTransaction();
			
			//delete roles
			for (UserRole role : rolesResult) {
				UserRole role_t = session.load(UserRole.class, role.getUserRoleId());
				session.delete(role_t);
			}
			
			//delete user by nick
			User user = session.load(User.class, nick);
			session.delete(user);
			
			session.flush();

		} finally {
			session.getTransaction().commit();
			session.close();
		}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
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
			
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		
		return result;
	}
}
