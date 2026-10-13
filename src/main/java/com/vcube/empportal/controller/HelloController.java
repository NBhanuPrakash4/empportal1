package com.vcube.empportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.empportal.model.Employee;
import com.vcube.empportal.repo.EmployeeRepo;

import lombok.Delegate;

@CrossOrigin("http://localhost:3000/")
@RestController
public class HelloController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/hello")
    String Hello() {
        return "hello springboot";
    }

    @GetMapping("/getAllEmployeeDetails")
    List<Employee> getAllEmployeeDetails(){
       return employeeRepo.findAll();
    }
    @GetMapping("/getEmp/{eid}")
    public Employee getEmployee(@PathVariable Integer eid){
    	return employeeRepo.findById(eid).orElseThrow();
    	}
@PostMapping("/createEmp")
public Employee createEmp(@RequestBody Employee emp) {
return employeeRepo.save(emp);
}
@PutMapping("/updateEmp/{eid}")
public Employee update(@RequestBody Employee employee, @PathVariable Integer eid){
	Employee empFromDb=getEmployee(eid);
	empFromDb.setAge(employee.getAge());
	empFromDb.setCity(employee.getCity());
	empFromDb.setEname(employee.getEname());
	empFromDb.setSalary(employee.getSalary());
	empFromDb.setState(employee.getState());
	return employeeRepo.save(empFromDb);
}

   

@DeleteMapping("/delEmp/{eid}")
String deleteEmployee(@PathVariable Integer eid) {
	employeeRepo.deleteById(eid);
	return "Employee has been deteted successfully with id of !!" +eid;
}
} 