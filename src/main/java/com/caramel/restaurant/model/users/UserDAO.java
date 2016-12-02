package com.caramel.restaurant.model.users;

import java.util.List;

import org.hibernate.SessionFactory;

import com.caramel.restaurant.utils.HibernateUtil;

public interface UserDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<User> getAccounts();
	
	public void saveNewAccount(String nick, String password, boolean enabled);
	
	public void changePasswordByName(String nick, String newPassword);	
	
	public void deleteAccountByName(String nick);
	
	public List<User> getByName(String nick);
}
