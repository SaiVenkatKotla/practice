package com.sky.sql.employee.repository;

import com.sky.sql.employee.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
