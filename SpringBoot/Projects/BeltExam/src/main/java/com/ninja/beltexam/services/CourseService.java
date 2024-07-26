package com.ninja.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.beltexam.models.Course;
import com.ninja.beltexam.repositories.CourseRepository;

@Service
public class CourseService {
	
	private final CourseRepository courseRepo;
	
	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	// Create course
	public Course create(Course newCourse) {
		return courseRepo.save(newCourse);
	}
	
	// Update course
	public Course update(Course course) {
		return courseRepo.save(course);
	}
	
	// Get all courses
	public List<Course> allCourses(){
		return courseRepo.findAll();
	}
	
	// Get course by id
	public Course findCourse(Long courseId) {
		Optional<Course> course = courseRepo.findById(courseId);
		if(course.isPresent()) {
			return course.get();
		}
		return null;
	}
	
	// Delete course by id
	public void delete(Long courseId) {
		courseRepo.deleteById(courseId);
	}
}
