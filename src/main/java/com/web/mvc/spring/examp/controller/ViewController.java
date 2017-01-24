package com.web.mvc.spring.examp.controller;

import com.web.mvc.spring.examp.entity.Employee;
import com.web.mvc.spring.examp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ViewController {

	@Autowired
	@Qualifier("employeeService")
	EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Spring MVC XML Config Example");
		return "index";
	}

	@RequestMapping(value="/employee/{id}",method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable String id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}

	@RequestMapping(value="/employee",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		if(employee!=null)
			employee = employeeService.addEmployee(employee);
		return employee;
	}
}
