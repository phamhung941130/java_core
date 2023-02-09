package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

public class UserSevice implements IUserSevice {
	private IUserRepository userRepository;

	public UserSevice() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
	}

	@Override
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		return userRepository.isLogin(email, password);
	}

	@Override
	public Boolean isAdmin(User user) {
		// TODO Auto-generated method stub
		return userRepository.isAdmin(user);
	}

	@Override
	public List<User> getlistuser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getlistuser();
	}

}
