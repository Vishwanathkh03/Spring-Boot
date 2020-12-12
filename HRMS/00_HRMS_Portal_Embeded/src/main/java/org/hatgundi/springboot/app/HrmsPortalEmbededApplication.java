package org.hatgundi.springboot.app;

import java.util.Arrays;
import java.util.List;

import org.hatgundi.springboot.app.entity.Employee;
import org.hatgundi.springboot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrmsPortalEmbededApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService empService;

	public static void main(String[] args) {
		SpringApplication.run(HrmsPortalEmbededApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		List<Employee> employees = Arrays.asList(
				new Employee("Admin", "", "", "admin@gmail.com", Boolean.TRUE),
				new Employee("Vishwa", "K", "Hatgundi", "Vishwakh@gmail.com", Boolean.TRUE));
		Iterable<Employee> savedEmployees = empService.createEmployees(employees);
		for (Employee emp : savedEmployees) {
			System.out.println(emp.toString());
		}
	}

}
