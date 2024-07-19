package com.company.onboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.onboard.dto.EmployeeRequestVO;
import com.company.onboard.dto.EmployeeResponseVO;
import com.company.onboard.entity.Employee;
import com.company.onboard.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")


public class EmployeeController {
	@Autowired
    private EmployeeService employeeservice;
	
	/*Employee*/
	@PostMapping(value="/save")
	public EmployeeResponseVO createEmployee(@RequestBody EmployeeRequestVO empvo) {
    	return employeeservice.createEmployee(empvo);
    }
	
    @GetMapping(value="/getall/employees")
    public List<Employee> getAllEmployees(){
    	return employeeservice.getAllEmployees();
    }
}
