package net.project.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.project.ems.dto.EmployeeDto;
import net.project.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
private EmployeeService employeeService;
@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
	EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
	return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}

}
