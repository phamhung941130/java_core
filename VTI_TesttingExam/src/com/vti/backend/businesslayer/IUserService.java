package com.vti.backend.businesslayer;

import java.sql.SQLException;

import com.vti.entity.User;

public interface IUserService {
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException;

	public boolean isAdmin(User user);
}
