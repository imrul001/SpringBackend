package me.hasan.tutorial.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import me.hasan.tutorial.model.Employee;

@Component
public class SimpleSpringDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getCountEmployee() {
		String sql = "SELECT * FROM employee";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		int count = 0;
		while (rowSet.next()) {
			count++;
		}
		return count;
	}

	public String getEmployeeName(int id) {
		String sql = "select name from employee where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
	}

	public Employee getEmployeeForID(int id) {
		String sql = "select * from employee where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new EmployeeMapper());
	}

	public List<Employee> getEmployees() {
		String sql = "select * from employee";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	public void InsertEmployee(Employee employee) {
		String sql = "INSERT INTO employee (id, name, position, salary) values(?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary() });

	}

	public static final class EmployeeMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPosition(resultSet.getString("position"));
			employee.setSalary(resultSet.getInt("salary"));
			return employee;
		}

	}
}
