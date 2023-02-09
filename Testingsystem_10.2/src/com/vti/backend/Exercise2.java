package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.DAO.DepartmentDAO;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class Exercise2 {
	private jdbcUltis jdbc;
	private DepartmentDAO departmentDAO;

	public Exercise2() throws FileNotFoundException, IOException {
		super();
		departmentDAO = new DepartmentDAO();
	}

	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println("In ra danh sach cac Department co tren he thong");
		List<Department> listDepartments = departmentDAO.getListDepartment();
		System.out.println("+--------+----------------------+");
		System.out.println("|   ID   |          Name        |");
		System.out.println("+--------+----------------------+");

		for (Department department : listDepartments) {
			System.out.format("|%-8d|%-22s|%n", department.getId(), department.getName());
		}

	}

	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("moi ban nhap vao ID");
		int idSearch = ScannerUltis.inputIntPositive();
		Department departmentSearch = departmentDAO.getDepartmentById(idSearch);
		if (departmentSearch != null) {
			System.out.println("+--------+----------------------+");
			System.out.println("|   ID   |          Name        |");
			System.out.println("+--------+----------------------+");

			System.out.format("|%-8d|%-22s|%n", departmentSearch.getId(), departmentSearch.getName());

		} else {
			System.out.println("phong ban ko ton tai!");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException {
		System.out.println("moi ban nhap ten phong ban can tao");
		String depnamenew = ScannerUltis.inputString();
		boolean departmentNew = departmentDAO.getDepartmentNew(depnamenew);
		if (departmentNew == true) {
			question1();

		} else {
			System.out.println("tao ko thanh cong!");
		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("moi ban nhap vao ten Department can kiem tra: ");
		String namecheck = ScannerUltis.inputString();
		boolean namecheckDepartment = departmentDAO.isDepartmentNameExists(namecheck);
		if (namecheckDepartment) {
			System.out.println("Department ban nhap co tren he thong");
		} else {
			System.out.println("Department ban nhap ko co tren he thong");
		}
	}

	public void question6() throws ClassNotFoundException, SQLException {
		System.out.println("Moi ban nhap vao ID can Update: ");
		int idUpdate = ScannerUltis.inputIntPositive();
		System.out.println("Moi ban nhap vao Name can Update: ");
		String nameUpdate = ScannerUltis.inputString();
		boolean updateDev = departmentDAO.update(idUpdate, nameUpdate);
		if (updateDev == true) {
			System.out.println("Update thanh cong!");
			question1();
		} else {
			System.out.println("Update ko thanh cong!");
		}
	}

	public void question7() throws ClassNotFoundException, SQLException {
		System.out.println("moi ban nhap vao ID can xoa: ");
		int idDelete = ScannerUltis.inputIntPositive();
		boolean deleteDev = departmentDAO.deleteDep(idDelete);
		if (deleteDev == true) {
			System.out.println("Delete Thanh Cong");
			question1();
		} else {
			System.out.println("Delete Khong Thanh Cong!");
		}
	}

}
