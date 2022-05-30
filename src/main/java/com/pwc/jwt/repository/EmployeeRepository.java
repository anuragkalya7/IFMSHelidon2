package com.pwc.jwt.repository;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.pwc.jwt.model.Employee;

@Dependent
public class EmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Employee> getAllEmployeeDetails() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> rootEntry = cq.from(Employee.class);
		CriteriaQuery<Employee> all = cq.select(rootEntry);
		TypedQuery<Employee> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
	@Transactional
	public Employee createOrUpdate(Employee employee) {
		if (employee.getEmpId() == null) {
			this.entityManager.persist(employee);
			return employee;
		} else {
			return this.entityManager.merge(employee);
		}
	}

}
