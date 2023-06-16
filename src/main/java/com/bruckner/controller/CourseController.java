package com.bruckner.controller;

import com.bruckner.model.Course;
import com.bruckner.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  private final CourseRepository courseRepository;

  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<Course> create(@RequestBody Course course){
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(courseRepository.save(course));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Course> findById(@PathVariable Long id) {
    return courseRepository.findById(id)
           .map(course -> ResponseEntity.ok().body(course))
           .orElse(ResponseEntity.notFound().build());
  }
}

