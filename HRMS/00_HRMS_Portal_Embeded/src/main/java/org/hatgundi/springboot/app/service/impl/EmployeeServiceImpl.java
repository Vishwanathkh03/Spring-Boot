/**
 * 
 */
package org.hatgundi.springboot.app.service.impl;

import java.util.List;

import org.hatgundi.springboot.app.dao.EmployeeDAO;
import org.hatgundi.springboot.app.entity.Employee;
import org.hatgundi.springboot.app.service.EmployeeService;
import org.hatgundi.springboot.app.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vishwanath Hatgundi
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private Utils util;

	@Override
	public Employee getEmployeeById(String employeeId) {
		return employeeDAO.findByEmployeeId(employeeId);
	}

	@Override
	public Iterable<Employee> getEmployees() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employee.setEmployeeId(util.generateUserId(7));
		return employeeDAO.save(employee);
	}

	@Override
	public Employee updateEmployee(String employeeId, Employee employee) {
		Employee employeeDB = getEmployeeById(employeeId);
		BeanUtils.copyProperties(employee, employeeDB);
		return createEmployee(employeeDB);
	}

	@Override
	public boolean deleteEmployeeById(String employeeId) {
		Employee employeeDB = getEmployeeById(employeeId);
		employeeDB.setActive(Boolean.FALSE);
		return true;
	}

	@Override
	public Iterable<Employee> createEmployees(List<Employee> employees) {
		for(Employee emp: employees) {
			emp.setEmployeeId(util.generateUserId(7));
		}
		return employeeDAO.saveAll(employees);
	}

}
