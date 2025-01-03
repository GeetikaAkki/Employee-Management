package net.project.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.project.ems.dto.DepartmentDto;
import net.project.ems.entity.Department;
import net.project.ems.exception.ResourceNotFoundException;
import net.project.ems.mapper.DepartmentMapper;
import net.project.ems.mapper.EmployeeMapper;
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

	@Override
	
	public DepartmentDto getDepartmentById(Long departmentId) {
			Department department= departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department does not exist with the given Id: "+ departmentId));
			
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List <Department> departments=departmentRepository.findAll();
		return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
		Department department=departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department does not exisit with given id: "+departmentId));
		department.setDepartmentName(updatedDepartment.getDepartmentName());
		department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
		Department savedDepartment=departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(department);
		
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department does no exist with given id: "+ departmentId));
		departmentRepository.deleteById(departmentId);
	}
	

}
