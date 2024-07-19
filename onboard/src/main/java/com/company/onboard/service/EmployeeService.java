package com.company.onboard.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.onboard.dto.EmployeeRequestVO;
import com.company.onboard.dto.EmployeeResponseVO;
import com.company.onboard.entity.Employee;
import com.company.onboard.exceptionhandler.EmployeeExceptionHandler;
import com.company.onboard.repository.EmployeeRepository;


@Service

public class EmployeeService {
private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	

	/*Employee*/

	@Autowired
	private EmployeeRepository emprepo;
	public EmployeeResponseVO createEmployee(EmployeeRequestVO empvo)
	{
		Employee empentity = new Employee();
		EmployeeResponseVO response  = new EmployeeResponseVO();
		
		try {
			empentity.setPhone(empvo.getPhone());
			empentity.setUserName(empvo.getUserName());
            Employee saveemp = emprepo.save(empentity);
			if (saveemp == null) {
				throw new EmployeeExceptionHandler("Employee creation failed: Saved employee is null");
			}
			response.setSuccess(true);
			response.setMessage("Employee created successfully");
		} catch (EmployeeExceptionHandler e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			logger.info("Employee crteation failed ");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Employee creation failed: " + e.getMessage());
			logger.info("Employee crteation failed ");
		}
		return response;
	}
	public List<Employee> getAllEmployees() {
		return emprepo.findAll();
	}
}
