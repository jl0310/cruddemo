package com.codetest.cruddemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROJECT_ID", nullable=false, unique=true)
	private int id;
	
	@Column(name="PROJECT_NAME", length=15, nullable=false, unique=false)
	private String name;
	
	@Column(name="PROJECT_DESC", length=35, nullable=false, unique=false)
	private String desc;

	public Project() {
	}

	public Project(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
