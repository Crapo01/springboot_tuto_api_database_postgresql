package com.capus.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capus.dto.EmployeeDto;
import com.capus.entity.Employee;
import com.capus.exceptions.ResourceNotFoundException;
import com.capus.mapper.EmployeeMapper;
import com.capus.repository.EmployeeRepository;
import com.capus.service.EmployeeService;

@Service
public class EmployeeServiceIplm implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceIplm(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);		
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee with id "+id+" not found!!!"));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {		
		Employee employee= employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee with id "+id+" not found!!!"));
		employee.setFname(updatedEmployee.getFname());
		employee.setLname(updatedEmployee.getLname());
		employee.setEmail(updatedEmployee.getEmail());
		Employee savedUpdatedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedUpdatedEmployee);
	}
	@Override
	public void deleteEmployee(long id) {
		Employee employee= employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee with id "+id+" not found!!!"));
		employeeRepository.deleteById(id);		
	}

}
