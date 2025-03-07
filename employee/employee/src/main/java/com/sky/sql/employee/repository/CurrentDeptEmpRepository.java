package com.sky.sql.employee.repository;

import com.sky.sql.employee.entity.CurrentDeptEmp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentDeptEmpRepository extends JpaRepository<CurrentDeptEmp, Integer> {
}
