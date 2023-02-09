package com.vti.entity;

public class Manager extends User {
	private int expInYear;

	@Override
	public int getExpInYear() {
		return expInYear;
	}

	@Override
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
}
