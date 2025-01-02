package net.project.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
