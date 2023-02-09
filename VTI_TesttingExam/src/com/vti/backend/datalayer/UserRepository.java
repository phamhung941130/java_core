package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.User;
import com.vti.entity.User.Role;
import com.vti.utils.jdbcUltis;

public class UserRepository implements IUserRepository {
	private jdbcUltis jdbc;

	public UserRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sql);
		pStatement.setString(1, email);
		pStatement.setString(2, password);
		ResultSet resultSet = pStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setFullName(resultSet.getString(2));
			user.setEmail(resultSet.getString(3));
			user.setPassword(resultSet.getString(4));
			Role role = Role.valueOf(resultSet.getString(5).toUpperCase());
			return user;
		} else {
			return null;
		}

	}

	public boolean isAdmin(User user) {
		if (user.getRole() == Role.ADMIN) {
			return true;
		} else {
			return false;
		}
	}

	public void name() {

	}
}
