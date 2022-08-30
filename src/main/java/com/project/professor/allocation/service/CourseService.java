package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course findById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public Course create(Course course) {
		course.setId(null);
		return courseRepository.save(course);
	}

	public Course update(Course course) {
		Long id = course.getId();
		if (id != (null) && courseRepository.existsById(id)) {
			return courseRepository.save(course);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		courseRepository.deleteById(id);
	}

	public void deleteAll() {
		courseRepository.deleteAll();
	}

}
