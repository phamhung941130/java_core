package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class AccountDAO {
	private jdbcUltis jdbc;

	public AccountDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String slqSelect = "SELECT * FROM account ORDER BY AccountID";
		ResultSet resultSet = jdbc.executeQuery(slqSelect);
		List<Account> listAcc = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUserName(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentDAO depDao = new DepartmentDAO();
			Department dep = depDao.getDepartmentById(resultSet.getInt(5));
			acc.setDepartment(dep);

			PositionDAO posDao = new PositionDAO();
			Position pos = posDao.getPosByID(resultSet.getInt(6));
			acc.setPosition(pos);

			LocalDate lcd = resultSet.getDate(7).toLocalDate();
			acc.setCreateDate(lcd);

			listAcc.add(acc);

		}

		return listAcc;

	}

	public Account getAccByID(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM account WHERE AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUserName(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentDAO depDao = new DepartmentDAO();
			Department dep = depDao.getDepartmentById(resultSet.getInt(5));
			acc.setDepartment(dep);

			PositionDAO posDao = new PositionDAO();
			acc.setPosition(posDao.getPosByID(resultSet.getInt(6)));

			LocalDate lcd = LocalDate.parse(resultSet.getDate(7).toString());
			acc.setCreateDate(lcd);
			return acc;

		} else {
			return null;
		}

	}

	public boolean isAccountNameExists(String name) throws ClassNotFoundException, SQLException {
		String sqlNameCheck = "SELECT * FROM account WHERE Username = ?";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlNameCheck);
		pStatement.setString(1, name);
		ResultSet resultSet = pStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean createAccount(String email, String userName, String fullName, int depid, int posid)
			throws ClassNotFoundException, SQLException {
		String sqlCreAcc = "INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?,?,?,now());";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlCreAcc);
		pStatement.setString(1, email);
		pStatement.setString(2, userName);
		pStatement.setString(3, fullName);
		pStatement.setInt(4, depid);
		pStatement.setInt(5, posid);

		int resultSet = pStatement.executeUpdate();
		if (resultSet == 1) {

			return true;
		} else {

			return false;
		}

	}

	public boolean updateByEmail(String email, int accid) throws ClassNotFoundException, SQLException {
		String sqlString = "UPDATE account SET Email = ? WHERE (AccountID = ?);";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlString);
		pStatement.setString(1, email);
		pStatement.setInt(2, accid);
		int result = pStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean updateByUsername(String username, int accid) throws ClassNotFoundException, SQLException {
		String sqlString = "UPDATE account SET Username = ? WHERE (AccountID = ?);";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlString);
		pStatement.setString(1, username);
		pStatement.setInt(2, accid);
		int result = pStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean updateByFullname(String fullname, int accid) throws ClassNotFoundException, SQLException {
		String sqlString = "UPDATE account SET Fullname = ? WHERE (AccountID = ?);";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlString);
		pStatement.setString(1, fullname);
		pStatement.setInt(2, accid);
		int result = pStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateByDepID(int depid, int accid) throws ClassNotFoundException, SQLException {
		String sqlString = "UPDATE account SET DepartmentID = ? WHERE (AccountID = ?);";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlString);
		pStatement.setInt(1, depid);
		pStatement.setInt(2, accid);
		int result = pStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean updateByPosID(int posid, int accid) throws ClassNotFoundException, SQLException {
		String sqlString = "UPDATE account SET PositionID = ? WHERE (AccountID = ?);";
		PreparedStatement pStatement = jdbc.createPrepareStatement(sqlString);
		pStatement.setInt(1, posid);
		pStatement.setInt(2, accid);
		int result = pStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}
}