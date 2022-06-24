package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


@Repository
@RequestMapping("/api/v1/")
@RestController
public class EmployeeController {
	 @Autowired	
	 private EmployeeRepository employeeRepository;
	 
	 //get all employees
	 
	 @GetMapping("/employees")
	 public java.util.List<Employee> getAllEmployees()
	 {
		return employeeRepository.findAll();
	 }
	 
	 
	 @GetMapping("/employees/{empId}")
	 public Optional<Employee> getEmployee(@PathVariable("empId") Long empId)
	 {
		return employeeRepository.findById(empId);
	 }
	 
	 @DeleteMapping("/employees/{empId}")
	 public void deleteEmployee(@PathVariable("empId") Long empId)
	 {
		 employeeRepository.deleteById(empId);
	 }
		
	 @PostMapping("/employees")
	 public void saveEmployee(@RequestBody Employee employee)
	 {
		 employeeRepository.save(employee);
	 }
	 
	 @PutMapping("/employees")
	 public void updateEmployee(@RequestBody Employee employee)
	 {
		 employeeRepository.save(employee);
	 }
}
	 