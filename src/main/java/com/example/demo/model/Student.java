package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer id;
	private String stdId;
	private String stdfirst;
	private String stdlast;
	private String email;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	} 
	
	public Student() {
		super();
	}
	public Student(String stdId,String stdfirst, String stdlast, String email) {
		super();
		this.stdId =stdId;
		this.stdfirst= stdfirst;
		this.stdlast = stdlast;
		this.email = email;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdfirst() {
		return stdfirst;
	}
	public void setStdfirst(String stdfirst) {
		this.stdfirst = stdfirst;
	}
	public String getStdlast() {
		return stdlast;
	}
	public void setStdlast(String stdlast) {
		this.stdlast = stdlast;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
