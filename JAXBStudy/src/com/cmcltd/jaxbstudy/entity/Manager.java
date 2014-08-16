package com.cmcltd.jaxbstudy.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Manager extends Employee {

	String department;

	public Manager() {
		jobClass = "A";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
