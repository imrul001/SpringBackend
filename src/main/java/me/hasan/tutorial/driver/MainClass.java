package me.hasan.tutorial.driver;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.hasan.tutorial.dao.SimpleSpringSupportDao;
import me.hasan.tutorial.model.Employee;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// SimpleSpringDao dao = context.getBean("simpleSpringDao",
		// SimpleSpringDao.class);
		SimpleSpringSupportDao dao = context.getBean("SimpleSpringSupportDao", SimpleSpringSupportDao.class);

		// dao.InsertEmployee(new Employee(4, "Pok", "AVP", 70000));
		// System.out.println(dao.getCountEmployee());

		List<Employee> employees = dao.getEmployees();
		for (Employee emp : employees) {
			System.out.println(emp.getName());
			System.out.println(emp.getPosition());
			System.out.println();
		}

	}

}
