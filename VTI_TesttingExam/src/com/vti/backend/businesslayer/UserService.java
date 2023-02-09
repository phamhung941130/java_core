package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

public class UserService implements IUserService {
	private UserRepository userRepository;

	public UserService() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
	}

	@Override
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		return userRepository.isLogin(email, password);
	}

	@Override
	public boolean isAdmin(User user) {
		return userRepository.isAdmin(user);
	}
}
