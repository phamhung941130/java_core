package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserSevice {
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException;

	public Boolean isAdmin(User user);

	public Boolean createUser(User user) throws SQLException, ClassNotFoundException;

	public List<User> getUserByProjectId(short projectID) throws SQLException, ClassNotFoundException;
}
