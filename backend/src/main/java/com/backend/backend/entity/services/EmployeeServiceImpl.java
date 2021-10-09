package com.backend.backend.entity.services;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.dao.IEmployeesDao;
import com.backend.backend.entity.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeesDao iEmployeesDao;

    @Override
        public List<Employee> getAll() {
            return (List<Employee>) iEmployeesDao.findAll();
    }

    @Override
    public void add(Employee employee) {
        iEmployeesDao.save(employee);

    }

    @Override
    public void delete(int employee_id) {
        iEmployeesDao.deleteById(employee_id);

    }
	@Override
	public Optional<Employee> getOne(int employee_id) {
		return iEmployeesDao.findById(employee_id);
	}
   

}
