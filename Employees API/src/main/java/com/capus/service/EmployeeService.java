package com.capus.service;

import java.util.List;

import com.capus.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long id);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(Long id,EmployeeDto updatedEmployeeDto);
	void deleteEmployee(long id);
}
