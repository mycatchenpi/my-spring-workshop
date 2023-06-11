package sg.nus.iss.jpa.workshop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String surName;
	protected String firstName;
	protected String secondName;
	
	//constructors
	public Person() {}
	public Person(String surName, String firstName) {
		this.surName = surName;
		this.firstName = firstName;
	}
	public Person(String surName, String firstName, String secondName) {
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getSurName() {
		return surName;
	}

	//toString
	public String toString() {
		String fullName = firstName;
		if(secondName != null) {
			fullName += " " + secondName;
		}
		fullName += " " + surName;
		return fullName;
	}

}
