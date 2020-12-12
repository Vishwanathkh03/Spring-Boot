/**
 * 
 */
package org.hatgundi.springboot.app.service;

import java.util.List;

import org.hatgundi.springboot.app.entity.Employee;

/**
 * @author Vishwanath Hatgundi
 *
 */
public interface EmployeeService {

	public Employee getEmployeeById(String employeeId);

	public Iterable<Employee> getEmployees();

	public Employee createEmployee(Employee employee);
	
	public Iterable<Employee> createEmployees(List<Employee> employees);

	public Employee updateEmployee(String employeeId, Employee employee);

	public boolean deleteEmployeeById(String employeeId);

}
