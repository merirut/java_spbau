package edu.au.javacourse.springboot.demo.controller;

import edu.au.javacourse.springboot.demo.dto.StudentDto;
import edu.au.javacourse.springboot.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // делает этот контроллер Spring-бином
@RequestMapping(path = "students", produces = "application/json")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET http://<host:port>/student -- все студенты
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    //GET http://<host:port>/student/<id> -- один конкретный студент
    @GetMapping(path = "{idParam}")
    public StudentDto getStudent(@PathVariable("idParam") int id) {  // placeholder -> int id
        return studentService.getStudent(id);
    }

    //POST http://<host:port>/student -- создать студента
    @PostMapping(consumes = "application/json")
    public void createStudent(@RequestBody StudentDto dto) { // json -> StudentDto dto
        studentService.createStudent(dto);
    }
}
