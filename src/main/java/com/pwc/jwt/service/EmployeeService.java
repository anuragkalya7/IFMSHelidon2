package com.pwc.jwt.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.pwc.jwt.model.Employee;
import com.pwc.jwt.repository.EmployeeRepository;

@Dependent
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	/**
	 * @param employeeRepository
	 */
	@Inject
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployeeDetails() {
		return employeeRepository.getAllEmployeeDetails();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.createOrUpdate(employee);
	}

}
