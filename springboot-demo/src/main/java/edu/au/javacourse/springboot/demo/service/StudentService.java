package edu.au.javacourse.springboot.demo.service;

import edu.au.javacourse.springboot.demo.dto.StudentDto;
import edu.au.javacourse.springboot.demo.model.Student;
import edu.au.javacourse.springboot.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // делает сервис Spring-бином
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::toDto).
                toList();
    }

    public StudentDto getStudent(int id) {
        return toDto(studentRepository.findById(id).orElse(null));
    }

    public void createStudent(StudentDto dto) {
        Student student = new Student(dto.getId(), dto.getFirstName(), dto.getLastName());
        studentRepository.save(student);
    }

    private StudentDto toDto(Student entity) {
        if (entity == null) { return null; }
        return new StudentDto(entity.getId(), entity.getFirstName(), entity.getLastName());
    }
}
