package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.User;

public interface IUserRepository {
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException;

	public boolean isAdmin(User user);
}
