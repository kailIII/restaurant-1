package com.caramel.restaurant.model.users;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class UserBean {
	private static UserDAO dao = new UserDAOImpl();
	
	private String nick;
	private String password;
	
	public List<User> getAccounts(){
		return dao.getAccounts();
	}
	
	public void saveNewAccount(){
		dao.saveNewAccount(nick, password, true);
	}
	
	public void changePasswordByName(){
		dao.changePasswordByName(nick, password);
	}
	
	public void deleteAccountByName(){
		if(!SecurityContextHolder.getContext()//if client is not deleting himself/herself
									.getAuthentication()
									.getName()
									.equals(nick))
			
			dao.deleteAccountByName(nick);
	}
	
	
	//getters nad setters
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
