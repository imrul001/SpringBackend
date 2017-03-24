package me.hasan.tutorial.service;

import java.sql.SQLException;

import me.hasan.tutorial.dao.SimpleDao;

public class ServiceImpl {
	SimpleDao dao = new SimpleDao();

	public int getEmployeeCount() throws ClassNotFoundException, SQLException {
		return dao.getEmployeeCount();
	}

	public void getEmployee(int id) throws ClassNotFoundException, SQLException {
		dao.getEmployee(id);
	}

	public void getAllEmployee() throws ClassNotFoundException, SQLException {
		dao.getAllEmployees();
	}

}
