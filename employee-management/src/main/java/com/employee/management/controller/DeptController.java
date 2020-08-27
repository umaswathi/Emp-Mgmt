
  package com.employee.management.controller;
  
  import java.util.List;
import java.util.Optional;

import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.web.bind.annotation.DeleteMapping;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PathVariable;
import  org.springframework.web.bind.annotation.PostMapping;
import  org.springframework.web.bind.annotation.PutMapping;
import  org.springframework.web.bind.annotation.RequestBody;
import  org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Department;
import  com.employee.management.service.DeptService;
  
  @RestController 
  public class DeptController {
  
  static final Logger logger =
  LogManager.getLogger(DeptController.class.getName());
  
  @Autowired 
  private DeptService deptService;
  
  
	@GetMapping("/departments")
	public List<Department> getAllDepartment() {
		return deptService.getAllDepartments();
	}


	@PostMapping("/addDepartments")
	public void addDepartment(@RequestBody Department department) {
		deptService.addDepartment(department);
	}
  
 
  
  }
 