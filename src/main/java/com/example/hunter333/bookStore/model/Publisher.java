package com.example.hunter333.bookStore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

/**
 * 
 * @author Hunter333
 *
 */
@Entity
public class Publisher implements Serializable {

	private static final long serialVersionUID = 5636088655232742319L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Expose
	private String name;
	@Expose
	private String address;

	public Publisher() {
	}

	public Publisher(String name) {
		super();
		this.name = name;
	}

	public Publisher(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
