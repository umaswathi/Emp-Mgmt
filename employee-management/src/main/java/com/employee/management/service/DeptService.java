package com.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.entity.Department;
import com.employee.management.repository.DeptRepository;


@Service
public class DeptService {

	@Autowired
	private DeptRepository deptRepository;
	

	// fetching all department
	public List<Department> getAllDepartments(){
		List<Department> depts = (List<Department>)deptRepository.findAll(); 
		return depts;
	}
	
	// inserting department
	public void addDepartment(Department d) {
		deptRepository.save(d);
	}
	
}
