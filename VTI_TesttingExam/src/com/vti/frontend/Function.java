package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUltis;

public class Function {
	private UserController userController;

	public Function() throws FileNotFoundException, IOException {
		userController = new UserController();
	}

	public void islogin() throws ClassNotFoundException, SQLException {
		System.out.println("Moi ban Login");
		System.out.println("Moi ban nhap vao email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Moi ban nhap vao password: ");
		String password = ScannerUltis.inputPassword();
		User user = userController.isLogin(email, password);
		if (user != null) {
			if (userController.isAdmin(user)) {
				getMenuAdmin();
			} else {
				getMenuEmployee();
			}
		} else {
			System.out.println("Co loi xay ra, vui long kiem tra lai!");
		}
	}

	private void getMenuEmployee() {
		String leftAlignFormat = "|%-72s|%n";
		System.out.println("+-----------------------Moi ban chon chuc nang-----------------------------+");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|                            Choose                                        |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. Danh sách User trên hệ thống");
		System.out.format(leftAlignFormat, "2. Tìm User theo ID");
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
			System.out.println("nhap lai: ");
			break;
		}
	}

	private void getMenuAdmin() {
		// TODO Auto-generated method stub

	}
}
