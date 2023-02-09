package com.vti.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Staff;
import com.vti.entity.Staff.Gender;
import com.vti.entity.Worker;

public class Exercise5 {
	private Scanner scanner;
	private ArrayList<Staff> listStaff;

	public Exercise5() {
		scanner = new Scanner(System.in);
		listStaff = new ArrayList<Staff>();
	}

	public void Question2() {
		while (true) {

			System.out.println("+--------------------------------------------------------------------------+");

			System.out.printf("|%-74s|%n", "                         chao mung ban den chuong trinh QLNV");
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.printf("|%-74s|%n", "1.Them moi nhan vien");
			System.out.printf("|%-74s|%n", "2.Tim kiem theo ho ten");
			System.out.printf("|%-74s|%n", "3.Hien thi danh sach can bo");
			System.out.printf("|%-74s|%n", "4.Xoa can bo theo ten");
			System.out.printf("|%-74s|%n", "5.Thoat khoi chuong trinh");

			System.out.println("+--------------------------------------------------------------------------+");

			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				addStaff();
				break;
			case 2:
				seachrByName();
				break;
			case 3:
				printInforAllStaff();
				break;
			case 4:
				dellByName();
				break;
			case 5:
				return;
			default:
				System.out.println("moi chon lai!");
				break;
			}

		}
	}

	private void dellByName() {
		System.out.println("moi ban nhap vao ten staff muon xoa: ");
		String nameDell = scanner.next();
		Iterator<Staff> iteratordell = listStaff.iterator();
		while (iteratordell.hasNext()) {
			Staff staff = iteratordell.next();
			if (staff.getName().equals(nameDell)) {
				iteratordell.remove();
			} else {
				System.out.println("ko co staff nay!");
			}
			return;
		}
	}

	private void seachrByName() {
		System.out.println("Tim kiem theo ten");
		System.out.println("Moi ban nhap vao ten can tim");
		String nameSearch = scanner.next();
		System.out.println("thong tin chi tiet cua nhan vien can tim la");
		for (Staff staff : listStaff) {
			if (staff.getName().equals(nameSearch)) {
				System.out.println(staff.toString());

			} else {
				System.out.println("ko co nhan vien can tim!");
			}
		}
	}

	private void printInforAllStaff() {
		System.out.println("thong tin nhan vien tren he thong");
		for (Staff staff : listStaff) {
			System.out.println(staff.toString());
		}
	}

	private void addStaff() {
		while (true) {

			System.out.println("+--------------------------------------------------------------------------+");

			System.out.printf("|%-74s|%n", "                         Moi ban chon doi tuong muon them");
			System.out.println("+--------------------------------------------------------------------------+");
			System.out.printf("|%-74s|%n", "1.Them Enginerr");
			System.out.printf("|%-74s|%n", "2.Them Worker");
			System.out.printf("|%-74s|%n", "3.Them Employer");
			System.out.printf("|%-74s|%n", "4.exit");

			System.out.println("+--------------------------------------------------------------------------+");

			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				addEngineer();
				break;
			case 2:
				addWorker();
				break;
			case 3:
				addEmployee();
				break;
			case 4:

				return;
			}

		}

	}

	private void addEmployee() {
		System.out.println("Moi ban nhap vao mot Employee");
		System.out.println("Moi ban nhap vao ten: ");
		String name = scanner.next();
		System.out.println("Moi ban nhap vao tuoi: ");
		int age = scanner.nextInt();
		System.out.println("Moi ban chon gioi tinh: 1.Male, 2.Female, 3.Unkown");
		int chooseGender = scanner.nextInt();
		Gender gender = Gender.MALE;
		switch (chooseGender) {
		case 1:
			gender = Gender.MALE;
			break;

		case 2:
			gender = Gender.FEMALE;
			break;
		case 3:
			gender = Gender.UNKNOW;
			break;
		}
		System.out.println("Moi ban nhap vao dia chi: ");
		String address = scanner.next();
		System.out.println("moi ban nhap vao Task cua Employee: ");
		String task = scanner.next();
		Staff employee = new Employee(name, age, gender, address, task);

		listStaff.add(employee);

	}

	private void addWorker() {
		System.out.println("Moi ban nhap vao mot Worker");
		System.out.println("Moi ban nhap vao ten: ");
		String name = scanner.next();
		System.out.println("Moi ban nhap vao tuoi: ");
		int age = scanner.nextInt();
		System.out.println("Moi ban chon gioi tinh: 1.Male, 2.Female, 3.Unkown");
		int chooseGender = scanner.nextInt();
		Gender gender = Gender.MALE;
		switch (chooseGender) {
		case 1:
			gender = Gender.MALE;
			break;

		case 2:
			gender = Gender.FEMALE;
			break;
		case 3:
			gender = Gender.UNKNOW;
			break;
		}
		System.out.println("Moi ban nhap vao dia chi: ");
		String address = scanner.next();
		System.out.println("moi ban nhap vao bac cua Worker: ");
		int rank = scanner.nextInt();
		Staff worker = new Worker(name, age, gender, address, rank);

		listStaff.add(worker);

	}

	private void addEngineer() {
		System.out.println("Moi ban nhap vao mot Engineer");
		System.out.println("Moi ban nhap vao ten: ");
		String name = scanner.next();
		System.out.println("Moi ban nhap vao tuoi: ");
		int age = scanner.nextInt();
		System.out.println("Moi ban chon gioi tinh: 1.Male, 2.Female, 3.Unkown");
		int chooseGender = scanner.nextInt();
		Gender gender = Gender.MALE;
		switch (chooseGender) {
		case 1:
			gender = Gender.MALE;
			break;

		case 2:
			gender = Gender.FEMALE;
			break;
		case 3:
			gender = Gender.UNKNOW;
			break;
		}
		System.out.println("Moi ban nhap vao dia chi: ");
		String address = scanner.next();
		System.out.println("moi ban nhap vao chuyen nganh: ");
		String speccialized = scanner.next();
		Staff engineer = new Engineer(name, age, gender, address, speccialized);

		listStaff.add(engineer);

	}
}
