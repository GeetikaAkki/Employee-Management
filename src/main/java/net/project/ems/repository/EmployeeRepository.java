package net.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.project.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
