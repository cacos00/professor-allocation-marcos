package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;



@Service
public class ProfessorService {
	
	private final ProfessorRepository professorRepository;
    private final DepartmentService departmentService; 
	
	

	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
	}

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public List<Professor> findByNameContaining(String name) {
		return professorRepository.findByNameContaining(name);
	}

	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	public Professor findByCpf(String cpf) {
		return professorRepository.findByCpf(cpf).orElse(null);
	}

	public List<Professor> findByDepartmentId(Long departmentId) {
		return professorRepository.findByDepartmentId(departmentId);
	}

	public Professor save(Professor professor) {
		professor.setId(null);
		
		return professorRepository.save(professor);
	}

	public Professor update(Professor professor) {
		if (professor.getId() != null && professorRepository.existsById(professor.getId())) {
			return professorRepository.save(professor);
		} else
			return null; 
	}

	public void deleteById(Long id) {
		if (id != null && professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		} 
	}

	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}

}
	


