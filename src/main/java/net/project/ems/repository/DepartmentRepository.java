package net.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.project.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	

}
