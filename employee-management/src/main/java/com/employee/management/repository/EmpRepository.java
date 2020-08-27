package com.employee.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.employee.management.entity.Employee;

// interface extending crud repository
public interface EmpRepository extends CrudRepository<Employee, Integer>{
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Employee e set e.latestSalary = :salary where e.employeeID = :employeeID ")
	void updateSalary(@Param("salary") String salary , @Param("employeeID") int id);
	
	
	@Query("select e from Employee e where e.department.department_ID = :deptID")
	List<Employee> getEmployeesByDept(@Param("deptID") int id);
} 