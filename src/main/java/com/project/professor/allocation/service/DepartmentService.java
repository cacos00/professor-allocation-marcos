package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	public Department findById(Long id) {
		return departmentRepository.findById(id).orElse(null);

	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Department create(Department department) {
		department.setId(null);
		return departmentRepository.save(department);
	}

	public Department update(Department department) {
		if (department.getId() != null && departmentRepository.existsById(department.getId())) {
			return departmentRepository.save(department);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (id != null && departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}
	}
    public void deleteAll() {
    	departmentRepository.deleteAllInBatch();
    }
}
