package net.project.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.project.ems.dto.DepartmentDto;
import net.project.ems.service.DepartmentService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
private DepartmentService departmentService;
@PostMapping
public ResponseEntity<DepartmentDto> createDepartment( @RequestBody DepartmentDto departmentDto){
	DepartmentDto department= departmentService.createDepartment(departmentDto);
	return new ResponseEntity<>(department, HttpStatus.CREATED);
	
}
@GetMapping("{id}")
public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
	DepartmentDto departmentDto=departmentService.getDepartmentById(departmentId);
	return ResponseEntity.ok(departmentDto);
}
@GetMapping
public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
	List<DepartmentDto> departments=departmentService.getAllDepartments();
	return ResponseEntity.ok(departments);
}
@PutMapping("{id}")
public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto updatedDepartment){
	DepartmentDto departmentDto=departmentService.updateDepartment(departmentId, updatedDepartment);
	return ResponseEntity.ok(departmentDto);
}

@DeleteMapping("{id}")
public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
	departmentService.deleteDepartment(departmentId);
	return ResponseEntity.ok("Department deleted successfully");
}
}
