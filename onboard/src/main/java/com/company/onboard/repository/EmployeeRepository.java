package com.company.onboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.onboard.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

	@Query("SELECT e from Employee e")
	List<Employee> findAllEmployee();

}
