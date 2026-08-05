package jar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.dto.StudentDto;
import jar.model.Student;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class EditController {
    private final StudentRepo studentRepo;

    public EditController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id, @RequestBody StudentDto student) {
        return studentRepo.findById(id)
                .map(existing -> {
                    existing.setName(student.name());
                    existing.setEmail(student.email());
                    existing.setIp(student.ip());
                    return ResponseEntity.ok(studentRepo.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
