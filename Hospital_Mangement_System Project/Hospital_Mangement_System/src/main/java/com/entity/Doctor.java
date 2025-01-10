package com.entity;

public class Doctor {

	private int id;
	private String name;
	private String dob;
	private String email;
	private String qualification;
	private String specialist;
	private String mobNo;
	private String pass;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	

	public Doctor(int id, String name, String dob, String email, String qualification, String specialist, String mobNo,
			String pass) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.qualification = qualification;
		this.specialist = specialist;
		this.mobNo = mobNo;
		this.pass = pass;
	}



	public Doctor(String name, String dob, String email, String qualification, String specialist, String mobNo,
			String pass) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.qualification = qualification;
		this.specialist = specialist;
		this.mobNo = mobNo;
		this.pass = pass;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
