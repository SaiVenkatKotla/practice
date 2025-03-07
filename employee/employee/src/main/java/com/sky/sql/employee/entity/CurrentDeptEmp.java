package com.sky.sql.employee.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "current_dept_emp")
public class CurrentDeptEmp {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "dept_no", nullable = false)
    private String deptNo;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    private Date toDate;
}
