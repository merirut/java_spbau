package edu.au.javacourse.springboot.demo.repository;

import edu.au.javacourse.springboot.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // делает репозиторий Spring-бином
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
