package com.vti.backend.datalayer;

import com.vti.entity.Project;
import com.vti.entity.User;
import com.vti.entity.User.Role;
import com.vti.utils.jdbcUltis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private jdbcUltis jdbc;

    public UserRepository() throws FileNotFoundException, IOException {
        jdbc = new jdbcUltis();
    }

    @Override
    public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {
        try {
            String sql = "SELECT * FROM User WHERE Email=? AND Password =?;";
            PreparedStatement pStatement = jdbc.createPrepareStatement(sql);
            pStatement.setString(1, email);
            pStatement.setString(2, password);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFullName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));

                Project project = new Project();
                project = getProjectById((short) resultSet.getInt(7));
                user.setProject(project);

                Role role = Role.valueOf(resultSet.getString(8).toUpperCase());
                user.setRole(role);
                return user;

            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Boolean isAdmin(User user) {
        if (user.getRole() == Role.ADMIN) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getUserByProjectId(short projectID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM `User` WHERE ProjectId = ?;";
        PreparedStatement pStatement = jdbc.createPrepareStatement(sql);
        pStatement.setInt(1, projectID);
        ResultSet resultSet = pStatement.executeQuery();
        List<User> list = new ArrayList<User>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setFullName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));

            Role role = Role.valueOf(resultSet.getString(8));
            user.setRole(role);

            list.add(user);
        }
        return list;
    }

    @Override
    public Boolean createUser(User userNew) throws SQLException, ClassNotFoundException {
        String sqlCreate = "INSERT INTO `User`  (   Fullname,			Email,			 Password,	ExpInYear,	ProSkill	,	ProjectId,			Role	  ) \r\n"
                + "VALUES																								\r\n"
                + "									(	? ,					? ,	 				'123456',			null,		null,				null,		null );";
        PreparedStatement preparedStatementInsertUser = jdbc.createPrepareStatement(sqlCreate);
        preparedStatementInsertUser.setString(1, userNew.getFullName());
        preparedStatementInsertUser.setString(2, userNew.getEmail());

        int result = preparedStatementInsertUser.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Project getProjectById(short id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM `User` WHERE ProjectId = ?;";
        PreparedStatement preparedStatementInsertUser = jdbc.createPrepareStatement(sql);
        preparedStatementInsertUser.setInt(1, id);
        ResultSet resultSet = preparedStatementInsertUser.executeQuery();
        if (resultSet.next()) {
            Project project = new Project();
            project.setId(resultSet.getInt(1));
            project.setName(resultSet.getString(2));
            return project;
        }
        return null;
    }

}