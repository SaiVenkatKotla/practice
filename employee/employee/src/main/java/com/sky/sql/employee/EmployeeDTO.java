package com.sky.sql.employee;


import com.sky.sql.employee.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {

    private Integer empNo;

    private String firstName;

    private String lastName;

    private Gender gender;

}
