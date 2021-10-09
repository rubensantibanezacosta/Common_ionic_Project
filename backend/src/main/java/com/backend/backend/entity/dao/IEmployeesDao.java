package com.backend.backend.entity.dao;

import com.backend.backend.entity.models.Employee;

import org.springframework.data.repository.CrudRepository;

public interface IEmployeesDao extends CrudRepository<Employee, Integer>{
    

}
