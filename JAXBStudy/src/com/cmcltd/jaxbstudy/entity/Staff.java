package com.cmcltd.jaxbstudy.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Staff extends Employee {

	String workType;

	public Staff() {
		jobClass = "C";
	}

	@XmlElement
	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

}
