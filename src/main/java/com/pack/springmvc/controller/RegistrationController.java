package com.pack.springmvc.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import javax.sound.sampled.LineListener;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pack.springmvc.service.EmployeeService;
import com.pack.springmvc.model.Employee;
//@Controller
@RestController
@RequestMapping("/employee")
public class RegistrationController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
	public List<Employee> displayAll() {
		List<Employee> empList= employeeService.listAllEmployee();
		return empList;
	}

	@GetMapping(value="/getbyid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
	public Employee getById(@PathVariable("id") int id) {
		Employee employee = employeeService.findByIdEmployee(id);
		//model.addAttribute("employee", employee);
		return employee;
	}
	
	/*@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("employee",new Employee());
		return "register";
	}*/
	
	/*@PostMapping("/register")
	public String registerEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
		System.out.println(employee);
		 String returnVal = "success";
	        if(result.hasErrors()) {
	        
	            returnVal = "register";
	        }
	    	employeeService.insertEmployee(employee);
	        return returnVal;
*/

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void registerEmployee(@Valid @RequestBody Employee employee){
        System.out.println(employee);
        System.out.println("Came inside the post method of register employee ....");
    }


	
	
}

