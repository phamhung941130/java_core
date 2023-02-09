package com.vti.entity;

public class Employee extends User {
	private String proSkill;

	@Override
	public String getProSkill() {
		return proSkill;
	}

	@Override
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

}
