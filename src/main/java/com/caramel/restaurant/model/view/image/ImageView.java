package com.caramel.restaurant.model.view.image;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity(name="ImageView")
@Table(name="imageview")
public class ImageView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4908203678882544360L;
	private static Logger log = LogManager.getLogger(ImageView.class.getName());

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public ImageView() {
		log.trace(this.getClass().getSimpleName() + " was constructed");
	}
	
	public ImageView(String passedName) {
		log.trace(this.getClass().getSimpleName() + " was constructed");
		this.name = passedName;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImageName() {
		return name;
	}
	public void setImageName(String name) {
		this.name = name;
	}

}
