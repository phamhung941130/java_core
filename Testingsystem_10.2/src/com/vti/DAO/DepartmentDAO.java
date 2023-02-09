package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.jdbcUltis;

public class DepartmentDAO {
	private jdbcUltis jdbc;

	public DepartmentDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
//		Ket noi toi DB, lay ra bang Department ==> chuyen ve listDepartment
		String slqSelec = "SELECT * FROM department ORDER BY DepartmentID";
		ResultSet resultSet = jdbc.executeQuery(slqSelec);
		List<Department> listDep = new ArrayList<Department>();
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));
			listDep.add(department);
		}
		return listDep;

	}

	public Department getDepartmentById(int idSearch) throws ClassNotFoundException, SQLException {
		String sqlGetById = "SELECT * FROM department WHERE DepartmentID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlGetById);
		preparedStatement.setInt(1, idSearch);

		ResultSet resultSetDepartment = preparedStatement.executeQuery();
		if (resultSetDepartment.next()) {
			Department department = new Department();
			department.setId(resultSetDepartment.getInt(1));
			department.setName(resultSetDepartment.getString(2));
			return department;
		} else {
			System.out.println("ko co ID nay!");
			return null;
		}

	}

	public boolean getDepartmentNew(String depnamenew) throws ClassNotFoundException, SQLException {
		String sqlGetDepNew = "INSERT INTO department(DepartmentName) VALUES (?);";
		PreparedStatement getDepNewStatement = jdbc.createPrepareStatement(sqlGetDepNew);
		getDepNewStatement.setString(1, depnamenew);
		int resultnewname = getDepNewStatement.executeUpdate();
		if (resultnewname == 1) {
			return true;

		} else {
			return false;
		}

	}

	public boolean isDepartmentNameExists(String namecheck) throws SQLException, ClassNotFoundException {
		String sqlNameCheck = "SELECT * FROM department WHERE DepartmentName =(?)";
		PreparedStatement nameCheckStatement = jdbc.createPrepareStatement(sqlNameCheck);
		nameCheckStatement.setString(1, namecheck);
		ResultSet resultcheck = nameCheckStatement.executeQuery();
		if (resultcheck.next() == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean update(int idUpdate, String nameUpdate) throws ClassNotFoundException, SQLException {
		Department department = getDepartmentById(idUpdate);
		if (department == null) {
			return false;
		} else {
			String sqlUpdateDep = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
			PreparedStatement updateDepStatement = jdbc.createPrepareStatement(sqlUpdateDep);
			updateDepStatement.setString(1, nameUpdate);
			updateDepStatement.setInt(2, idUpdate);
			int resultUpdateDep = updateDepStatement.executeUpdate();
			if (resultUpdateDep == 1) {
				return true;

			} else {
				return false;
			}
		}

	}

	public boolean deleteDep(int idDelete) throws ClassNotFoundException, SQLException {
		Department depCheckDel = getDepartmentById(idDelete);
		if (depCheckDel == null) {
			return false;
		} else {
			String sqlDelete = "DELETE FROM department WHERE (DepartmentID = ?);";
			PreparedStatement delStatement = jdbc.createPrepareStatement(sqlDelete);
			delStatement.setInt(1, idDelete);
			int result = delStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
}
