package com.employee.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmpService;

@RestController
public class EmpController {
	
	static final Logger logger  = LogManager.getLogger(EmpController.class.getName());
	
	
	@Autowired
	private EmpService empService;

	
	// displaying list of all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employees/deptid/{depid}")
	public List<Employee> getAllEmployeeByDeptId(@PathVariable int depid){
		return empService.getEmployeesByDepID(depid);
	}
	

	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee){
		empService.addEmployee(employee);
	}

	
	@PutMapping("/employees/updatesalary/{id}")
	public void updateEmployeeSalary(@RequestBody Employee e, @PathVariable int id){
		empService.updateEmployeeSalary(e.getLatestSalary(), id);
	}
	
}


