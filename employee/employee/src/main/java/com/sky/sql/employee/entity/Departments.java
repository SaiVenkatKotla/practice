package com.sky.sql.employee.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "departments")
public class Departments {

    @Id
    @Column(name = "dept_no", nullable = false)
    private String deptNo;

    @Column(name = "dept_name", nullable = false, unique = true)
    private String deptName;
}
