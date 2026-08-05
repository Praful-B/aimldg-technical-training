package jar.controller;

import java.util.List;

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
    public List<Student> readAllStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/read/{id}")
    public Student readStudent(@PathVariable Long id) {
        return studentRepo.findById(id).orElse(null);
    }
}
