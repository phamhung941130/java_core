package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserSevice;
import com.vti.backend.businesslayer.UserSevice;
import com.vti.entity.User;

public class UserController {
	private IUserSevice userSevice;

	public UserController() throws FileNotFoundException, IOException {
		userSevice = new UserSevice();
	}

	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		return userSevice.isLogin(email, password);
	}

	public Boolean isAdmin(User user) {
		return userSevice.isAdmin(user);
	}

	public List<User> getlistuser() throws ClassNotFoundException, SQLException {
		return userSevice.getlistuser();
	}
}
