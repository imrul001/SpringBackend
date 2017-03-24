package me.hasan.tutorial.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import me.hasan.tutorial.dao.SimpleSpringDao.EmployeeMapper;
import me.hasan.tutorial.model.Employee;

public class SimpleSpringSupportDao extends JdbcDaoSupport {

	public List<Employee> getEmployees() {
		String sql = "select * from employee";
		return this.getJdbcTemplate().query(sql, new EmployeeMapper());
	}
}
