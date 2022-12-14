package com.project.professor.allocation.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false, length = 16)
	private DayOfWeek day;

	@Temporal(value = TemporalType.TIME)
	@Column(nullable = false)
	private Date start;

	@Temporal(value = TemporalType.TIME)
	@Column(nullable = false)
	private Date end;
	
	@Column(name = "Course_id",nullable = false)
	private Long courseId;
	
	@ManyToOne
	@JoinColumn(name = "Course_id", nullable = false, insertable = false, updatable = false)
	private Course course;

	
	@Column(name = "Professor_id",nullable = false)
	private Long professorId;
	
	@ManyToOne
	@JoinColumn(name = "Professor_id", nullable = false, insertable = false, updatable = false)
	private Professor professor;
	
	

	

	public Allocation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

}
