package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUltis;

public class Function {
	private UserController userController;

	public Function() throws FileNotFoundException, IOException {
		userController = new UserController();
	}

	public void getLogin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Moi ban Login he thong");
			System.out.println("Moi ban nhap vao Email: ");
			String emailInput = ScannerUltis.inputEmail();

			System.out.println("Moi ban nhap vao Password: ");
			String passwordInput = ScannerUltis.inputPassword();
			User user = userController.isLogin(emailInput, passwordInput);
			if (user != null) {
				System.out.println("Login thanh cong!");
				if (userController.isAdmin(user)) {
					getMenuAdmin();
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
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách User trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm User theo ID");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Danh sách User trên hệ thống");
				getListUser();
				break;
			case 2:
				System.out.println("Tìm User theo ID");
				getUserById();
				break;
			case 3:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}

	private void getUserById() {
		// TODO Auto-generated method stub

	}

	private void getListUser() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<User>();
		list = userController.getlistuser();

		String leftAlignFormat = "| %-2d | %-25s | %-21s |%n";
		System.out.format("+--------------------------------------------------------+%n");
		System.out.format("+            DANH SÁCH USER TRÊN HỆ THỐNG                +%n");
		System.out.format("+----+---------------------------+-----------------------+%n");
		System.out.format("|ID  | FullName                  |   Email               |%n");
		System.out.format("+----+---------------------------+-----------------------+%n");
		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail());
		}
		System.out.format("+----+---------------------------+-----------------------+%n");
	}

	private void getMenuAdmin() {
		System.out.println("Moi ban chon chuc nang Admin");
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tạo Employee mới");
			System.out.format(leftAlignFormat, "2. Xóa Employee theo Id");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:

				break;
			case 2:

				break;
			case 3:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}
}
