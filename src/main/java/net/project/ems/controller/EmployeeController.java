package net.project.ems.controller;
import net.project.ems.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.project.ems.dto.EmployeeDto;
import net.project.ems.service.EmployeeService;
@CrossOrigin("*")
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
@GetMapping("/{Id}")
public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("Id") Long employeeId){
	EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
	return ResponseEntity.ok(employeeDto);
}
@GetMapping
public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
	List<EmployeeDto> employees=employeeService.getAllEmployees();
	return ResponseEntity.ok(employees);
}

@PutMapping("{id}")
public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")Long employeeId,@RequestBody EmployeeDto updateedEmployee){
	EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updateedEmployee);
	return ResponseEntity.ok(employeeDto);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId){
	employeeService.deleteEmployee(employeeId);
	return ResponseEntity.ok("Employee deleted successfully!");
}


}
