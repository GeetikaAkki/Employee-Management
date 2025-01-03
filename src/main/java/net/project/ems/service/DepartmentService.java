package net.project.ems.service;

import java.util.List;

import net.project.ems.dto.DepartmentDto;

public interface DepartmentService {
DepartmentDto createDepartment(DepartmentDto departmentDto);
DepartmentDto getDepartmentById(Long departmentId);
List <DepartmentDto> getAllDepartments();
DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
void deleteDepartment(Long departmentId);
}
