package com.caramel.restaurant.model.view.foodscroller;

import java.util.List;

public interface FoodDAO {

	public List<Food> getMessageByCategory(String category);
	
	public void save(Food food);
	
	public void deleteMessageById(int id);
}
