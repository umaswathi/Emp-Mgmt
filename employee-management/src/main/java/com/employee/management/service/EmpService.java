package com.employee.management.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.management.entity.Employee;
import com.employee.management.exception.EmpNotFoundException;
import com.employee.management.repository.EmpRepository;

@Service
public class EmpService {
	
	
	  @Autowired 
	  private EmpRepository empRepository;
	 
	
	 List<Employee> emps =new ArrayList<Employee>();
	

	 public List<Employee> getAllEmployees() {
			List<Employee> emps = (List<Employee>) empRepository.findAll();
			return emps;
		}

		@Transactional(readOnly = true)
		public List<Employee> getEmployeesByDepID(int employeeID) {
			List<Employee> emps = (List<Employee>) empRepository.getEmployeesByDept(employeeID);
			if(emps.isEmpty()) {
			throw new EmpNotFoundException("Employee Not Available");
			}
			return emps;
		}

		// fetching employee by id
		public Optional<Employee> getEmployee(int id) {

			Optional<Employee> employeeList = empRepository.findById(id);

			if (employeeList.isEmpty()) {

				throw new EmpNotFoundException("Employee Not Available");
			}
			return employeeList;

		}

		// inserting employee
		public void addEmployee(Employee e) {
			empRepository.save(e);
		}

		// updating employee by id
		public void updateEmployeeSalary(String salary, int id) {

			if (!salary.isEmpty()) {
				if (Integer.parseInt(salary) <= 0) {
					throw new EmpNotFoundException("Salary should not be zero");
				}
			}else {
				throw new EmpNotFoundException("Salary should not be zero");
			}
			empRepository.updateSalary(salary, id);

		}

		// updating employee by id
		public void updateEmployee(Employee emp, int id) {
			if (id == emp.getEmployeeID()) {
				empRepository.save(emp);
			}
		}
 


}


