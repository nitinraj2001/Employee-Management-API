package com.nitinraj.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nitinraj.springboot.thymeleafdemo.entity.Employee;
import com.nitinraj.springboot.thymeleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService theEmployeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		theEmployeeService=employeeService;
	}

	@GetMapping("/list")
	public String getEmployees(Model theModel) {
		List<Employee> theemployees=theEmployeeService.findAll();
		theModel.addAttribute("employees", theemployees);
		return "list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAddEmp(Model theModel) {
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee) {
		theEmployeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("empID") int ID,Model theModel) {
		Employee theEmployee=theEmployeeService.findById(ID);
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("empID") int ID) {
		theEmployeeService.deleteById(ID);
		return "redirect:/employees/list";
	}
}
