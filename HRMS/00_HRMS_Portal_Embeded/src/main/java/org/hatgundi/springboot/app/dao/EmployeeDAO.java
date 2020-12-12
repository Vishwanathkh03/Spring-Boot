/**
 * 
 */
package org.hatgundi.springboot.app.dao;

import org.hatgundi.springboot.app.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vishwanath Hatgundi
 *
 */
public interface EmployeeDAO extends CrudRepository<Employee, Long>{
	public Employee findByEmployeeId(String employeeId);
}
