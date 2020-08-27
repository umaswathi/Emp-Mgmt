package com.employee.management.repository;

import org.springframework.data.repository.CrudRepository;
import com.employee.management.entity.Department;

public interface DeptRepository extends CrudRepository<Department, Integer>{

}