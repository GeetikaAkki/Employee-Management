package net.project.ems.mapper;

import net.project.ems.dto.DepartmentDto;
import net.project.ems.entity.Department;

public class DepartmentMapper {
public static DepartmentDto mapToDepartmentDto(Department department) {
	return new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription());
}
public static Department maptoDepartment(DepartmentDto departmentDto) {
	return new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription());
}
}

