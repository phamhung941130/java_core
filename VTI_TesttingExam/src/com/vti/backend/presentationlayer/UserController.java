package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

public class UserController {
	private UserService userService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}

	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		return userService.isLogin(email, password);
	}

	public boolean isAdmin(User user) {
		return userService.isAdmin(user);
	}
}
