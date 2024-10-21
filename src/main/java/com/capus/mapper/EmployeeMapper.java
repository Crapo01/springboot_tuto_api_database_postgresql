package com.capus.mapper;

import com.capus.dto.EmployeeDto;
import com.capus.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {

		return new EmployeeDto(employee.getId(), employee.getFname(), employee.getLname(), employee.getEmail());
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {

		return new Employee(employeeDto.getId(), employeeDto.getFname(), employeeDto.getLname(),employeeDto.getEmail());
	}
}
