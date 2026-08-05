package jar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class ReadController {
    private final StudentRepo studentRepo;

    public ReadController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/read")
    public ResponseEntity<List<Student>> readAllStudents() {
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable Long id) {
        return studentRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
