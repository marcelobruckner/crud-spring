package com.bruckner;

import com.bruckner.enums.Category;
import com.bruckner.model.Course;
import com.bruckner.model.Lesson;
import com.bruckner.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course course = new Course();
			course.setName("Angular com Spring");
			course.setCategory(Category.FRONT_END);

			Lesson lesson = new Lesson();
			lesson.setName("Introdução");
			lesson.setYoutubeUrl("xyz");
			lesson.setCourse(course);

			course.getLessons().add(lesson);

			Lesson lesson2 = new Lesson();
			lesson2.setName("Introdução 2");
			lesson2.setYoutubeUrl("xyzz");
			lesson2.setCourse(course);

			course.getLessons().add(lesson2);

			courseRepository.save(course);
		};
	}
}
