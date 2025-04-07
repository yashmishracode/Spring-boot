package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// get employees from the database
		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showForm")
	public String showForm(Model thModel) {

		// Create model attribute to bind data
		Employee thEmployee = new Employee();

		thModel.addAttribute("employee", thEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("employeeId") int thId, Model thModel) {

		// get the employee from the service
		Employee thEmployee = employeeService.findById(thId);

		// set employee as a model attribute to pre-populate the form
		thModel.addAttribute("employee", thEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {

		// save the employee
		employeeService.save(thEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}

}
