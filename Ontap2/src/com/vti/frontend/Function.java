package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
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
					getMenuEmployee();
				}
			} else {
				System.out.println("Thong tin ban nhap ko dung!");
			}
		}
	}

	private void getMenuEmployee() throws ClassNotFoundException, SQLException {
		System.out.println("Moi ban chon chuc nang cua Employee");
	}

	private void getListAccount() throws ClassNotFoundException, SQLException {
		List<Account> list = new ArrayList<Account>();
		list = accountController.getlistAccount();

		String leftAlignFormat = "| %-2d | %-25s | %-21s |%n";
		System.out.format("+--------------------------------------------------------+%n");
		System.out.format("+            DANH SÁCH Account TRÊN HỆ THỐNG                +%n");
		System.out.format("+----+---------------------------+-----------------------+%n");
		System.out.format("|ID  | FullName                  |   Email               |%n");
		System.out.format("+----+---------------------------+-----------------------+%n");
		for (Account account : list) {
			System.out.format(leftAlignFormat, account.getId(), account.getFullName(), account.getEmail());
		}
		System.out.format("+----+---------------------------+-----------------------+%n");
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