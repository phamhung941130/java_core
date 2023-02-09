package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
					System.out.println("Ban la ADMIN, Mời tạo user mới ");
					create_user();
					return;
				} else {
					System.out.println("DS User theo Project");
					getListUser_ByProjectID();
					return;
				}
			} else {
				System.out.println("Thong tin ban nhap ko dung!");
			}
		}
	}

	private void getListUser_ByProjectID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID Project: ");
		short projectID = (short) ScannerUltis.inputIntPositive();
		List<User> list = userController.getUserByProjectId(projectID);
		String leftAlignFormat = "| %2d | %17s | %23s | %11s | %11s |%n";
		System.out.printf("+----+-------------------+-------------------------+-------------+-------------+%n");
		System.out.format("|ID  |    Fullname       |    Email                | Password    |     Role    |%n");
		System.out.format("+----+-------------------+-------------------------+-------------+-------------+%n");

		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail(), user.getPassword(),
					user.getRole());
			System.out.format("+----+-------------------+-------------------------+-------------+-------------+%n");
		}
	}

	public void create_user() throws ClassNotFoundException, SQLException {
		System.out.println("Chuc nang tao moi User ");
		User userNew = new User();

		System.out.println("Moi ban nhap fullName: ");
		String fullName = ScannerUltis.inputString();
		userNew.setFullName(fullName);

		System.out.println("Moi ban nhap Email: ");
		String emailNew = ScannerUltis.inputEmail();
		userNew.setEmail(emailNew);

		Boolean result = userController.createUser(userNew);
		if (result) {
			System.out.println("Tao moi thanh cong!");
		} else {
			System.out.println("Tao moi khong thanh cong!");
		}

	}

}
