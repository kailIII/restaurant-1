package com.caramel.restaurant.model.view.message;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="NumericMessage")
@Table(name="numericmessage")
public class NumericMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 283516804044024058L;

	public NumericMessage(){}
	
	public NumericMessage(String target, int number){
		this.target = target;
		this.number = number;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="target")
	private String target;
	
	@Column(name="number")
	private int number;
	
	
	//getters and setters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
