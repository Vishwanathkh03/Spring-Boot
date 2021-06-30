/**
 * 
 */
package org.vishwa.springboot.employeeportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.vishwa.springboot.employeeportal.model.EmployeeEntity;


/**
 * @author vhatgund
 *
 */
@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, Long>{
	EmployeeEntity findByEmpId(String empId);
}
