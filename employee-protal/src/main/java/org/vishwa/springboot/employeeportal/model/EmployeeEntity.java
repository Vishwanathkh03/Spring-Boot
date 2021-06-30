package org.vishwa.springboot.employeeportal.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Employee")
@JsonInclude(Include.NON_NULL)
public class EmployeeEntity {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@ApiModelProperty(notes = "The database generated product ID")
	@Id
	private long id;

	@Version
	@ApiModelProperty(notes = "The auto-generated version of the product")
	private Integer version;

	@ApiModelProperty(notes = "The employee unique empId")
	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String empId;

	@ApiModelProperty(notes = "The employee first name")
	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String firstName;

	@ApiModelProperty(notes = "The employee last name")
	private String lastName;

	@ApiModelProperty(notes = "The employee emial id")
	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String email;

	@CreatedDate
	private Date createdAt = new Date();
	@LastModifiedDate
	private Date lastModified;

	@CreatedBy
	private String createdBy = "Admin";

	@LastModifiedBy
	private String lastModifiedBy;

	public EmployeeEntity() {
	}

	public EmployeeEntity(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = emailId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", createdAt=" + createdAt + ", lastModified=" + lastModified
				+ ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

}
