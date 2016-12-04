package com.caramel.restaurant.model.users;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

@ManagedBean(eager=true)
@ApplicationScoped
public class UserBean {
	private static Logger log = LogManager.getLogger(UserBean.class.getName());
	
	private static UserDAO dao = new UserDAOImpl();
	
	private String nick;
	private String password;
	private String checkPassword;
	
	@PostConstruct
	public void init(){//will create root account if it's not exist
		
		List<User> usersByName = dao.getByName("root");
		
		if(usersByName.size() <= 0){
			
			log.info("creating root account");
			dao.saveNewAccount("root", "123", true);
		}
	}
	
	
	
	
	public void saveNewAccount(){

		//password and nick validation
		if(nick.length() <=  3 || !arePasswordsEqual() || nick.equals("root") || password.length() < 6){
			log.info("Cannot create new account. Validation failed");
			return;
		}
		
		//save
		dao.saveNewAccount(nick, password, true);
	}
	
	
	public void changePasswordByName(){
		if (!arePasswordsEqual())
			return;
			
		dao.changePasswordByName(nick, password);
	}
	
	
	public void deleteAccountByName(){
		if(SecurityContextHolder.getContext()//if client is not deleting himself/herself
									.getAuthentication()
									.getName()
									.equals(nick)
									|| nick.equals("root"))
			return;
		
		dao.deleteAccountByName(nick);
	}
	
	
	public boolean arePasswordsEqual(){
		if (password.equals(checkPassword))
			return true;
					
		return false;
	}
	
	public List<User> getAccounts(){
		return dao.getAccounts();
	}
	
	public boolean hasRole(String role){
		
		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(role))){
			log.debug("user has admin role");
			return true;
		}
		
		return false;
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

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
}
