package com.vti.entity;

public class Employee extends User {
	private int id;
	private ProSkill proSkill;

	public enum ProSkill {
		HTML, JAVA_SCRIPT, JAVA, SQL
	}

}
