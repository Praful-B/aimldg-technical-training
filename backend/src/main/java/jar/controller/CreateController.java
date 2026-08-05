package jar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import jar.dto.StudentDto;
import jar.model.Student;
import jar.repo.StudentRepo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class CreateController {
    private final StudentRepo studentRepo;

    public CreateController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto student) {
        Student newStudent = new Student();
        newStudent.setName(student.name());
        newStudent.setEmail(student.email());
        newStudent.setIp(student.ip());
        Student saved = studentRepo.save(newStudent);
        return ResponseEntity.created(URI.create("/api/read/" + saved.getId())).body(saved);
    }
}
