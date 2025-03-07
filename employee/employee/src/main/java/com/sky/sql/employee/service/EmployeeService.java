package com.sky.sql.employee.service;

import com.sky.sql.employee.entity.Employees;

import java.util.Optional;

public interface EmployeeService {

    Employees getEmployeeById(int id);
}
