package com.thymeleafdemo.thyme.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymeleafdemo.thyme.entity.Employee;
import com.thymeleafdemo.thyme.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;

	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee thEmployee = new Employee();
		theModel.addAttribute("employee", thEmployee);
		return "employees/employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {
		employeeService.save(thEmployee);

		return "redirect:/employees/list";
	}

}
