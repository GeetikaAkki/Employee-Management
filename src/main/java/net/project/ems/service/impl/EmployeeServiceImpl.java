package net.project.ems.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.project.ems.dto.EmployeeDto;
import net.project.ems.entity.Employee;
import net.project.ems.mapper.EmployeeMapper;
import net.project.ems.repository.EmployeeRepository;
import net.project.ems.service.EmployeeService;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	

}
