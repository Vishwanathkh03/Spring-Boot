package org.vishwa.springboot.employeeportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vishwa.springboot.employeeportal.dto.Employee;
import org.vishwa.springboot.employeeportal.exception.ResourceNotFoundException;
import org.vishwa.springboot.employeeportal.model.EmployeeEntity;
import org.vishwa.springboot.employeeportal.repository.EmployeeRepository;
import org.vishwa.springboot.employeeportal.util.Constants;
import org.vishwa.springboot.employeeportal.util.EmpUtils;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private EmpUtils util;

	@Autowired
	private ModelMapper modelMapper;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		List<EmployeeEntity> allEmployees = employeeRepository.findAll();
		for (EmployeeEntity entity : allEmployees) {
			employees.add(convertToDto(entity));
		}
		return employees;
	}

	public Employee getEmployeeByEmpId(String empId) {
		return convertToDto(employeeRepository.findByEmpId(empId));
	}
	
	public Employee saveOrUpdate(Employee employee) {
		return convertToDto(employeeRepository.save(convertToEntity(employee)));
	}

	public Employee update(Employee employeeDetails) {
		return saveOrUpdate(employeeDetails);
	}

	public Map<String, Boolean> deleteById(String empId) {
		EmployeeEntity employee = employeeRepository.findByEmpId(empId);
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	private EmployeeEntity convertToEntity(Employee employee) {
		if (employee.getEmpId() != null) {
			EmployeeEntity entityDB = employeeRepository.findByEmpId(employee.getEmpId());
			modelMapper.map(employee, entityDB);
			entityDB.setLastModified(new Date());
			entityDB.setLastModifiedBy("USER");
			return entityDB;
		} else {
			EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);
			entity.setId(sequenceGeneratorService.generateSequence(EmployeeEntity.SEQUENCE_NAME));
			entity.setEmpId(util.generateUserId(6));
			entity.setCreatedAt(new Date());
			entity.setCreatedBy("SYS");
			return entity;
		}
	}

	private Employee convertToDto(EmployeeEntity entity) {
		Employee employee = modelMapper.map(entity, Employee.class);
		return employee;
	}
}
