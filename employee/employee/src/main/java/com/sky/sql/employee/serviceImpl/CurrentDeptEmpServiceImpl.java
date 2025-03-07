package com.sky.sql.employee.serviceImpl;

import com.sky.sql.employee.entity.CurrentDeptEmp;
import com.sky.sql.employee.repository.CurrentDeptEmpRepository;
import com.sky.sql.employee.service.CurrentDeptEmpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CurrentDeptEmpServiceImpl implements CurrentDeptEmpService {

    @Autowired
    CurrentDeptEmpRepository currentDeptEmpRepository;


    @Override
    public CurrentDeptEmp getEmpById(Integer id) {
        Optional<CurrentDeptEmp> currentDeptEmp = currentDeptEmpRepository.findById(id);
        return currentDeptEmp.orElseThrow(() -> new RuntimeException("No Such Employee with given Id in CurrentDeptEmpRepository"));
    }
}
