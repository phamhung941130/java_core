package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.utils.jdbcUltis;

public class Demo {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Function function = new Function();
		jdbcUltis jdbcUltis = new jdbcUltis();
		jdbcUltis.connnectionTestting();
		while (true) {
			function.getLogin();
		}
	}
}
