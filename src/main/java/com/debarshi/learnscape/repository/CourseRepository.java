package com.debarshi.learnscape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.debarshi.learnscape.model.Course;

import java.util.List;

@Repository
@RepositoryRestResource(path = "courses")
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByOrderByNameDesc();

    List<Course> findByOrderByName();
}