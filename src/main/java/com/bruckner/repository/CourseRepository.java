package com.bruckner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruckner.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
