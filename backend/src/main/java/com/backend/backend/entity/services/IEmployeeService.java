package com.backend.backend.entity.services;
import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.models.Employee;

public interface IEmployeeService {
    List<Employee> getAll();
    Optional<Employee> getOne(int employee_id);
	void add(Employee employee);
	void delete(int employee_id);
	
}
