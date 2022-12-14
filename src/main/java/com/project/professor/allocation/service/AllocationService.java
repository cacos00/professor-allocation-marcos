package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {
	
	private final AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}
	
	public List<Allocation> findByProfessorId(Long professorId){
	return allocationRepository.findByProfessorId(professorId);
	
	}
    public List<Allocation> findByCourseId(Long courseId){
    	return allocationRepository.findByCourseId(courseId);
    }

    public Optional<Allocation> findById(Long id) {
    	return allocationRepository.findById(id);
    	
    }
    
    public List<Allocation> findAll(){
    	return allocationRepository.findAll();

    }
    
    public Allocation create(Allocation allocation) {
    	allocation.setId(null);
    	return allocationRepository.save(allocation);
    	
    	}
    
    public Allocation update(Allocation allocation) {
    	Long id = allocation.getId();
    	if( id != (null) && allocationRepository.existsById(id))  {
    	return allocationRepository.save(allocation);
    	}else {
    		return null;
    }}

    public void deleteAll() {
    	allocationRepository.deleteAllInBatch();
    }
    
    
    public void deleteById(Long id) {
    	if(allocationRepository.existsById(id)) {
    	allocationRepository.deleteById(id);
    	}else {
    }
    }



}

   


