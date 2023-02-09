package com.vti.entity;

public class Employee extends Account {
	private int id;
	private ProSkill proSkill;

	public enum ProSkill {
		DEV, TEST, JAVA, SQL
	}

}
