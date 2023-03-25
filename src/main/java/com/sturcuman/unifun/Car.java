package com.sturcuman.unifun;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "cars")
@Entity
public class Car implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String model;
	private String color;


	public Car(Long id, String type, String model, String color) {
		super();
		this.id = id;
		this.type = type;
		this.model = model;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car() {
		super();
	}

}