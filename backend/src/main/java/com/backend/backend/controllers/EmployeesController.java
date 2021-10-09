package com.backend.backend.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.backend.entity.models.Employee;
import com.backend.backend.entity.services.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class EmployeesController {
    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/employees")
    List<Employee> getAll() {
        return iEmployeeService.getAll();
    }

    @GetMapping("/employees/{employee_id}")
    Employee getOne(@PathVariable("employee_id") int employee_id) {
        Optional<Employee> b = iEmployeeService.getOne(employee_id);

        if (b.isPresent()) {
            return b.get();
        }
        ;
        return null;
    }

    @PostMapping(value = "/employees", consumes = "application/json")
    void add(@RequestBody String stringEmployee) {
        ObjectMapper om = new ObjectMapper();
        try {
            Employee employee = om.readValue(stringEmployee, Employee.class);
            iEmployeeService.add(employee);
        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
    }

    @PutMapping(value = "/employees/{employee_id}", consumes = "application/json")
    void update(@RequestBody String stringEmployee, @PathVariable int employee_id) {
        ObjectMapper om = new ObjectMapper();
        try {
            Employee newEmployee = om.readValue(stringEmployee, Employee.class);
            Optional<Employee> employee = iEmployeeService.getOne(employee_id);

            employee.get().setEmployee_id(newEmployee.getEmployee_id());
            employee.get().setImageurl(newEmployee.getImageurl());
            employee.get().setName(newEmployee.getName());
            employee.get().setJob(newEmployee.getJob());

            iEmployeeService.add(employee.get());

        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

    }

    @DeleteMapping("/employees/{employee_id}")
    void delete(@PathVariable("employee_id") int employee_id) {
        iEmployeeService.delete(employee_id);
    }
}
