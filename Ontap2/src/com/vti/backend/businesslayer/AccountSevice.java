package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Manager;
import com.vti.entity.Project;

public class AccountSevice implements IAccountSevice {
	private IAccountRepository accountRepository;

	public AccountSevice() throws FileNotFoundException, IOException {
		accountRepository = new AccountRepository();
	}

	@Override
	public Account isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		return accountRepository.isLogin(email, password);
	}

	@Override
	public Boolean isManager(Account account) {
		return accountRepository.isManager(account);
	}

	@Override
	public List<Account> getlistAccount() throws ClassNotFoundException, SQLException {
		return accountRepository.getlistAccount();
	}

	@Override
	public Project getProjectById(int id) throws ClassNotFoundException, SQLException {
		return accountRepository.getProjectById(id);

	}

	@Override
	public List<Manager> managerOfProject() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.managerOfProject();
	}
}
