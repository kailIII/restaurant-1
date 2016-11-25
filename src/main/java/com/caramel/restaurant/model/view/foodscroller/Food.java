package com.caramel.restaurant.model.view.foodscroller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="Food")
@Table(name="food")
public class Food {
	
	public Food(String name, String desc, String category){
		this.name = name;
		this.description = desc;
		this.cat = category;
	}
	
	public Food(){
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotEmpty
	private int id;
	
	@Column(name="description", length=10000000)
	private String description;
	
	@Column(name="name")
	@NotEmpty
	private String name;
	
	//category
	@Column(name="cat")
	@NotEmpty
	private String cat;
	
	//getter and setters
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
