/**
 * 
 */
package org.vishwa.springboot.employeeportal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vishwa.springboot.employeeportal.dto.Employee;
import org.vishwa.springboot.employeeportal.dto.HttpResponse;
import org.vishwa.springboot.employeeportal.service.EmployeeService;
import org.vishwa.springboot.employeeportal.util.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author vhatgund
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// get all employees
	@ApiOperation(value = "View a list of available Employees", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/employees")
	public ResponseEntity<HttpResponse> fetchAll() {
		List<Employee> employees = empService.getAllEmployees();
		HttpResponse response = new HttpResponse(HttpStatus.OK.value(), Constants.SUCCESS, employees);
		return ResponseEntity.ok().body(response);
	}

	// create employee rest api
	@ApiOperation(value = "Add an Employee")
	@PostMapping("/employees")
	public ResponseEntity<HttpResponse> createEmployee(@RequestBody Employee iObject) {
		Employee employee = empService.saveOrUpdate(iObject);
		HttpResponse response = new HttpResponse(HttpStatus.OK.value(), Constants.SUCCESS, employee);
		return ResponseEntity.ok().body(response);
	}

	// get employee by id rest api
	@ApiOperation(value = "Search a Employee with an ID", response = Employee.class)
	@GetMapping("/employees/{empId}")
	public ResponseEntity<HttpResponse> getEmployeeByEmpId(@RequestParam("empId") String empId) {
		Employee employee = empService.getEmployeeByEmpId(empId);
		HttpResponse response = new HttpResponse(HttpStatus.OK.value(), Constants.SUCCESS, employee);
		return ResponseEntity.ok(response);
	}

	// update employee rest api
	@ApiOperation(value = "Update a Employee")
	@PutMapping("/employees/{id}")
	public ResponseEntity<HttpResponse> updateEmployee(@RequestBody Employee employeeDetails) {
		Employee employee = empService.update(employeeDetails);
		HttpResponse response = new HttpResponse(HttpStatus.OK.value(), Constants.SUCCESS, employee);
		return ResponseEntity.ok(response);
	}

	// delete employee rest api
	@ApiOperation(value = "Delete a Employee")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpResponse> deleteEmployee(@PathVariable String empId) {
		Map<String, Boolean> deletedObj = empService.deleteById(empId);
		HttpResponse response = new HttpResponse(HttpStatus.OK.value(), Constants.SUCCESS, deletedObj);
		return ResponseEntity.ok(response);
	}

}
