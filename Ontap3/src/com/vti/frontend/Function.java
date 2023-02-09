package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.entity.Account.Role;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.utils.ScannerUltis;

public class Function {
	private AccountController accountController;

	public Function() throws FileNotFoundException, IOException {
		accountController = new AccountController();
	}

	public void getLogin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Moi ban Login he thong");
			System.out.println("Moi ban nhap vao Email: ");
			String emailInput = ScannerUltis.inputEmail();

			System.out.println("Moi ban nhap vao Password: ");
			String passwordInput = ScannerUltis.inputPassword();
			Account account = accountController.isLogin(emailInput, passwordInput);
			if (account != null) {
				System.out.println("Login thanh cong!");
				if (accountController.isManager(account)) {
					getMenuManager();
				} else {
					if (accountController.isAdmin(account)) {
						adminCreate();
					} else {
						showUserByProjectName();
					}
				}
			} else {
				System.out.println("Thong tin ban nhap ko dung!");
			}
		}
	}

	private void adminCreate() throws ClassNotFoundException, SQLException {
		System.out.println("Moi Ban Tao Moi 1 Account");
		System.out.println("Nhap vao FullName: ");
		String fullname = ScannerUltis.inputString();

		System.out.println("Nhap vao Email:");
		String email = ScannerUltis.inputEmail();

		String role = getRole();

		boolean result = accountController.createAccount(fullname, email, role);
		if (result) {
			System.out.println("Tao moi Account thanh cong!");
			getListAccount();
		} else {
			System.out.println("Tao moi Account ko thanh cong!");
		}
	}

	private String getRole() {
		System.out.println("Nhap vao Role: 1.Admin, 2.Manager, 3.Employee");
		while (true) {

			switch (geti()) {
			case 1:
				return String.valueOf(Role.ADMIN);
			case 2:
				return String.valueOf(Role.MANAGER);
			case 3:
				return String.valueOf(Role.EMPLOYEE);
			}
		}
	}

	private int geti() {
		while (true) {
			int i = ScannerUltis.inputIntPositive();
			if (i == 1 || i == 2 || i == 3) {
				return i;
			} else {
				System.out.println("Nhap lai: ");
			}
		}
	}

	private void showUserByProjectName() throws ClassNotFoundException, SQLException {
		System.out.println("------Chuc nang tim user theo ten Project----Employee-------");
		System.out.println("Moi ban nhap vao ten Project: ");
		String nameString = ScannerUltis.inputString();
		Account account = accountController.userByProjectName(nameString);
		if (account != null) {
			String leftAlignFormat = "| %-2d | %-13s | %-21s | %-12s |%n";
			System.out.format("+-----------------------------------------------------------+%n");
			System.out.format("+                       User ban can tim la                 +%n");
			System.out.format("+----+---------------+-----------------------+--------------+%n");
			System.out.format("|ID  | FullName      |   Email               | Role         |%n");
			System.out.format("+----+---------------+-----------------------+--------------+%n");
			System.out.format(leftAlignFormat, account.getId(), account.getFullName(), account.getEmail(),
					account.getRole());
			System.out.format("+----+---------------------------+--------------------------+%n");

		} else {
			System.out.println("Co loi xay ra! Hay kiem tra lai.");
		}
	}

	private void getListAccount() throws ClassNotFoundException, SQLException {
		List<Account> list = new ArrayList<Account>();
		list = accountController.getlistAccount();

		String leftAlignFormat = "| %-2d | %-13s | %-21s | %-12s|%n";
		System.out.format("+-----------------------------------------------------------+%n");
		System.out.format("+            DANH SÁCH Account TRÊN HỆ THỐNG                +%n");
		System.out.format("+----+---------------+-----------------------+--------------+%n");
		System.out.format("|ID  | FullName      |   Email               | Role         |%n");
		System.out.format("+----+---------------+-----------------------+--------------+%n");
		for (Account account : list) {
			System.out.format(leftAlignFormat, account.getId(), account.getFullName(), account.getEmail(),
					account.getRole());
		}
		System.out.format("+----+---------------------------+--------------------------+%n");
	}

	private void getMenuManager() throws ClassNotFoundException, SQLException {
		System.out.println("-------------------Manager----------------------");
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tim project theo ID.");
			System.out.format(leftAlignFormat, "2. Lấy ra tất cả các Manager của Project.");
			System.out.format(leftAlignFormat, "3. Thoát chương trình.");
			System.out.format("+--------------------------------------------------------------------------+%n");

			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				showProjectById();
				break;
			case 2:
				showManagerByProject();
				break;

			default:
				System.out.println("Nhập lại:");

				break;
			}
		}
	}

	private void showProjectById() throws ClassNotFoundException, SQLException {
		System.out.println("Moi ban nhap vao ProiectID muon xem: ");
		int id = ScannerUltis.inputIntPositive();
		Project project = accountController.getProjectById(id);
		if (project != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s |%n";
			System.out.format("+----+-----------------------+-----------------+-----------------------+%n");
			System.out.format("|ID  | Name                  | TeamSize        |   AccountID           |%n");
			System.out.format("+----+-----------------------+-----------------+-----------------------+%n");

			System.out.format(leftAlignFormat, project.getId(), project.getName(), project.getTeamSize(),
					project.getAccountID());

			System.out.format("+----+-----------------------+-----------------+-----------------------+%n");

		} else {
			System.out.println("Không tồn tại Project này trên HT!");
		}

	}

	private void showManagerByProject() throws ClassNotFoundException, SQLException {
		List<Manager> list = new ArrayList<Manager>();
		list = accountController.managerOfProject();

		String leftAlignFormat = "| %-2d | %-25s | %-21s | %-16s | %-11d |%n";
		System.out.format("+--------------------------------------------------------+%n");
		System.out.format("+            DANH SÁCH Account TRÊN HỆ THỐNG                +%n");
		System.out.format(
				"+----+---------------------------+-----------------------+------------------+-------------+%n");
		System.out.format(
				"|ID  | FullName                  |   Email               |   ProjectName    | ExpInYear   | %n");
		System.out.format(
				"+----+---------------------------+-----------------------+------------------+-------------+%n");
		for (Manager manager : list) {
			System.out.format(leftAlignFormat, manager.getId(), manager.getFullName(), manager.getEmail(),
					manager.getProjectName(), manager.getExpInYear());
		}
		System.out.format(
				"+----+---------------------------+-----------------------+------------------+-------------+%n");
	}

}
