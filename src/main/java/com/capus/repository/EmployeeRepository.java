package com.capus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capus.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
