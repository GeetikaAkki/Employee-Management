package net.project.ems.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.project.ems.dto.DepartmentDto;
import net.project.ems.entity.Department;
import net.project.ems.mapper.DepartmentMapper;
import net.project.ems.repository.DepartmentRepository;
import net.project.ems.service.DepartmentService;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto){
		Department department= DepartmentMapper.maptoDepartment(departmentDto);
		Department savedDepartment=departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}
	

}
