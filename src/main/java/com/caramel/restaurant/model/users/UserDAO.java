package com.caramel.restaurant.model.users;

import java.util.List;

import org.hibernate.SessionFactory;

import com.caramel.restaurant.utils.HibernateUtil;

public interface UserDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	List<User> getAccounts();
	
	void saveNewAccount(String nick, String password, boolean enabled);
	
	void changePasswordByName(String nick, String newPassword);	
	
	void deleteAccountByName(String nick);
}
