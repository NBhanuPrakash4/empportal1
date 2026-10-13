package com.vcube.empportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.empportal.model.Employee;

@RestController

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
