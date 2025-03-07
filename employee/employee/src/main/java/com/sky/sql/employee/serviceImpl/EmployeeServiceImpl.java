package com.sky.sql.employee.serviceImpl;

import com.sky.sql.employee.entity.Employees;
import com.sky.sql.employee.repository.EmployeeRepository;
import com.sky.sql.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employees getEmployeeById(int id) {
        Optional<Employees> emp = employeeRepository.findById(id);
        return emp.orElseThrow(() -> new RuntimeException("No Such Employee with given Id"));
    }

}
