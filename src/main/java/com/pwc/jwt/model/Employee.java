package com.pwc.jwt.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Access(value = AccessType.FIELD)
@Entity
@Table(name = "EMP_MASTER")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(insertable = true, name = "EMP_ID", nullable = false, updatable = false)
	@Id
	private String empId;

	@Column(insertable = true, name = "EMP_NAME", updatable = true)
	private String empName;

	@Column(insertable = true, name = "EMP_AGE", updatable = true)
	private int empAge;

	@Column(insertable = true, name = "EMP_SALARY", updatable = true)
	private long empSalary;

	/**
	 * Default Constructor
	 */
	public Employee() {
		super();
	}

	/**
	 * @param empId
	 * @param empName
	 * @param empAge
	 * @param empSalary
	 */
	public Employee(String empId, String empName, int empAge, long empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empAge
	 */
	public int getEmpAge() {
		return empAge;
	}

	/**
	 * @param empAge the empAge to set
	 */
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	/**
	 * @return the empSalary
	 */
	public long getEmpSalary() {
		return empSalary;
	}

	/**
	 * @param empSalary the empSalary to set
	 */
	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ "]";
	}

}
