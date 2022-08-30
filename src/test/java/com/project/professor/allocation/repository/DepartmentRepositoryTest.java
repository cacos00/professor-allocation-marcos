package com.project.professor.allocation.repository;



import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	public void findAll() {
		List<Department> listDepartment = departmentRepository.findAll();
		System.out.println(listDepartment);
	}
	
	@Test
	public void findById() {
		Optional<Department> acheid =  departmentRepository.findById(2l);
	    System.out.println(acheid.orElse(null));
	}
	
	@Test
	public void create() {
		Department dpt = new Department();
		dpt.setName("matematica");
		System.out.println(dpt);
		
		Department dpt2 = departmentRepository.save(dpt);
		System.out.println(dpt2);
		
	}
	
	@Test
	public void update() {
		Department dpt = new Department();
		dpt.setName("portugues");
		dpt.setId(3l);
		System.out.println(dpt);
		
		Department dpt2 = departmentRepository.save(dpt);
		System.out.println(dpt2);
	}
	
	@Test
	public void delete() {
		departmentRepository.deleteById(3l);
	}
	
	@Test
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}

}
