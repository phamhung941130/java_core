package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Manager;
import com.vti.entity.Project;

public interface IAccountRepository {
	public Account isLogin(String email, String password) throws ClassNotFoundException, SQLException;

	public Boolean isManager(Account account);

	public List<Account> getlistAccount() throws ClassNotFoundException, SQLException;

	public Project getProjectById(int id) throws ClassNotFoundException, SQLException;

	public List<Manager> managerOfProject() throws ClassNotFoundException, SQLException;

	public Boolean isAdmin(Account account);

	public boolean createAccount(String fullname, String email, String role)
			throws ClassNotFoundException, SQLException;

	public Account userByProjectName(String nameProject) throws ClassNotFoundException, SQLException;
}
