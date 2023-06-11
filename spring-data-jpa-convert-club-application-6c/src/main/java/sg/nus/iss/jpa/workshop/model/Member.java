package sg.nus.iss.jpa.workshop.model;

import javax.persistence.Entity;

@Entity
public class Member extends Person{

private int memberNumber;
	
	//constructors
	public Member() {}
	public Member(String surName, String firstName, int memberNumber) {
		super(surName, firstName);
		this.memberNumber = memberNumber;
	}
	public Member(String surName, String firstName, String secondName, int memberNumber) {
		super(surName, firstName, secondName);
		this.memberNumber = memberNumber;
	}

	//getters and setters
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	//toString
	@Override
	public String toString() {
		return memberNumber + " " + super.toString();
	}
}
