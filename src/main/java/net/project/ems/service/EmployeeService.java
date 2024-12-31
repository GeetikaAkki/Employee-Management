package net.project.ems.service;

import java.util.List;

import net.project.ems.dto.EmployeeDto;

public interface EmployeeService {
 EmployeeDto createEmployee(EmployeeDto employeeDto);
 EmployeeDto getEmployeeById(Long employeeId);
 List<EmployeeDto> getAllEmployees();
}
