package com.bruckner.dto.mapper;

import org.springframework.stereotype.Component;

import com.bruckner.dto.CourseDTO;
import com.bruckner.model.Course;

@Component
public class CourseMapper {

  public CourseDTO toDTO(Course course) {
    if (course == null) {
      return null;
    }

    return new CourseDTO(course.getId(), course.getName(), course.getCategory());
  }

  public Course toEntity(CourseDTO dto) {
    if (dto == null) {
      return null;
    }

    Course course = new Course();
    if (dto.id() != null) {
      course.setId(dto.id());
    }

    if (dto.name() != null) {
      course.setName(dto.name());
    }

    if (dto.category() != null) {
      course.setCategory(dto.category());
    }

    course.setStatus("Ativo");

    return course;
  }
}
