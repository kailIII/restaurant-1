package com.caramel.restaurant.model.users;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(eager=true)
@ApplicationScoped
public class UserBean {
	private static Logger log = LogManager.getLogger(UserBean.class.getName());
	
	private static UserDAO dao = new UserDAOImpl();
	private static UserRoleDAO roleDAO = new UserRoleDAOImpl();
	
	private String nick;
	private String password;
	private String checkPassword;
	
	@PostConstruct
	public void init(){
		
		List<User> usersByName = dao.getByName(nick);
		
		if(usersByName.size() <= 0){
			
			log.info("creating root account");
			dao.saveNewAccount("root", "1234", true);
//			roleDAO.saveAdminRole("root");
		}
	}
	
	
	public List<User> getAccounts(){
		return dao.getAccounts();
	}
	
	
	public void saveNewAccount(){
		if(!(nick.length() > 0 || arePasswordsEqual()) )
			return;
		
		dao.saveNewAccount(nick, password, true);
		roleDAO.saveAdminRole(nick);
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
									.equals(nick))
			return;
		
		dao.deleteAccountByName(nick);
		
		//delete usersRole even when usernames are duplicated
		List<UserRole> roles = roleDAO.getByName(nick);
		
		for (UserRole role : roles) {
			roleDAO.deleteRoleById(role.getUserRoleId());			
		}
	}
	
	
	public boolean arePasswordsEqual(){
		if (password.equals(checkPassword))
			return true;
					
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
