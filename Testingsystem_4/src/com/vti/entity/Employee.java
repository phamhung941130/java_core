package com.vti.entity;

public class Employee extends Staff {
	private String task;

	public Employee(String name, int age, Gender gender, String address, String task) {
		super(name, age, gender, address);
		this.task = task;
	}

	@Override
	public String toString() {
		return "Name: " + super.getName() + " Age: " + super.getAge() + " Gender: " + super.getGender().toString()
				+ " Adress: " + super.getAddress() + " Task: " + task;
	}

}
