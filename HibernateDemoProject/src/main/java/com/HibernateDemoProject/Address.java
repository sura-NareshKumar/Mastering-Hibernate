package com.HibernateDemoProject;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private int doorNO;
	private String city;

	public Address() {

	}

	public Address(int doorNO, String city) {
		this.doorNO = doorNO;
		this.city = city;
	}

	public int getDoorNO() {
		return doorNO;
	}

	public void setDoorNO(int doorNO) {
		this.doorNO = doorNO;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [doorNO=" + doorNO + ", city=" + city + "]";
	}

}
