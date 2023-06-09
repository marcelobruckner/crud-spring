package com.bruckner.controller;

import java.util.List;

import com.bruckner.model.Course;
import com.bruckner.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

  private final CourseRepository courseRepository;

  public CourseController(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

  void teste(){
    System.out.println("nada");
  }
}
