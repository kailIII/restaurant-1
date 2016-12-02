package com.caramel.restaurant.model.users;

import java.util.List;

public interface UserRoleDAO {
	
	public void saveAdminRole(String username);
	
	public void deleteRoleById(int id);
	
	public List<UserRole>getAll();

	public List<UserRole> getByName(String nick);
}
