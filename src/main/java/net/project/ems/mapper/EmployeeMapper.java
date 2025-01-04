package net.project.ems.mapper;

import net.project.ems.dto.EmployeeDto;
import net.project.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
         Employee employee = new Employee();
         employee.setId(employeeDto.getId());
         employee.setFirstName(employeeDto.getFirstName());
         employee.setLastName(employeeDto.getLastName());
         employee.setEmail(employeeDto.getEmail());
         return employee;
    }
}