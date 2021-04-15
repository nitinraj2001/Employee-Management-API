package com.nitinraj.springboot.thymeleafdemo.service;

import java.util.List;

import com.nitinraj.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	public Employee findById(int theID);
	
	public void save(Employee employee);
	
	public void deleteById(int theID);

}
