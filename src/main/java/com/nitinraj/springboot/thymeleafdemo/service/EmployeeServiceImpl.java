package com.nitinraj.springboot.thymeleafdemo.service;

import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.nitinraj.springboot.thymeleafdemo.dao.EmployeeRepository;

import com.nitinraj.springboot.thymeleafdemo.entity.Employee;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository theEmployeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
		theEmployeeRepository=EmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return theEmployeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theID) {
		
		Optional<Employee> result = theEmployeeRepository.findById(theID);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("Employee id is not found");
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		
		theEmployeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int theID) {
		
		theEmployeeRepository.deleteById(theID);
		
		
	}

}