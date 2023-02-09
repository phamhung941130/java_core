package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

public class UserSevice implements IUserSevice {
	private IUserRepository repository;

	public UserSevice() throws FileNotFoundException, IOException {
		repository = new UserRepository();
	}

	@Override
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {

		return repository.isLogin(email, password);
	}

	@Override
	public Boolean isAdmin(User user) {
		return repository.isAdmin(user);
	}

	@Override
	public Boolean createUser(User user) throws SQLException, ClassNotFoundException {

		return repository.createUser(user);
	}

	@Override
	public List<User> getUserByProjectId(short projectID) throws SQLException, ClassNotFoundException {
		return repository.getUserByProjectId(projectID);

	}

}
