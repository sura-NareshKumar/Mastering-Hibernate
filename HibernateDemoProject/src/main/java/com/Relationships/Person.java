package com.Relationships;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String personName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aadhar_id")
    private Aadhar aadharId;
    
	public Person() {

	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Aadhar getAadharId() {
		return aadharId;
	}

	public void setAadharId(Aadhar aadharId) {
		this.aadharId = aadharId;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", aadharId=" + aadharId + "]";
	}

}
