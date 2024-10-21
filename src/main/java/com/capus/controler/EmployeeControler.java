package com.capus.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capus.dto.EmployeeDto;
import com.capus.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControler {
	private EmployeeService employeeService;

	public EmployeeControler(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// BUILD add employee (POST) REST API
	// POST http://localhost:8080/api/employees
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}

	// BUILD get employee by id (GET) REST API
	// GET http://localhost:8080/api/employees/{id}
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDto);
	}

	// BUILD get all employees list (GET) REST API
	// GET http://localhost:8080/api/employees
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// BUILD update employee by id (PUT) REST API
	// PUT http://localhost:8080/api/employees/{id}
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,
			@RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employeeDto = employeeService.updateEmployee(id, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	// BUILD delete employee by id (DELETE) REST API
	// DELETE http://localhost:8080/api/employees/{id}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee with id#"+id+": Deleted!!!");
	}
}