/**
 * 
 */
package org.hatgundi.springboot.app.controller;

import org.hatgundi.springboot.app.entity.Employee;
import org.hatgundi.springboot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vishwanath Hatgundi
 *
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") String employeeId) {
		return empService.getEmployeeById(employeeId);
	}

	@GetMapping
	public Iterable<Employee> getEmployees() {
		return empService.getEmployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.createEmployee(employee);
	}

	@PutMapping("/{employeeId}")
	public Employee updateEmployee(@PathVariable("employeeId") String employeeId, @RequestBody Employee employee) {
		return empService.updateEmployee(employeeId, employee);
	}

	@DeleteMapping
	public Boolean deleteEmployee(@PathVariable("employeeId") String employeeId) {
		return empService.deleteEmployeeById(employeeId);
	}
}
