package me.hasan.tutorial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class SimpleDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "adminadmin");
		return conn;
	}

	public int getEmployeeCount() throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		String s1 = "select * from employee";
		Statement statement = (Statement) conn.createStatement();
		conn.close();
		ResultSet rs = statement.executeQuery(s1);
		int count = 0;
		while (rs.next()) {
			count++;
		}
		return count;
	}

	public void getEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String s1 = "SELECT * FROM employee WHERE id = ?";
		PreparedStatement statement = conn.prepareStatement(s1);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("employee id " + resultSet.getInt(1));
			System.out.println("employee name " + resultSet.getString(2));
			System.out.println("employee position " + resultSet.getString(3));
			System.out.println("employee salary " + resultSet.getInt(4));
		}
		conn.close();
	}

	public void getAllEmployees() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String s1 = "SELECT * FROM employee";
		PreparedStatement statement = conn.prepareStatement(s1);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("employee id " + resultSet.getInt(1));
			System.out.println("employee name " + resultSet.getString(2));
			System.out.println("employee position " + resultSet.getString(3));
			System.out.println("employee salary " + resultSet.getInt(4));
		}
		conn.close();
	}
}
